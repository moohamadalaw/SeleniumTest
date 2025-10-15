package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;


    // This method sets the file path and opens the Excel file.
    // Pass Excel Path and Sheet Name as arguments to this method.
    public static void setExcelFile(String Path, String SheetName) throws Exception {
        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e) {
            throw (e);
        }
    }



    // This method reads the test data from the Excel cell.
    // Parameters: Row number and Column number.
    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        } catch (Exception e) {
            return "";
        }
    }


    // This method writes data to the Excel cell.
    // Parameters: Result (value), Row number, and Column number.
    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
        try {
            Row = ExcelWSheet.getRow(RowNum);
            if (Row == null) {
                Row = ExcelWSheet.createRow(RowNum);
            }

            Cell = Row.getCell(ColNum);
            if (Cell == null) {
                Cell = Row.createCell(ColNum);
            }
            Cell.setCellValue(Result);
            // Save the Excel file
            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        } catch (Exception e) {
            throw (e);
        }
    }
}


//package utility;
//
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.ss.usermodel.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelUtils {
//    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException, InvalidFormatException {
//        FileInputStream file = new FileInputStream(new File(filePath));
//        Workbook workbook = WorkbookFactory.create(file);
//        Sheet sheet = workbook.getSheet(sheetName);
//
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//        Object[][] data = new Object[rowCount - 1][colCount]; // To ignore the header row
//
//        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
//            for (int j = 0; j < colCount; j++) {
//                data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
//            }
//        }
//        workbook.close();
//        return data;
//    }
//
//}
