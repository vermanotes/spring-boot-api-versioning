package com.reallybigindex.spring.boot.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reallybigindex.spring.boot.web.annotation.ApiVersion;
import com.reallybigindex.spring.boot.web.mvc.model.User;

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
public class UserController {

	/**
	 * getUser API version supported 1.0 and 3.1
	 * 
	 * @param id
	 *            id of the user.
	 * @return User object
	 */
	@GetMapping("/users/{id}")
	@ApiVersion(supported = { "1.0", "3.1" })
	public User getUser(@PathVariable Long id) {
		return User.builder()
				.id(id)
				.name("Sushil Verma")
				.build();
	}
}
