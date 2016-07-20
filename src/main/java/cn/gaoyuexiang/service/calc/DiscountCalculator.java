package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.model.ResultItem;

import java.util.List;

public class DiscountCalculator implements Calculator {
	@Override
	public PaymentResult calculate(List<PaymentItem> paymentItems) {
		PaymentResult result = new PaymentResult();
		for (PaymentItem item :
						paymentItems) {
			if (item.getRule() == null) continue;
			if (item.getRule().getType() == 2) {
				Integer amount = item.getAmount();
				Double price = item.getItem().getPrice();
				double total = price * amount * 0.95;
				double sale = price * amount * 0.05;
				ResultItem resultItem = new ResultItem(item.getItem(), amount);
				resultItem.setSave(sale);
				resultItem.setTotal(total);
				result.addResultItem(resultItem);
				result.setTotal(result.getTotal() + total);
				result.setSale(result.getSale() + sale);
			}
		}
		return result;
	}
}
