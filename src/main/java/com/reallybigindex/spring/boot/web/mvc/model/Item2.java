package com.reallybigindex.spring.boot.web.mvc.model;

import lombok.Builder;
import lombok.Value;

/**
 * Item2 model class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@Builder
@Value
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
}
