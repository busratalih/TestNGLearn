package utilities;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import pages.LoginPage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestReport {




    LoginPage lg = new LoginPage();

    @BeforeMethod
    // @Parameters("browser")
    public void setUp() {

        ReusableMethods.goToBaseURL();
        lg.beLogin();

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.attachment("Test Failed",new ByteArrayInputStream(screenshot));
        }else {
            System.out.println("Test Succesfully");
        }
        Driver.closeDriver();
    }
}