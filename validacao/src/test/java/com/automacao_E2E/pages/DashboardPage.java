package com.automacao_E2E.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    private By pageTitle = By.tagName("h1");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
