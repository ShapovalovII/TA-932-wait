import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.byTa;
import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;
    private By loginBtn = By.xpath(ta("loginBtn", "//div[./span[text()='Login']]"));
    private By signupBtn = By.cssSelector(ta("signupBtn", "div.sign-up-container > a"));
    private By emailFl = By.name(ta("emailFl", "email"));

    @BeforeTest
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new TrueAutomationDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @Test
    public void exampleTest() throws InterruptedException {

        WebDriverWait wait=new WebDriverWait(driver, 20);


        driver.get("https://www.advantour.com/rus/kazakhstan/astana.htm");

//        driver.findElement(byTa("advantour:EN")).click();
//        Thread.sleep(2000);
//
//        driver.findElement(byTa("advantour:RU")).click();
//        Thread.sleep(2000);

        //driver.findElement(byTa("advantour:RU")).wait()
        WebElement foo = wait.until(ExpectedConditions.visibilityOfElementLocated(byTa("testName")));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
