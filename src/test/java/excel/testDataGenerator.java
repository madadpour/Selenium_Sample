package excel;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class testDataGenerator {

    String loginFile = "../Selenium_Sample/testData/login.xlsx";

    @DataProvider(name = "login")
    public Object[][] getDataLogin() throws IOException {
        return ExcelUtils.testData(loginFile, "login");
    }
    @DataProvider(name = "loginNeg")
    public Object[][] getDataLoginNeg() throws IOException {
        return ExcelUtils.testData(loginFile, "loginNeg");
    }

}
