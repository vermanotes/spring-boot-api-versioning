package com.reallybigindex.spring.boot.web.mvc;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Range;
import com.reallybigindex.spring.boot.VersionData;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * ApiVersionRequestCondition class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@RequiredArgsConstructor
public class ApiVersionRequestCondition implements RequestCondition<ApiVersionRequestCondition> {

	/**
	 * 
	 */
	private static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

	/**
	 * It corresponds only to the minor version
	 */
	private static final String VERSIONED_PATH_PATTERN = "//{version:\\d+\\.\\d+}/**";

	/**
	 * 
	 */
	@NonNull
	private final Set<Range<VersionData>> supported;

	/**
	 * 
	 */
	@Override
	public ApiVersionRequestCondition combine(ApiVersionRequestCondition other) {
		return new ApiVersionRequestCondition(
				ImmutableSet.<Range<VersionData>>builder().addAll(this.supported).addAll(other.supported).build());
	}

	/**
	 * 
	 */
	@Override
	public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest request) {
		VersionData apiVersion = getRequestApiVersion(request);
		if (apiVersion == null) {
			return null;
		}

		return this.supported.stream().anyMatch(range -> range.contains(apiVersion)) ? this : null;
	}

	/**
	 * 
	 */
	@Override
	public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
		return other.supported.size() - this.supported.size();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	private static VersionData getRequestApiVersion(HttpServletRequest request) {
		return Optional
				.ofNullable(PATH_MATCHER.extractUriTemplateVariables(VERSIONED_PATH_PATTERN, request.getRequestURI()))
				.map(map -> map.get("version")).map(version -> {
					try {
						return VersionData.parse(version);
					} catch (Exception e) {
						return null;
					}
				}).orElse(null);
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Version supported. [" + this.supported + "]";
	}
}