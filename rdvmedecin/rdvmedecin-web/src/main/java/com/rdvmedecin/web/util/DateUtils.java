package com.rdvmedecin.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Skander.Bachouche
 *
 */
public class DateUtils {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	/**
	 * Convert Date To String
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}

	/**
	 * Convert String to Date
	 * 
	 * @param date
	 * @return
	 */
	public static Date StringToDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
			return sdf.parse(date);
		} catch (ParseException e) {
			LOGGER.error("Cannot convert String " + date + " to Date : "+e.getMessage());
			return null;
		}
	}
}
