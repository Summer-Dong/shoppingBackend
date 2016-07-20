package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.model.ResultItem;

import java.util.List;

public class CostPriceCalculator implements Calculator {
	@Override
	public PaymentResult calculate(List<PaymentItem> paymentItems) {
		PaymentResult result = new PaymentResult();
		paymentItems.stream().filter(item -> item.getRule() == null).forEach(item -> {
			double total = item.getItem().getPrice() * item.getAmount();
			ResultItem resultItem = new ResultItem(item.getItem(), item.getAmount());
			resultItem.setTotal(total);
			result.addResultItem(resultItem);
			result.setTotal(result.getTotal() + total);
		});
		return result;
	}
}
