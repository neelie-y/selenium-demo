package com.demo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "btn-global-search")
    private WebElement searchBtn;

    @FindBy(css="#content > div:nth-child(3) > div > div.search-field > div > div.input-search-container.textfield.textfield--float-label.textfield-control > div > input")
    private WebElement searchTextbox;

    public String getSearchPageURL(){
        return driver.getCurrentUrl();
    }

    public void inputSearchTextbox(String keyword) {
        searchTextbox.sendKeys(keyword);
    }
    public void clickOnSearchBtn(){
        searchBtn.sendKeys(Keys.RETURN);
    }

}
