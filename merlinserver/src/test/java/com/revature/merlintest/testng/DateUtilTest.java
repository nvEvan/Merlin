package com.revature.merlintest.testng;

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
  public void convertToDate(String format, String value, String output) {
	  if (output.equals("not null"))
		  Assert.assertNotNull(DateUtil.toDate(value));
	  else 
		  Assert.assertNull(DateUtil.toDate(value));
  }

  @DataProvider
  public Object[][] loadDatesAsStringsFromDataProvider() {
	  return IOUtil.loadSpreadSheet("./src/test/resources/datesdata.xlsx", "dates", String.class,String.class, String.class);
  }
}
