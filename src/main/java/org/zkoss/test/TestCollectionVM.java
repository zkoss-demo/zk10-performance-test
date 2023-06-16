package org.zkoss.test;

import java.util.List;

import org.zkoss.test.service.ItemService;

/**
 * @author jameschu
 */
public class TestCollectionVM {
	private ItemService itemService = ItemService.getInstance();

	public List<String> getList() {
		return itemService.getItems(); //simulate database
	}
}
