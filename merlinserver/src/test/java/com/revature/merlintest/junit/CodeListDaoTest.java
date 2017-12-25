package com.revature.merlintest.junit;

import org.junit.Assert;
import org.junit.Test;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.dao.CodeListDao;

/**
 * 
 * @author Alex
 *
 */
public class CodeListDaoTest {
	
	@Test
	public void getCodeListByIdTest() {
		final String codelist_desc_index1 = "Alabama";
		
		CodeListDao cd = new CodeListDao();
		Assert.assertTrue(cd.open());
		
		CodeList cl = cd.getCodeListById(1);
		Assert.assertEquals(codelist_desc_index1, cl.getDescription());
		cd.close();
	}
	
	
}