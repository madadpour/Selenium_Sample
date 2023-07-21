package excel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
    XSSFWorkbook xssfWorkbook;
    XSSFSheet xssfSheet;
    public static Object[][] testData(String excelPath, String sheet) throws IOException {

        ExcelUtils excel = new ExcelUtils();
        excel.getExcelRead(excelPath, sheet);
        int rowNum = excel.getCountRow();
        int colNum = excel.getCountCol();
        Object[][] data = new Object[rowNum - 1][colNum];
        for (int i = 1; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                String cellData = excel.getCellDataString(i, j);
                data[i - 1][j] = cellData;
            }

        }
        return data;
    }

    public void getExcelRead(String excelPath, String sheetName) throws IOException {
        xssfWorkbook = new XSSFWorkbook(excelPath);
        xssfSheet = xssfWorkbook.getSheet(sheetName);
    }

    public int getCountRow() {
        int rowCount = 0;
        try {
            rowCount = xssfSheet.getPhysicalNumberOfRows();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return rowCount;
    }

    public int getCountCol() {
        int colCount = 0;
        try {
            colCount = xssfSheet.getRow(0).getPhysicalNumberOfCells();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return colCount;
    }

    public String getCellDataString(int rowNum, int colNum) {
        String cellData = null;
        try {
            cellData = xssfSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        } catch (Exception exception) {
            System.out.println(exception.getCause());
        }
        return cellData;
    }

}
