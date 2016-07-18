package cn.gaoyuexiang.controller;

import cn.gaoyuexiang.model.Item;
import cn.gaoyuexiang.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
	private ItemService itemService;

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> getItems() {
		return itemService.getItems();
	}
}
