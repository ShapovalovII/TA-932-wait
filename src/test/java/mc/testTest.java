package mc;

import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.byTa;

public class testTest {
    private WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("https://translate.google.com/?hl=uk#");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(byTa("testName")));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

