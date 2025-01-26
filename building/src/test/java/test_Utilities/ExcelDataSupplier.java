package test_Utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {
	@DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        String sheetName = "sheet1"; // Replace this with a dynamic value if needed
        return fetchDataFromExcel("./DataDriven/test1.xlsx", sheetName);
    }

    private Object[][] fetchDataFromExcel(String filePath, String sheetName) throws Exception {
        File excelFile = new File(filePath);

        // Try-with-resources to handle resource cleanup
        try (FileInputStream fis = new FileInputStream(excelFile);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' does not exist in the workbook.");
            }

            int noOfRows = sheet.getPhysicalNumberOfRows();
            int noOfColumns = sheet.getRow(0).getLastCellNum();

            String[][] data = new String[noOfRows - 1][noOfColumns];
            DataFormatter df = new DataFormatter();

            for (int i = 0; i < noOfRows - 1; i++) {
                for (int j = 0; j < noOfColumns; j++) {
                    data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
                }
            }

            return data;
        }
    }
    }
