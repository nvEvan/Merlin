package com.revature.merlintest.testng;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.util.DateUtil;
import com.revature.util.IOUtil;

public class DateUtilTest {
  @BeforeSuite(groups="smoke")
  public void beforeSuite() {
  }
	
  @Test(groups="smoke", dataProvider = "loadDatesAsStringsFromDataProvider")
  public void convertToDateFromString(String value, String output) {
	  if (output.equals("not null"))
		  Assert.assertNotNull(DateUtil.toDate(value));
	  else 
		  Assert.assertNull(DateUtil.toDate(value));
  }
  
  @Test(groups="smoke", dataProvider = "loadDatesFromDataProvider")
  public void convertToStringFrom(String format, Date date, String output) {
	  java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	  
	  switch (format) {
	  case "dash":
		  Assert.assertEquals(DateUtil.toDateString(sqlDate, DateUtil.DASH_DELIMITER), output.trim());
		  break;
	  case "slash":
		  Assert.assertEquals(DateUtil.toDateString(sqlDate, DateUtil.SLASH_DELIMITER), output.trim());
		  Assert.assertEquals(DateUtil.toDateString(sqlDate), output.trim());
		  break;
	  case "space":
		  Assert.assertEquals(DateUtil.toDateString(sqlDate, DateUtil.SPACE_DELIMITER), output.trim());
		  break;
	  }
  }

  @DataProvider
  public Object[][] loadDatesAsStringsFromDataProvider() {
	  return IOUtil.loadSpreadSheet("./src/test/resources/datesdata.xlsx", "datestrings", String.class, String.class);
  }
  
  @DataProvider
  public Object[][] loadDatesFromDataProvider() {
	  return IOUtil.loadSpreadSheet("./src/test/resources/datesdata.xlsx", "dates", String.class, Date.class, String.class);
  }
}
