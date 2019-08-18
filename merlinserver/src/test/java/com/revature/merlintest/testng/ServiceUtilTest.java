package com.revature.merlintest.testng;

import org.testng.annotations.Test;

import com.revature.util.IOUtil;
import com.revature.util.ServiceUtil;

import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class ServiceUtilTest {
  @Test(groups="smoke", dataProvider = "loadValidEmailDataProvider")
  public void validEmailsShouldReturnTrue(String email) {
	  Assert.assertTrue(ServiceUtil.validateEmail(email));
  }
  
  @Test(groups="smoke", dataProvider = "loadInvalidEmailDataProvider")
  public void invalidEmailsShouldReturnFalse(String email) {
	  Assert.assertFalse(ServiceUtil.validateEmail(email));
  }


  @DataProvider
  public Object[][] loadValidEmailDataProvider() {
    return IOUtil.loadSpreadSheet("./src/test/resources/emailsdata.xlsx", "valid", String.class);
  }
  
  @DataProvider
  public Object[][] loadInvalidEmailDataProvider() {
    return IOUtil.loadSpreadSheet("./src/test/resources/emailsdata.xlsx", "invalid", String.class);
  }
  
  @BeforeSuite
  public void beforeSuite() {
  }

}
