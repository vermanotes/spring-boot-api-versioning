package com.reallybigindex.spring.boot.web.mvc.model;

import lombok.Builder;
import lombok.Value;

/**
 * User model class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@Builder
@Value
public class User {
	/**
	 * 
	 */
	private Long id;
	/**
	 * 
	 */
    private String name;
}
