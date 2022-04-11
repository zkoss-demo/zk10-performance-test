package org.zkoss.zephyr.test.service;

import java.util.Collections;
import java.util.List;

public class ItemService {
	private static ItemService instance = new ItemService();
	private static List<Integer> list = Collections.nCopies(3000, 30);

	private ItemService() {
	}

	public static ItemService getInstance() {
		return instance;
	}

	public List<Integer> getItems() {
		return list;
	}
}
