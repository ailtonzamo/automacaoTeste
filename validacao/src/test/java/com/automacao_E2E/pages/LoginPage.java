package com.automacao_E2E.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement elemento = driver.findElement(loginButton);
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
         elemento.sendKeys(Keys.RETURN);
       
    }
}
