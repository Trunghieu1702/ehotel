package com.mta.ehotel.utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public final class StrUtils {

	/**
	 * Split string without using regex (should faster than String.split)
	 * 
	 * @param str
	 * @param delim
	 * @return
	 */
	public static String[] split(String str, String delim) {
		return StringUtils.split(str, delim);
	}

	/**
	 * Split string as a list.
	 * 
	 * @param str
	 * @param delim
	 * @return
	 */
	public static List<String> splitAsList(String str, String delim) {
		return Arrays.asList(StringUtils.split(str, delim));
	}

	/**
	 * Check if a string is an email address.
	 * @param email
	 * @return
	 */
	public static boolean isEmailAddress(String email) {
		if (email == null)
			return false;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
							"[a-zA-Z0-9_+&*-]+)*@" + 
							"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
							"A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		return pat.matcher(email).matches();
	}
}
