package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Generalizes common IO functionality 
 * @author Luie
 */
public class IOUtil {
	public static final String MAIN_RESOURCE = "./src/main/resources/";
	public static final String TEST_RESOURCE = "./src/test/resources/";
	private static Logger logger = Logger.getLogger(IOUtil.class);
	
	/**
	 * Loads data from spread sheet into memory
	 * @param source - excel file to read from
	 * @param sheetName - sheet in file to read
	 * @param classes - cell types (String,Double,Boolean,Date are valid class types)
	 * @return Data contained in sheet on successful load else null
	 */
	public static Object[][] loadSpreadSheet(String source, String sheetName, Class<?>... classes) {
		List<Object[]> data = new ArrayList<>();
		Object[] dataRow = null;
		FileInputStream fis;
		File file;
		Workbook book;
		Sheet sheet;
		int rowNum;

		logger.debug("attempting to load spread sheet='" + sheetName + "' from excel file='" + source + "' into memory");
		
		try {
			file = new File(source);
			fis = new FileInputStream(file);
			book = new XSSFWorkbook(fis);
			sheet = book.getSheet(sheetName);
			rowNum = sheet.getLastRowNum() - sheet.getFirstRowNum();

			// Build data list
			for (int i = 1; i <= rowNum; i++) {
				Row row = sheet.getRow(i);
				
				// If non-empy row
				if ((dataRow = extractDataFromRow(row, classes)) != null)
					data.add(dataRow);
			}
		} catch (IOException e) {
			logger.debug("failed to load spread sheet into memory, error message=" + e.getMessage());
			e.printStackTrace();
		}

		// Convert all non-empty rows to 2d-array
		return data.toArray(new Object[data.size()][]);
	}
	
	///
	//	PRIVATE METHODS 
	///
	
	/**
	 * Determines if row is empty (if empty it is excluded 
	 * @param row - what to check
	 * @return true if all cells are null else false.
	 */
	private static boolean isEmptyRow(Object[] row) {
		boolean isEmpty = true;
		
		for (Object item : row) {
			if (item != null) {
				isEmpty = false;
				break;
			}
		}
			
		return isEmpty;
	}
	
	/**
	 * Extract data from row using class set for appropriate types
	 * @param row
	 * @param classes
	 * @return Data contained in rows
	 */
	private static Object[] extractDataFromRow(Row row, Class<?>[] classes) {
		Object[] data = new Object[classes.length];
		int size = classes.length;
	
		for (int i = 0; i < size; i++)
			data[i] = extractDataFromCell(row.getCell(i), classes[i]);
		
		return isEmptyRow(data) ? null : data;
	}
	
	/**
	 * Extracts cell data with appropriate type
	 * @param cell
	 * @param clazz
	 * @return Data contained in cell if class type well defined else null
	 */
	private static Object extractDataFromCell(Cell cell, Class<?> clazz) {
		String name = clazz == null ? "" : clazz.getSimpleName().toLowerCase();
		
		try {
			switch (name) {
				case "string":
					name = cell.getStringCellValue();
					return name.length() > 0 ? name : null;
				case "double":
					return cell.getNumericCellValue();
				case "date":
					return cell.getDateCellValue();
				case "boolean":
					return cell.getBooleanCellValue();
				default:
					return null;
			}
		} catch (Exception e) {
			String str = cell == null ? "" : cell.toString();
			return str.length() == 0 ? null : str;
		}
	}	
}
