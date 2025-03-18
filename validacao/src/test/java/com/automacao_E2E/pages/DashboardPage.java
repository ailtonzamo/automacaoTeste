package com.automacao_E2E.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automacao_E2E.steps.DriverManager;

public class DashboardPage {
    private WebDriver driver;

    
   

    private By pageTitle = By.tagName("h1");
  //  private By pageTitle = By.cssSelector("div.flash");
    private By logoutLink = By.cssSelector("a.button.secondary.radius.btn.btn-danger");

  
    public DashboardPage(WebDriver driver) {
        // Validar se o driver é nulo
        
        this.driver = DriverManager.getDriver();
        if (this.driver == null) {
            throw new IllegalArgumentException("O WebDriver não pode ser nulo.");
        }

    }

    public String getPageTitle() {
          return driver.findElement(pageTitle).getText();
        
    }

  

    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}
