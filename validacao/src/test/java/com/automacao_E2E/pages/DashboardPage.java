package com.automacao_E2E.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    
   

    //private By pageTitle = By.tagName("h1");
    private By pageTitle = By.cssSelector("div.flash");


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        
        System.out.println("entrou aquiii "+driver.findElement(pageTitle).getText());
        return driver.findElement(pageTitle).getText();
        
    }
}
