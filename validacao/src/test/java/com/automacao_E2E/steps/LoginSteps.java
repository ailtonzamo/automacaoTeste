package com.automacao_E2E.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.automacao_E2E.pages.DashboardPage;
import com.automacao_E2E.pages.LoginPage;




public class LoginSteps  {
    private  WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Before
    public void setUp() {
      //  driver.get("https://practice.expandtesting.com/login");
        DriverManager.getDriver().get("https://practice.expandtesting.com/login");
     //   driver.manage().window().maximize();
    }
 
    

    @Given("que eu estou na página de login")
    public void openLoginPage() throws IOException {
 

    //  WebDriver driver = new ChromeDriver();
        // Maximizar a janela e acessar o formulário
      //  driver.manage().window().maximize();



       WebDriver driver = DriverManager.getDriver(); // Obtendo o WebDriver
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
        DashboardPage dashboardPage = new DashboardPage(driver);
     //   dashboardPage = new DashboardPage(driver);
        String title = dashboardPage.getPageTitle();
        assertTrue(title.contains("Secure Area page for Automation Testing Practice"));
     //       driver.quit();

   
    }

    @And("o título da página deve conter {string}")
    public void validatePageTitle(String expectedTitle) {
         dashboardPage = new DashboardPage(driver); // O driver precisa estar inicializado aqui
        String title = dashboardPage.getPageTitle();
        assertTrue(title.contains(expectedTitle));

    }


}
