package mc;


import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.byTa;
import static io.trueautomation.client.TrueAutomationHelper.ta;

public class mcTest {
    private WebDriver driver;


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
        driver.get("https://samsungshop.com.ua/");

        for (int i = 0; i < 10; i++) {
            driver.findElement(byTa("samsung:main_window:right_arrow")).click();
            System.out.println("\n" + i + "\n");
            Thread.sleep(1000);

        }

        String expectText = "4";

        driver.findElement(byTa("samsung:main_window:4")).click();

        System.out.println(driver.findElement(byTa("samsung:main_window:4")).getText());
        Assert.assertEquals(driver.findElement(byTa("samsung:main_window:4")).getText(),expectText);

        driver.findElement(byTa("samsung:logo")).click();
        Thread.sleep(1000);

        driver.findElement(byTa("samsung:main_window:menu_group")).sendKeys("sv");
        driver.findElement(byTa("samsung:logo_samsung")).click();
        Thread.sleep(1000);

        new Actions(driver).moveToElement(driver.findElement(byTa("samsung:main_window:accessories"))).perform();
        driver.findElement(byTa("samsung:main_window:accessories:protective_films")).click();
        Thread.sleep(1000);

        String actualPriceFrom = "100";
        driver.findElement(byTa("samsung:protective_films:price_from")).clear();
        driver.findElement(byTa("samsung:protective_films:price_from")).sendKeys(actualPriceFrom);
        Assert.assertEquals(actualPriceFrom, driver.findElement(byTa("samsung:protective_films:price_from")).getAttribute("value"));

        String actualPriceBefore = "500";
        driver.findElement(byTa("samsung:protective_films:price_before")).clear();
        driver.findElement(byTa("samsung:protective_films:price_before")).sendKeys(actualPriceBefore);
        Assert.assertEquals(actualPriceBefore, driver.findElement(byTa("samsung:protective_films:price_before")).getAttribute("value"));
        driver.findElement(byTa("samsung:protective_films:price_before")).sendKeys(Keys.RETURN);
        Thread.sleep(1000);

        driver.findElement(byTa("samsung:protective_films:399")).click();
        Thread.sleep(1000);

        new Actions(driver).moveToElement(driver.findElement(byTa("samsung:protective_films:399:characteristic"))).perform();
        Thread.sleep(5000);

        driver.findElement(byTa("samsung:logo_samsung")).click();
        Thread.sleep(1000);

        driver.findElement(byTa("samsung:main_window:tablet")).click();
        Select sortDropDown = new Select(driver.findElement(By.xpath(ta("samsung:tablet:sort_select","(//select[@class='select2-hidden-accessible'])[2]"))));
        sortDropDown.selectByVisibleText("СНАЧАЛА ДЕШЕВЫЕ");

        driver.findElement(byTa("samsung:tablet:black_color")).click();
        Thread.sleep(1000);
        driver.findElement(byTa("samsung:tablet:black_color:close")).click();

        driver.findElement(byTa("samsung:logo_samsung")).click();
        Thread.sleep(1000);



        driver.findElement(byTa("samsung:main_window:shops")).click();
        new Actions(driver).moveToElement(driver.findElement(byTa("samsung:shops:Odessa_town"))).perform();
        String main_window = driver.getWindowHandle();

        driver.findElement(byTa("samsung:shops:Odessa_town:know")).click();

        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(2000);

        for (String window:windowHandles){
            if (window != main_window){
                driver.switchTo().window(window);
                Thread.sleep(10000);
                //driver.findElement(byTa("samsung:logo_samsung")).click();
                //Thread.sleep(2000);
                driver.close();
            }
        }



        //driver.switchTo().window(main_window);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

