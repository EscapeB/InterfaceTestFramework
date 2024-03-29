package com.yoloho.test.framework;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import com.yoloho.test.framework.api.*;

public class ExcelFileManager {
	/**
	 * Read excel 97-2003 file format
	 * 
	 * @param filePath
	 * @author wujie
	 * @type xls
	 * @throws java.io.IOException
	 */
	@SuppressWarnings("rawtypes")
	public static List<Map> readData(String filePath, String sheetname) throws IOException {
		// Return result set
		List<Map> valueList = new ArrayList<Map>();
		FileInputStream fis = null;
		HSSFSheet sheet = null;
		try {
			fis = new FileInputStream(filePath);
			HSSFWorkbook wookbook = new HSSFWorkbook(fis); // Create the file
															// handler to the
															// excel file
			// HSSFSheet sheet = wookbook.getSheetAt(0); // The index of excel
			// sheet is 0
			if (sheetname.trim().length() == 0) {
				sheet = wookbook.getSheetAt(0);
			} else {
				sheet = wookbook.getSheet(sheetname);
			}

			int rows = sheet.getPhysicalNumberOfRows(); // Get the rows for the
														// sheet 0
			Map<Integer, String> keys = new HashMap<Integer, String>();
			int cells = 0;
			// Ergodic the 1st line(table header) to the key in map
			HSSFRow firstRow = sheet.getRow(0);
			if (firstRow != null) {
				// Read the data in all columns
				cells = firstRow.getPhysicalNumberOfCells();
				// Ergodic columns
				for (int j = 0; j < cells; j++) {
					// Get the values for the columns data
					try {
						HSSFCell cell = firstRow.getCell(j);
						String cellValue = getCellValue(cell);
						keys.put(j, cellValue);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			for (int i = 1; i < rows; i++) {

				HSSFRow row = sheet.getRow(i);

				if (row != null) {

					Map<String, Object> val = new HashMap<String, Object>();

					boolean isValidRow = false;

					for (int j = 0; j < cells; j++) {

						try {
							HSSFCell cell = row.getCell(j);
							String cellValue = getCellValue(cell);
							val.put(keys.get(j), cellValue);
							if (!isValidRow && cellValue != null && cellValue.trim().length() > 0) {
								isValidRow = true;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					if (isValidRow) {
						valueList.add(val);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
		return valueList;
	}

	/**
	 * Read excel 2007-2013 file format
	 * 
	 * @param filePath
	 * @author wujie
	 * @type xlsx
	 */
	@SuppressWarnings("rawtypes")
	public static List<Map> readExcel2007(String filePath) throws IOException {
		List<Map> valueList = new ArrayList<Map>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
			XSSFWorkbook xwb = new XSSFWorkbook(fis);
			XSSFSheet sheet = xwb.getSheetAt(0);
			XSSFRow row;

			Map<Integer, String> keys = new HashMap<Integer, String>();
			row = sheet.getRow(0);
			if (row != null) {
				// System.out.println("j =
				// row.getFirstCellNum()::"+row.getFirstCellNum());
				// System.out.println("row.getPhysicalNumberOfCells()::"+row.getPhysicalNumberOfCells());
				for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {
					// 通过 row.getCell(j).toString() 获取单元格内容，
					if (row.getCell(j) != null) {
						if (!row.getCell(j).toString().isEmpty()) {
							keys.put(j, row.getCell(j).toString());
						}
					} else {
						keys.put(j, "K-R1C" + j + "E");
					}
				}
			}

			for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {
				row = sheet.getRow(i);
				if (row != null) {
					boolean isValidRow = false;
					Map<String, Object> val = new HashMap<String, Object>();
					for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null) {
							String cellValue = null;
							if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
								if (DateUtil.isCellDateFormatted(cell)) {
									cellValue = new DataFormatter().formatRawCellContents(cell.getNumericCellValue(), 0,
											"yyyy-MM-dd HH:mm:ss");
								} else {
									cellValue = String.valueOf(cell.getNumericCellValue());
								}
							} else {
								cellValue = cell.toString();
							}
							if (cellValue != null && cellValue.trim().length() <= 0) {
								cellValue = null;
							}
							val.put(keys.get(j), cellValue);
							if (!isValidRow && cellValue != null && cellValue.trim().length() > 0) {
								isValidRow = true;
							}
						}
					}

					if (isValidRow) {
						valueList.add(val);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}

		return valueList;
	}

	private static String getCellValue(HSSFCell cell) {
		DecimalFormat df = new DecimalFormat("#");
		String cellValue = null;
		if (cell == null)
			return null;
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
				break;
			}
			cellValue = df.format(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_STRING:
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case HSSFCell.CELL_TYPE_FORMULA:
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			cellValue = null;
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_ERROR:
			cellValue = String.valueOf(cell.getErrorCellValue());
			break;
		}
		if (cellValue != null && cellValue.trim().length() <= 0) {
			cellValue = null;
		}
		return cellValue;
	}

	private static String MakeExcelFileName(String path) {
		String filename = "";
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);
		filename = "TestResult" + time + ".xls";
		filename = path + filename;
		return filename;
	}

	public static String CreateExcelFile(String path, String testType) {

		String filepathname;
		filepathname = MakeExcelFileName(path);
		File resultFile = new File(filepathname);

		while (resultFile.exists()) {
			filepathname = MakeExcelFileName(path);
			resultFile = new File(filepathname);
		}

		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(testType);
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("ID");
		cell.setCellStyle(style);
		cell = row.createCell((short) 1);
		cell.setCellValue("Api_Name");
		cell.setCellStyle(style);
		cell = row.createCell((short) 2);
		cell.setCellValue("Api_Version");
		cell.setCellStyle(style);
		cell = row.createCell((short) 3);
		cell.setCellValue("Api_Type");
		cell.setCellStyle(style);
		cell = row.createCell((short) 4);
		cell.setCellValue("TestCase");
		cell.setCellStyle(style);
		cell = row.createCell((short) 5);
		cell.setCellValue("Result");
		cell.setCellStyle(style);
		cell = row.createCell((short) 6);
		cell.setCellValue("Comments");
		cell.setCellStyle(style);
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(filepathname);
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filepathname;
	}

	public static void AppendToTestResult(String excelFilePathName, TestcaseEntry tcEntry) throws IOException {
		FileInputStream fis = new FileInputStream(excelFilePathName);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = null;
		int rows = 0;
		HSSFRow currentRow = null;
		if (tcEntry.TestSuitName.equals("")) {
			sheet = wb.getSheetAt(0);
		} else {
			sheet = wb.getSheet(tcEntry.TestSuitName);
		}
		rows = sheet.getPhysicalNumberOfRows();
		currentRow = sheet.getRow(rows);
		while (currentRow != null) {
			currentRow = sheet.getRow(++rows);
		}
		currentRow = sheet.createRow(rows);
		currentRow.createCell((short) 0).setCellValue(rows);
		currentRow.createCell((short) 1).setCellValue(tcEntry.APIURL);
		currentRow.createCell((short) 2).setCellValue(tcEntry.Version);
		currentRow.createCell((short) 3).setCellValue(tcEntry.APIType);
		currentRow.createCell((short) 4).setCellValue(tcEntry.tcName);
		currentRow.createCell((short) 5).setCellValue(tcEntry.tcResult);
		// currentRow.createCell((short)6).setCellValue(tcEntry.logFile.getPath());
		currentRow.createCell((short) 6).setCellValue(tcEntry.logFile.getName());
		try {
			FileOutputStream fout = new FileOutputStream(excelFilePathName);
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
