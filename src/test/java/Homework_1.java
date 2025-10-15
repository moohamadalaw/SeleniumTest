
import utility.ExcelUtils;

public class Homework_1 {

    public static void main(String[] args) {
        try {
            ExcelUtils.setExcelFile("src/test/java/testData/TestData.xlsx", "Sheet1");
            String data = ExcelUtils.getCellData(1, 2);
            System.out.println("Data from Excel: " + data);
            ExcelUtils.setCellData("mohammad123",1,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

