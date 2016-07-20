package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.model.PaymentItem;
import cn.gaoyuexiang.model.PaymentRequest;
import cn.gaoyuexiang.model.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PaymentMapperTest {

	@Mock
	private ItemService itemService;

	@Mock
	private RuleService ruleService;

	private PaymentMapper paymentMapper;

	@Before
	public void setUp() throws Exception {
		paymentMapper = new PaymentMapper(itemService, ruleService);
	}

	@Test
	public void should_map_items() throws Exception {
		Item item = new Item();
		item.setBarcode("ITEM00001");
		item.setName("basketball");
		item.setUnit("个");
		item.setCategory("运动装备");
		item.setSubCategory("ball");
		item.setPrice(199.00);
		ArrayList<Item> items = new ArrayList<>(1);
		items.add(item);
		Rule rule = new Rule();
		rule.setName("full off");
		rule.setType(2);
		ArrayList<String> barcodes = new ArrayList<>();
		barcodes.add("ITEM00001");
		rule.setBarcodes(barcodes);
		ArrayList<Rule> rules = new ArrayList<>();
		rules.add(rule);
		PaymentItem paymentItem = new PaymentItem(item, 1);
		paymentItem.setRule(rule);
		ArrayList<PaymentItem> paymentItems = new ArrayList<>();
		paymentItems.add(paymentItem);
		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setItems(barcodes);

		when(itemService.getItems()).thenReturn(items);
		when(ruleService.getRules()).thenReturn(rules);

		List<PaymentItem> result = paymentMapper.map(paymentRequest);

		assertThat(result, equalTo(paymentItems));
	}
}