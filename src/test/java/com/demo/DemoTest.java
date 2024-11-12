package com.demo;

import com.demo.pages.Homepage;
import com.demo.pages.SearchResultPage;
import com.demo.utils.CSVReaderUtils;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)

public class DemoTest {

    private WebDriver driver;

    private CSVReaderUtils csvReaderUtils;
    private SearchResultPage searchPage;
    private Homepage homepage;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testOpenHomePage() throws InterruptedException {
        driver.get("https://www.zurich.com.my/");
        homepage = new Homepage(driver);
        SearchResultPage searchPage = new SearchResultPage(driver);
        Assert.assertEquals(homepage.getTitle(), "Home | Zurich Malaysia");
//        wait.until(ExpectedConditions.visibilityOf(homepage.));
        homepage.clickCloseBtn();
        homepage.clickSearchButton();
        homepage.searchKeyword("contacts");
        homepage.clickSearchEnter();
        Thread.sleep(20000);
        Assert.assertEquals(searchPage.getSearchPageURL(), "https://www.zurich.com.my/search?keyphrase=contacts&page=1");

    }

    @Test
    public void testSearchPage() throws InterruptedException{
        driver.get("https://www.zurich.com.my/search");
        csvReaderUtils = new CSVReaderUtils();
        List<String[]> searchKeywordsList = csvReaderUtils.getTestData("src/resources/data/data.csv");
        for (String[] searchKeywords : searchKeywordsList) {
            for (String keyword : searchKeywords) {
                searchPage = new SearchResultPage(driver);
                String[] splitKeywords = keyword.split(",");
                Thread.sleep(5000);
                searchPage.inputSearchTextbox(splitKeywords[0].toString());
//                searchPage.clickOnSearchBtn();
                Thread.sleep(5000);
                Assert.assertEquals(searchPage.getSearchPageURL(), splitKeywords[1].toString());
            }

        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }

    }

}
