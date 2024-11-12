package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

    WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "submit")
    private WebElement confirmBtn;

    @FindBy(className = "close")
    private WebElement closeBtn;

    @FindBy(className = "header-temp-toggle")
    private WebElement menuList;

    @FindBy(className = "menu-search-button")
    private WebElement searchBtn;

    @FindBy(xpath = "//*[@id=\"header\"]/header/nav/div[1]/ul/li[7]/button[2]/span")
    private WebElement searchActionBtn;

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

    public void clickSearchButton() {
        searchBtn.click();
    }

    public void clickSearchEnter() {
        searchActionBtn.click();
    }

    public void searchKeyword(String searchKeyword) throws InterruptedException {
        inputText.sendKeys(searchKeyword);
    }
}
