package com.revature.merlintest.junit;

import org.junit.Assert;
import org.junit.Test;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.dao.CodeListDao;

/**
 * Testing implementations and functionalities of the CodeListDao class.
 * @author Alex
 */
public class CodeListDaoTest {
	
	/**
	 * Test the dao can successfully pull a CodeList object by its id.
	 */
	@Test
	public void getCodeListByIdTest() {
		final String description = "Alabama", code = "US-STATE", value = "AL";
		final int id = 1;
		
		CodeListDao cd = new CodeListDao();
		CodeList cl = null;
		
		cl = cd.getCodeListById(1);
		
		Assert.assertTrue(cd.open());
		Assert.assertEquals(description, cl.getDescription());
		Assert.assertEquals(code, cl.getCode());
		Assert.assertTrue(id == cl.getId());
		Assert.assertEquals(value, cl.getValue());
		
		cd.close();
	}
}