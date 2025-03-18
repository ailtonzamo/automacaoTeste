package com.automacao_E2E.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    private static WebDriver driver;

    // Método para inicializar o driver
    public static WebDriver getDriver() {
        if (driver == null) {
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
         driver = new ChromeDriver(options);   




            //driver = new ChromeDriver();
            driver.manage().window().maximize();
       //     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    // Método para fechar o driver
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}