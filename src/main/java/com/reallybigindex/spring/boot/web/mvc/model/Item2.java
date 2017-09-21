package com.reallybigindex.spring.boot.web.mvc.model;

/**
 * Item2 model class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
public class Item2 {
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Double price;

	/**
	 * Item2 field constructor
	 * 
	 * @param id
	 * @param name
	 * @param price
	 */
	public Item2(Long id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}
}