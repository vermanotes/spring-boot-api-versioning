package com.reallybigindex.spring.boot.web.mvc.model;

import lombok.Builder;
import lombok.Value;

/**
 * Item1 model class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@Value
@Builder
public class Item1 {
	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private String name;
}