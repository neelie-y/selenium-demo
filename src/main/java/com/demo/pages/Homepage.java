package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "submit")
    private WebElement confirmBtn;

    @FindBy(className = "close")
    private WebElement closeBtn;

    @FindBy(className = "header-temp-toggle")
    private WebElement menuList;

    @FindBy(css="#navdrawer > div > div.header-temp-navdrawer-body > nav > div:nth-child(1) > div > ul > li:nth-child(2) > a")
    private WebElement buyOnlineLink;

    @FindBy(className = "menu-search-button")
    private WebElement searchBtn;

    @FindBy(className = "menu-search-input")
    private WebElement inputText;

    public String getTitle() {
        return driver.getTitle();
    }
    public void clickCloseBtn() {
        closeBtn.click();
    }
    public void clickConfirmBtn() {
        confirmBtn.click();
    }
    public void clickMenuList() {
        menuList.click();
    }
    public void clickSearchButton(){ searchBtn.click(); }
    public void clickBuyOnlineLink() {
        buyOnlineLink.click();
    }


}
