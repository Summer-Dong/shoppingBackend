package cn.gaoyuexiang.service;

import cn.gaoyuexiang.exception.NoSuchItemException;
import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentMapper {
	private final ItemService itemService;
	private final RuleService ruleService;

	@Autowired
	public PaymentMapper(ItemService itemService, RuleService ruleService) {
		this.itemService = itemService;
		this.ruleService = ruleService;
	}

	List<PaymentItem> map(PaymentRequest paymentRequest) {
		List<Rule> rules = ruleService.getRules();
		List<Item> allItems = itemService.getItems();

		HashMap<String, PaymentItem> paymentItemMap = new HashMap<>();

		paymentRequest.getItems().forEach(item -> {
			PaymentItem paymentItem = parsePayment(item, allItems);
			Rule rule = getSaleByBarcode(rules, paymentItem.getItem());
			paymentItem.setRule(rule);
			String barcode = paymentItem.getItem().getBarcode();
			if (paymentItemMap.containsKey(barcode)) {
				paymentItem.setAmount(paymentItemMap.get(barcode).getAmount() + paymentItem.getAmount());
				paymentItemMap.put(barcode, paymentItem);
			} else paymentItemMap.put(barcode, paymentItem);
		});

		return paymentItemMap.values()
						.stream()
						.map(item -> item)
						.collect(Collectors.toList());

	}

	private Rule getSaleByBarcode(List<Rule> rules, Item item) {
		Optional<Rule> first = rules
						.stream()
						.filter(t -> t.getBarcodes().contains(item.getBarcode()))
						.findFirst();
		return first.orElse(null);
	}

	private PaymentItem parsePayment(String paymentItem, List<Item> items) {
		String[] ps = paymentItem.trim().split("-");
		String barcode = ps[0];
		Optional<Item> matchedItem = items
						.stream()
						.filter(item -> item.getBarcode().equalsIgnoreCase(barcode))
						.findFirst();
		// no item
		if (!matchedItem.isPresent()) {
			throw new NoSuchItemException(String.format("No such item with barcode %s", barcode));
		}
		int amount = ps.length > 1 ? Integer.parseInt(ps[1]) : 1;
		return new PaymentItem(matchedItem.get(), amount);
	}
}
