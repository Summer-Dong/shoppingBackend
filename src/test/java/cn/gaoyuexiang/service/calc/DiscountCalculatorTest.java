package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DiscountCalculatorTest {

	private DiscountCalculator discountCalculator = new DiscountCalculator();

	@Test
	public void check_result() throws Exception {
		Item item = new Item();
		item.setBarcode("ITEM00001");
		item.setName("basketball");
		item.setUnit("个");
		item.setCategory("运动装备");
		item.setSubCategory("ball");
		item.setPrice(200.00);

		Rule rule = new Rule();
		rule.setName("95折");
		rule.setType(2);

		ArrayList<String> barcodes = new ArrayList<>();
		barcodes.add("ITEM00001");
		rule.setBarcodes(barcodes);

		PaymentItem paymentItem = new PaymentItem(item, 1);
		paymentItem.setRule(rule);
		paymentItem.setAmount(1);

		ArrayList<PaymentItem> paymentItems = new ArrayList<>();
		paymentItems.add(paymentItem);

		ResultItem resultItem = new ResultItem(item, 1);
		resultItem.setSave(10);
		resultItem.setTotal(190);

		ArrayList<ResultItem> resultItems = new ArrayList<>();
		resultItems.add(resultItem);

		PaymentResult paymentResult = new PaymentResult();
		paymentResult.setResultItems(resultItems);
		paymentResult.setTotal(190);
		paymentResult.setSale(10);

		PaymentResult result = discountCalculator.calculate(paymentItems);

		assertThat(result.getResultItems().get(0).getName(),
						equalTo(paymentResult.getResultItems().get(0).getName()));
	}
}