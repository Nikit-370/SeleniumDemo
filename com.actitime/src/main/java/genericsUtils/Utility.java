package genericsUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	FileInputStream fis;

	public String ToFetchDataFromPropertyFile(String key) throws IOException {
		fis = new FileInputStream(".\\src\\main\\resources\\data.properties");

		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

	public String toFetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}

	public long toFetchNumbericDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return (long) workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}

	public String toFetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo)
			throws EncryptedDocumentException, IOException {
		fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return "" + workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}

	public String file(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}

}
