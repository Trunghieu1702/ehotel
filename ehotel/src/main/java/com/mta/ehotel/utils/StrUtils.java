package com.mta.ehotel.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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
	
	public static Timestamp convertStringToTimestamp(String strDate) {
		try {
		      DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		       // you can change format of date
		      Date date = formatter.parse(strDate);
		      Timestamp timeStampDate = new Timestamp(date.getTime());

		      return timeStampDate;
		    } catch (ParseException e) {
		      System.out.println("Exception :" + e);
		      return null;
		    }
	}
}
