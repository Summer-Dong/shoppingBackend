package cn.gaoyuexiang.service;

import cn.gaoyuexiang.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ItemService {
	private SerializeService serializeService;
	private final String ITEM_DS = "/item.json";

	@Autowired
	ItemService(SerializeService serializeService) {
		this.serializeService = serializeService;
	}

	public List<Item> getItems() {
		InputStream inputStream = getClass().getResourceAsStream(ITEM_DS);
		return serializeService.convertTo(inputStream,
						new TypeReference<List<Item>>() {});
	}
}
