package com.revature.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

/**
 * Util class for converting date string to SQL Date instance 
 * @author Luie
 *
 */
@SuppressWarnings("all")
public class DateUtil {
	public static final int SLASH_DELIMITER = 1;
	public static final int DASH_DELIMITER = 2;
	public static final int SPACE_DELIMITER = 3;
	private static final String CONVERT_STRING = "convertStringFormat";
	private static final String CONVERT_DATE = "convertDateFormat";
	private static DateUtil dateUtil = new DateUtil();
	private static Logger logger = Logger.getLogger(DateUtil.class);
	
	/**
	 * Attempts to convert date in string format to SQL Date instance 
	 * @param date - string to convert
	 * @return sql.Date if converted else null
	 */
	public static Date toDate(String date) {
		Date sqlDate = null;
		
	    // Ensure string properly formatted 
		date = date == null ? "" : date.trim();
		
		// log date conversion attempt
		logger.debug("attempting to convert date=['" + date + "']");
		
		// Attempt to find method
		for (Method method : dateUtil.getClass().getDeclaredMethods()) {
			// Only use private helper methods && those who begin with predefined prefix
			if (!method.isAccessible() && method.getName().contains(CONVERT_STRING)) {
				try {
					method.setAccessible(true);
					sqlDate = (Date)method.invoke(dateUtil, date);
				} catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
					logger.warn("issue invoking conversion method, message=['" + e.getMessage() + "']");
				}
				
				method.setAccessible(false);
				
				// If found
				if (sqlDate != null)
					break;
			}
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
		return toDateString(sqlDate, SLASH_DELIMITER);
	}
	
	/**
	 * Attempts to convert sql date to in string format
	 * @param date - sql date
	 * @param delimiter - what seperates date values (use DASH_DELIMITER for '-' and SLASH_DELIMITER for '/')
	 * @return string if converted else null
	 */
	public static String toDateString(Date sqlDate, int delimiter) {
		String date = null;
		String name;
		
		// log date conversion attempt
		logger.debug("attempting to convert date=['" + sqlDate + "']");

		// Attempt to find method
		for (Method method : dateUtil.getClass().getDeclaredMethods()) {
			name = method.getName();
			
			// Only use private helper methods && those who begin with predefined prefix and delimiter
			if (!method.isAccessible() && name.contains(CONVERT_DATE) && validateNameByDelimiter(name, delimiter)) {
				try {
					method.setAccessible(true);
					date = (String)method.invoke(dateUtil, sqlDate);
				} catch (ClassCastException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
					logger.warn("issue invoking conversion method, message=['" + e.getMessage() + "']");
				}
				
				method.setAccessible(false);
				
				// If found
				if (date != null)
					break;
			}
		}
		
		// log result
		logger.debug(date == null ? "failed to convert sql date to string" : "converted to string");
		
		return date;
	}
	
	///
	//	PRIVATE METHODS
	///
	
	/**
	 * Determines conversion type by delimiter value
	 * @param name
	 * @param delimiter
	 * @return true is has delimiter else false
	 */
	private static boolean validateNameByDelimiter(String name, int delimiter) {
		switch (delimiter) {
		case SPACE_DELIMITER:
			return name.contains("_sp_");
		case DASH_DELIMITER:
			return name.contains("_d_");
		case SLASH_DELIMITER:
		default:
				return name.contains("_s_");
		}
	}
	
	/**
	 * Converts string of format dd/MM/yyyy to sql date
	 * @param date - string to convert
	 * @return SQL Date on success else null
	 */
	private static Date convertStringFormatdd_s_MM_s_yyyy(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date sqlDate = null;
		
		try {
			sqlDate = new Date(format.parse(date).getTime());
		} finally {
			return sqlDate;
		}
	}
	
	/**
	 * Converts date of format dd/MM/yyyy to string
	 * @param date - sql date
	 * @return string on success else null
	 */
	private static String convertDateFormatdd_s_MM_s_yyyy(Date sqlDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String date = null;
		
		try {
			date =  format.format(sqlDate);
		} finally {
			return date;
		}
	}
	
	/**
	 * Converts string of format dd-MM-yyyy to sql date
	 * @param date - string to convert
	 * @return SQL Date on success else null
	 */
	private static Date convertStringFormatdd_d_MM_d_yyyy(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date sqlDate = null;
		
		try {
			sqlDate = new Date(format.parse(date).getTime());
		} finally {
			return sqlDate;
		}
	}
	
	/**
	 * Converts date of format dd-MM-yyyy to string
	 * @param date - sql date
	 * @return string on success else null
	 */
	private static String convertDateFormatdd_d_MM_d_yyyy(Date sqlDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = null;
		
		try {
			date =  format.format(sqlDate);
		} finally {
			return date;
		}
	}
	
	/**
	 * Converts string of format dd-MMM-yyyy to sql date
	 * @param date - string to convert
	 * @return SQL Date on success else null
	 */
	private static Date convertStringFormatdd_d_MMM_d_yyyy(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
		Date sqlDate = null;
		
		try {
			sqlDate = new Date(format.parse(date).getTime());
		} finally {
			return sqlDate;
		}
	}
	
	/**
	 * Converts string of format dd MMM yyyy to sql date
	 * @param date - string to convert
	 * @return SQL Date on success else null
	 */
	private static Date convertStringFormatdd_sp_MMM_sp_yyyy(String date) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		Date sqlDate = null;
		
		try {
			sqlDate = new Date(format.parse(date).getTime());
		} finally {
			return sqlDate;
		}
	}
	
	/**
	 * Converts date of format dd MMM yyyy to string
	 * @param date - sql date
	 * @return string on success else null
	 */
	private static String convertDateFormatdd_sp_MMM_sp_yyyy(Date sqlDate) {
		SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy");
		String date = null;
		
		try {
			date =  format.format(sqlDate);
		} finally {
			return date;
		}
	}
	
}
