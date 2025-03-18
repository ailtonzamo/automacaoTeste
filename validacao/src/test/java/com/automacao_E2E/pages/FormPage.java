package com.automacao_E2E.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automacao_E2E.steps.DriverManager;

public class FormPage {
    private WebDriver driver;

    // Localizadores dos elementos da página
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("userEmail");
    private By genderRadioButton = By.xpath("//label[contains(text(), '%s')]"); // Exemplo dinâmico
    private By mobileField = By.id("userNumber");
    private By dateOfBirthInput = By.id("dateOfBirthInput");
    private By hobbiesCheckbox = By.xpath("//label[contains(text(), '%s')]"); // Exemplo dinâmico
    private By uploadPicture = By.id("uploadPicture");
    private By currentAddressField = By.id("currentAddress");
    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");
    private By submitButton = By.id("submit");

    // Construtor para inicializar o WebDriver
    public FormPage(WebDriver driver) {
        this.driver = DriverManager.getDriver();;
    }

    // Métodos de interação com os elementos da página
    public void preencherNome(String firstName, String lastName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void preencherEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selecionarGenero(String genero) {
         String xpath = String.format("//label[contains(text(), '%s')]", genero);

        // Localiza o elemento correspondente ao gênero
        WebElement genderOption = driver.findElement(By.xpath(xpath));

        // Role até o elemento, se necessário
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderOption);

        // Clica no botão de rádio
        genderOption.click();
      

    }

    public void preencherMobile(String mobile) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campoNumero = wait.until(ExpectedConditions.elementToBeClickable(mobileField));
        campoNumero.sendKeys(mobile);
        
        
      //  driver.findElement(mobileField).sendKeys(mobile);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    public void selecionarDataDeNascimento(String month, String year, String day) {
        driver.findElement(dateOfBirthInput).click();
        new Select(driver.findElement(By.className("react-datepicker__month-select"))).selectByVisibleText(month);
        new Select(driver.findElement(By.className("react-datepicker__year-select"))).selectByVisibleText(year);
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + day + "']")).click();
    }

    public void selecionarHobby(String hobby) {
     
        String xpath = String.format("//label[contains(text(), '%s')]", hobby);
        driver.findElement(By.xpath(xpath)).click();

    }

   

    public void preencherEndereco(String endereco) {
        driver.findElement(currentAddressField).sendKeys(endereco);
    }

    public void selecionarEstado(String estado) {
        driver.findElement(stateDropdown).click();
        driver.findElement(By.xpath("//div[contains(text(), '" + estado + "')]")).click();

    }

   public void selecionarCidade(String cidade) {
        driver.findElement(cityDropdown).click();
        driver.findElement(By.xpath("//div[contains(text(), '" + cidade + "')]")).click();
        

        

    }


    public void clicarSubmit() throws InterruptedException {
      
         WebElement elemento = driver.findElement(submitButton);
 
         elemento.sendKeys(Keys.RETURN);
        // Aguarde 5 segundos
        Thread.sleep(5000); // O tempo é em milissegundos (5000 = 5 segundos)

      


        


    }

    public String validarMensagem (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
        
        // Capture o texto do modal
        String modalText = modalTitle.getText();
        return modalText;
         

    }
}
