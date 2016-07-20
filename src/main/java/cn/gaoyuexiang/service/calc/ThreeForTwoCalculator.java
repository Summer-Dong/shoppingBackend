package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.model.ResultItem;
import cn.gaoyuexiang.model.ThreeForTwoItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThreeForTwoCalculator implements Calculator {
	@Override
	public PaymentResult calculate(List<PaymentItem> paymentItems) {
		PaymentResult result = new PaymentResult();
		for (PaymentItem item :
						paymentItems) {
			if (item.getRule() == null ) continue;
			if (item.getRule().getType() == 1) {
				addToResult(result, item);
			}
		}
		return result;
	}

	private void addToResult(PaymentResult result, PaymentItem item) {
		Integer amount = item.getAmount();
		int giveNumber = getGiveNumber(amount);
		Double price = item.getItem().getPrice();
		double sale = price * giveNumber;
		double total = price * amount - sale;
		ResultItem resultItem = new ResultItem(item.getItem(), amount);
		resultItem.setTotal(total);
		ThreeForTwoItem threeForTwoItem =
						new ThreeForTwoItem(item.getItem(), giveNumber);
		result.setTotal(result.getTotal() + total);
		result.setSale(result.getSale() + sale);
		result.addResultItem(resultItem);
		result.addThreeForTowItem(threeForTwoItem);
	}

	private int getGiveNumber(int amount) {
		if (amount == 1 || amount == 2) return 0;
		if (amount == 3) return 1;
		return 1 + getGiveNumber(amount - 3);
	}
}
