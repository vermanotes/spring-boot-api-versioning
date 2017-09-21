package com.reallybigindex.spring.boot.web.mvc.model;

/**
 * User model class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
public class User {
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
	private String name;

	/**
	 * User field constructor
	 * 
	 * @param id
	 * @param name
	 */
	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}