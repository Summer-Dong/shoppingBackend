package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {

	@Mock
	private ItemService itemService;

	private ItemController itemController;

	@Before
	public void setUp() throws Exception {
		itemController = new ItemController(itemService);
	}

	@Test
	public void should_get_one_item() throws Exception {
		Item item = new Item();
		item.setBarcode("ITEM00001");
		item.setName("basketball");
		item.setUnit("个");
		item.setCategory("运动装备");
		item.setSubCategory("ball");
		item.setPrice(199.00);
		ArrayList<Item> items = new ArrayList<>(1);
		items.add(item);
		when(itemService.getItems()).thenReturn(items);
		List<Item> result = itemController.getItems();
		assertThat(items, is(result));
	}
}