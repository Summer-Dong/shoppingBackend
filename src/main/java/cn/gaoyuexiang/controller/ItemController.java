package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemController {
	private ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	public List<Item> getItems() {
		return itemService.getItems();
	}
}
