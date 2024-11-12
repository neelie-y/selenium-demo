package com.demo;

import com.demo.pages.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class DemoTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testOpenHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.get("https://www.zurich.com.my/");
        Homepage homepage = new Homepage(driver);

        Assert.assertEquals(homepage.getTitle(), "Home | Zurich Malaysia");
//        wait.until(ExpectedConditions.visibilityOf(homepage.));
        homepage.clickCloseBtn();
        homepage.clickSearchButton();
        homepage.
//        homepage.clickMenuList();
//        homepage.clickBuyOnlineLink();
    }
//    @Test
//     public void testOpenBuyOnlinePage(){
//        BuyOnlinePage buyOnlinePage = new BuyOnlinePage(driver);
//        Assert.assertEquals(buyOnlinePage.getTitle(),"Careers | Zurich Malaysia");
//        Assert.assertEquals(buyOnlinePage.getPageURL(),"https://www.zurich.com.my/online-products");
//   }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }

    }

}
