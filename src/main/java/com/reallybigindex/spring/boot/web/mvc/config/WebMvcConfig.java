package com.reallybigindex.spring.boot.web.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

import com.reallybigindex.spring.boot.web.mvc.VersionedRequestMappingHandlerMapping;

/**
 * WebMvcConfig class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@Configuration
public class WebMvcConfig extends DelegatingWebMvcConfiguration {
	
	/**
	 * 
	 */
	@Override
	public VersionedRequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new VersionedRequestMappingHandlerMapping();
	}
}