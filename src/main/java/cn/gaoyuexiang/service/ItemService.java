package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.InputStream;
import java.util.List;

public class ItemService {
	private SerializeService serializeService;
	private final String ITEM_DS = "item.json";

	ItemService(SerializeService serializeService) {
		this.serializeService = serializeService;
	}

	public List<Item> getItems() {
		InputStream inputStream = getClass().getResourceAsStream(ITEM_DS);
		return serializeService.convertTo(inputStream,
						new TypeReference<List<Item>>() {});
	}
}
