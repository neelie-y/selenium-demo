package com.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BuyOnlinePage {

    WebDriver driver;

    public BuyOnlinePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getPageURL(){
        return driver.getCurrentUrl();
    }

}
