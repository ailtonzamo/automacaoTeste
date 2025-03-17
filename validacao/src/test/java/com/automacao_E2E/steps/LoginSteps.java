package com.automacao_E2E.steps;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.automacao_E2E.pages.DashboardPage;
import com.automacao_E2E.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Given("que eu estou na página de login")
    public void openLoginPage() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
       // String uniqueDir = "/tmp/chrome_session_" + System.nanoTime();
       // options.addArguments("--user-data-dir=" + uniqueDir);
        options.addArguments("--remote-allow-origins=*");
        
        WebDriver driver = new ChromeDriver(options);

        // Maximizar a janela e acessar o formulário
        driver.manage().window().maximize();



        driver.get("https://practice.expandtesting.com/login");
        loginPage = new LoginPage(driver);
    }

    @When("eu insiro {string} e {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clico no botão de login")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

   

    @Then("eu devo ser redirecionado para o dashboard")
    public void validateDashBoardTitle(){
        dashboardPage = new DashboardPage(driver);
        String title = dashboardPage.getPageTitle();
        assertTrue(title.contains("Secure Area page for Automation Testing Practice"));
    }

    @And("o título da página deve conter {string}")
    public void validatePageTitle(String expectedTitle) {
        String title = dashboardPage.getPageTitle();
        assertTrue(title.contains(expectedTitle));
        driver.quit();
    }
}
