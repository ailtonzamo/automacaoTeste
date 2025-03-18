package com.automacao_E2E.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automacao_E2E.steps.DriverManager;

public class LoginPage  {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
   // private By pageTitle = By.cssSelector("div.flash");


    public LoginPage(WebDriver driver) {
       this.driver=DriverManager.getDriver();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement elemento = driver.findElement(loginButton);
      //  elemento.click();
      //   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
         elemento.sendKeys(Keys.RETURN);

       //  System.out.println("entrou aquiii "+driver.findElement(pageTitle).getText());
     
       
    }





}
