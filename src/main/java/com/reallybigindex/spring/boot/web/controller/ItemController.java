package com.reallybigindex.spring.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reallybigindex.spring.boot.web.annotation.ApiVersion;
import com.reallybigindex.spring.boot.web.mvc.model.Item1;
import com.reallybigindex.spring.boot.web.mvc.model.Item2;

/**
 * ItemController class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@RestController
@RequestMapping
@ApiVersion("1.0")
public class ItemController {

	/**
	 * getItem API version 1.0
	 * 
	 * @param id
	 *            id of the item.
	 * @return instance of Item1 class
	 */
	@GetMapping("/items/{id}")
	@ApiVersion("1.0")
	public Item1 getItem(@PathVariable Integer id) {
		return new Item1(id, "iPhone 7");
	}

	/**
	 * getItem API version greater than 1.0
	 * 
	 * @param id
	 *            id of the item.
	 * @return instance of Item1 class
	 */
	@GetMapping("/items/{id}")
	@ApiVersion(greaterThan = "1.0")
	public Item2 getItem(@PathVariable Long id) {
		return new Item2(id, "iPhone 8", 999.0);
	}
}