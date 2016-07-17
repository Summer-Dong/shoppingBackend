package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {

	@Mock
	private SerializeService serializeService;

	private ItemService itemService;

	@Before
	public void setUp() throws Exception {
		itemService = new ItemService(serializeService);
	}

	@Test
	public void should_get_one() throws Exception {
		Item item = new Item();
		item.setBarcode("ITEM00001");
		item.setName("basketball");
		item.setUnit("个");
		item.setCategory("运动装备");
		item.setSubCategory("ball");
		item.setPrice(199.00);
		ArrayList<Item> items = new ArrayList<>(1);
		items.add(item);

		when(serializeService.convertTo(Mockito.any(InputStream.class),
						Mockito.any(TypeReference.class))).thenReturn(items);

		List<Item> result = itemService.getItems();

		assertThat(items, is(result));
	}
}