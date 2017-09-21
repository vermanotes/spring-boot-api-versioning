package com.reallybigindex.spring.boot.web.mvc.model;

/**
 * Item1 model class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
public class Item1 {
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String name;
	
	public Item1(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}