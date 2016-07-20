package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentResult;
import cn.gaoyuexiang.model.ResultItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CostPriceCalculatorTest {

	private CostPriceCalculator costPriceCalculator = new CostPriceCalculator();

	@Test
	public void check_result() throws Exception {
		Item item = new Item();
		item.setBarcode("ITEM00001");
		item.setName("basketball");
		item.setUnit("个");
		item.setCategory("运动装备");
		item.setSubCategory("ball");
		item.setPrice(200.00);

		PaymentItem paymentItem = new PaymentItem(item, 1);
		paymentItem.setAmount(1);

		ArrayList<PaymentItem> paymentItems = new ArrayList<>();
		paymentItems.add(paymentItem);

		ResultItem resultItem = new ResultItem(item, 1);
		resultItem.setTotal(200);

		PaymentResult paymentResult = new PaymentResult();
		paymentResult.addResultItem(resultItem);

		PaymentResult result = costPriceCalculator.calculate(paymentItems);

		assertThat(result.getResultItems().get(0).getName(),
						equalTo(paymentResult.getResultItems().get(0).getName()));
	}
}