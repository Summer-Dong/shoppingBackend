package cn.gaoyuexiang.service.calc;

import cn.gaoyuexiang.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(MockitoJUnitRunner.class)
public class ThreeForTwoCalculatorTest {

	private ThreeForTwoCalculator threeForTwoCalculator =
					new ThreeForTwoCalculator();

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
		rule.setName("买二赠一");
		rule.setType(1);

		ArrayList<String> barcodes = new ArrayList<>();
		barcodes.add("ITEM00001");
		rule.setBarcodes(barcodes);

		PaymentItem paymentItem = new PaymentItem(item, 1);
		paymentItem.setRule(rule);
		paymentItem.setAmount(7);

		ArrayList<PaymentItem> paymentItems = new ArrayList<>();
		paymentItems.add(paymentItem);

		ResultItem resultItem = new ResultItem(item, 7);

		ArrayList<ResultItem> resultItems = new ArrayList<>();
		resultItems.add(resultItem);

		ThreeForTwoItem threeForTwoItem = new ThreeForTwoItem(item, 2);
		ArrayList<ThreeForTwoItem> threeForTwoItems = new ArrayList<>();
		threeForTwoItems.add(threeForTwoItem);

		PaymentResult paymentResult = new PaymentResult();
		paymentResult.setResultItems(resultItems);
		paymentResult.setThreeForTwoItems(threeForTwoItems);
		paymentResult.setTotal(1000);
		paymentResult.setSale(400);

		PaymentResult result = threeForTwoCalculator.calculate(paymentItems);

		assertThat(result.getThreeForTwoItems().get(0).getName(),
						equalTo(paymentResult.getThreeForTwoItems().get(0).getName()));
	}
}