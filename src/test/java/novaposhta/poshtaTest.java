package novaposhta;

import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.byTa;

public class poshtaTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("https://novaposhta.ua/");

        driver.findElement(byTa("NovaPoshta:SignUp_BTN")).click();



        driver.findElement(byTa("NovaPoshta:RUS")).click();
        Thread.sleep(2000);
        driver.findElement(byTa("NovaPoshta:UK")).click();

        Thread.sleep(2000);

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
