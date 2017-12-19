package com.revature.merlinservertests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Test;

import com.revature.util.DateUtil;

public class DateUtilTest {

	@Test
	public void shouldNotBeAbleToConvert() {
		assertNull(DateUtil.toDate("abc123"));
		assertNull(DateUtil.toDate("12/1233-12"));
		assertNull(DateUtil.toDate(null));
	}
	
	@Test
	public void shouldConvertDate10sNovs2000ToString() {
		String stamp = "10/11/2000";
		Date date;
		
		assertNotNull(date = DateUtil.toDate(stamp));
		assertNotNull(DateUtil.toDateString(date));
		assertEquals(stamp, DateUtil.toDateString(date));
	}
	
	@Test
	public void shouldConvertString10sNovs2000ToDate() {
		assertNotNull(DateUtil.toDate("10/11/2000"));
	}
	
	@Test
	public void shouldConvertDate10dNovd2000ToString() {
		String stamp = "10-11-2000";
		Date date;
		
		assertNotNull(date = DateUtil.toDate(stamp));
		assertNotNull(DateUtil.toDateString(date));
		assertEquals(stamp, DateUtil.toDateString(date, DateUtil.DASH_DELIMITER));
		assertNotEquals(stamp, DateUtil.toDateString(date, DateUtil.SLASH_DELIMITER));
	}
	
	@Test
	public void shouldConvertString10dNovd2000ToDate() {
		assertNotNull(DateUtil.toDate("10-11-2000"));
	}
	
	
}
