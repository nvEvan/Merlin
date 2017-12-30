package com.revature.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Util class for converting date string to SQL Date instance 
 * @author Luie
 *
 */
@SuppressWarnings("all")
public class DateUtil {
	private static DateUtil dateUtil = new DateUtil();
	private static Logger logger = Logger.getLogger(DateUtil.class);
	private static List<String> formats;
	
	/**
	 * Ensure formats initialized once 
	 */
	static {
		initFormats();
	}
	
	/**
	 * Attempts to convert date in string format to SQL Date instance 
	 * @param date - string to convert
	 * @return sql.Date if converted else null
	 */
	public static Date toDate(String date) {
		Date sqlDate = null;
		String dir = System.getProperty("user.dir");
		
	    // Ensure string properly formatted 
		date = date == null ? "" : date.trim();
		
		// log date conversion attempt
		logger.debug("attempting to convert date=['" + date + "']");
		
		// Attempt to find method
		for (String format : formats) {
			sqlDate = convertStringFormat(date, format);
			
			// If found
			if (sqlDate != null)
				break;
		}
		
		// log result
		logger.debug(sqlDate == null ? "failed to convert string to sql date" : "converted to sql date");
		
		return sqlDate;
	}
	
	/**
	 * Attempts to convert sql date to in string format
	 * @param date - sql date
	 * @return string if converted else null
	 */
	public static String toDateString(Date sqlDate) {
		return toDateString(sqlDate, formats.get(0));
	}
	
	/**
	 * Attempts to convert sql date to in string format
	 * @param date - sql date
	 * @param delimiter - what seperates date values (use DASH_DELIMITER for '-' and SLASH_DELIMITER for '/')
	 * @return string if converted else null
	 */
	public static String toDateString(Date sqlDate, String format) {
		String date = null;
		String name;
		
		// log date conversion attempt
		logger.debug("attempting to convert date=['" + sqlDate + "']");

		// Convert
		date = convertDateFormat(sqlDate, format);
		
		// log result
		logger.debug(date == null ? "failed to convert sql date to string" : "converted to string");
		
		return date;
	}
	
	///
	//	PRIVATE METHODS
	///
	
	/**
	 * Initialize predefined date formats 
	 */
	private static void initFormats() {
		formats =  new ArrayList<>();
		
		for (Object[] row : IOUtil.loadSpreadSheet(IOUtil.MAIN_RESOURCE + "data.xlsx", "dateformats", String.class)) 
			formats.add((String)row[0]);
	}
	
	/**
	 * Converts date of specified forma to string
	 * @param date - sql date
	 * @param format - format to convert to
	 * @return string on success else null
	 */
	private static String convertDateFormat(Date sqlDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date = null;
		
		try {
			date =  sdf.format(sqlDate);
		} finally {
			return date;
		}
	}
	
	/**
	 * Converts string of specified format to sql date
	 * @param date - string to convert
	 * @param format - format to convert to
	 * @return SQL Date on success else null
	 */
	private static Date convertStringFormat(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date sqlDate = null;
		
		try {
			sqlDate = new Date(sdf.parse(date).getTime());
		} finally {
			return sqlDate;
		}
	}
}
