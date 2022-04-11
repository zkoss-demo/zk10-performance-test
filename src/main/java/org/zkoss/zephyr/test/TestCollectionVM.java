package org.zkoss.zephyr.test;

import java.util.List;

import org.zkoss.zephyr.test.service.ItemService;

/**
 * @author jameschu
 */
public class TestCollectionVM {
	private ItemService itemService = ItemService.getInstance();

	public List<Integer> getList() {
		return itemService.getItems(); //simulate database
	}
}
