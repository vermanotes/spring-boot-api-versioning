package com.reallybigindex.spring.boot;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import lombok.Data;

/**
 * VersionData class
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@Data
public class VersionData implements Comparable<VersionData> {

	private static final String DELIMITER = ".";
	private static final Joiner JOINER = Joiner.on(DELIMITER).skipNulls();
	private static final Splitter SPLITTER = Splitter.on(DELIMITER).trimResults().omitEmptyStrings();

	private final String version;
	private final int major;
	private final int minor;
	private final int revision;

	/**
	 * VersionData constructor
	 * 
	 * @param major
	 *            version major number
	 * @param minor
	 *            version minor number
	 * @param revision
	 *            version resision
	 */
	public VersionData(@Nonnull Integer major, @Nullable Integer minor, @Nullable Integer revision) {
		this.major = major;
		this.minor = minor != null ? minor : 0;
		this.revision = revision != null ? revision : 0;
		this.version = JOINER.join(Arrays.asList(major, minor, revision));
	}

	/**
	 * Parsing version number and return VersionData object.
	 * 
	 * @param version
	 *            version number
	 * @return VersionData object.
	 */
	public static VersionData parse(@Nonnull String version) {
		Assert.isTrue(StringUtils.isNotBlank(version), "Version should not be blank.");
		List<String> splited = SPLITTER.splitToList(version);
		Assert.isTrue(splited.stream().allMatch(StringUtils::isNumeric), "Version should be numeric.");
		Assert.isTrue(!splited.isEmpty(), "Version should have major version number.");
		Integer major = Integer.valueOf(splited.get(0));
		Integer minor = splited.size() > 1 ? Integer.valueOf(splited.get(1)) : null;
		Integer revision = splited.size() > 2 ? Integer.valueOf(splited.get(2)) : null;
		return new VersionData(major, minor, revision);
	}

	/**
	 * Compares this object with the specified object for order. Returns a negative
	 * integer, zero, or a positive integer as this object is less than, equal to,
	 * or greater than the specified object.
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(@Nonnull VersionData other) {
		int diff;
		diff = this.major - other.major;

		if (diff == 0) {
			diff = this.minor - other.minor;

			if (diff == 0) {
				diff = this.revision - other.revision;
			}
		}
		return diff;
	}

	/**
	 * 
	 * @param version
	 *            version number as String.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */
	public int compareTo(@Nonnull String version) {
		return this.compareTo(VersionData.parse(version));
	}

	/**
	 * Overwriting toString method to print version number.
	 */
	@Override
	public String toString() {
		return this.version;
	}
}
