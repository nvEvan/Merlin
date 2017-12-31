package com.revature.merlinserver.dao;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalFileUpload;
import com.revature.merlinserver.beans.MagicalUser;

/**
 * Dao for performing CRUD on magical file
 * @author Alex
 */
public class MagicalFileDao extends MerlinSessionDao<MagicalUser> {

	/**
	 * Insert our file into the RDS
	 * @param user
	 * @param file
	 * @param fileName
	 * @param fileType
	 */
	public void insertFile(MagicalUser user, byte[] file, String fileName, CodeList fileType) {
		if (isReady()) {
			MagicalFileUpload magicalFile = new MagicalFileUpload(user, fileType, fileName, file);
			
			session.save(magicalFile);
		}
	}
}