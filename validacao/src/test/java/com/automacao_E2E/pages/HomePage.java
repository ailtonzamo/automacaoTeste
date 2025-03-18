package com.automacao_E2E.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automacao_E2E.steps.DriverManager;

import groovyjarjarantlr4.v4.parse.ANTLRParser.elementEntry_return;

import java.time.Duration;


public class HomePage {
    private WebDriver driver;

    // Elementos da página
    private By searchField = By.xpath("//input[@placeholder='Enter keywords...']");
    private By searchButton = By.xpath("//button[text()='Search']");
    private By addToCartButton = By.xpath("//*[@id='books']/div/div/div/a[2]");
    private By cartTotal = By.id("cart-total");

    public HomePage(WebDriver driver) {
        this.driver = DriverManager.getDriver();
    }
    

    // Métodos para interagir com a página
    public void searchBook(String bookName) {
        driver.findElement(searchField).sendKeys(bookName);
        driver.findElement(searchButton).click();
    }

    public void addFirstBookToCart() {
   
       
    WebElement elemento = driver.findElement(addToCartButton);
   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elemento);
    elemento.sendKeys(Keys.RETURN);
 

    }

    public String getCartTotal() {
        return driver.findElement(cartTotal).getText();
    }
}


