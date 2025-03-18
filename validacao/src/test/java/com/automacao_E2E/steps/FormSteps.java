package com.automacao_E2E.steps;


import io.cucumber.java.en.*;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automacao_E2E.pages.DashboardPage;
import com.automacao_E2E.pages.FormPage;

public class FormSteps  {
    private  WebDriver driver;
    FormPage formPage;
 


 


    @Given("que eu estou na página do formulário de registro")
    public void acessarPaginaDoFormulario() throws IOException {
     // Configurar opções do Chrome
   //  ChromeOptions options = new ChromeOptions();
 
    // options.addArguments("--remote-allow-origins=*");
    // options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
    // WebDriver driver = new ChromeDriver(options);
    
   //   driver = new ChromeDriver();
    DriverManager.getDriver().get("https://demoqa.com/automation-practice-form");
         WebDriver driver = DriverManager.getDriver(); // Obtendo o WebDriver
        formPage = new FormPage(driver); // Inicializa o Page Object
       
           

      
    }

    @When("eu preencho o campo {string} com {string}")
    public void preencherCampo(String campo, String valor) {
        if (campo.equalsIgnoreCase("First Name")) {
            formPage.preencherNome(valor, ""); // Para o exemplo
        } else if (campo.equalsIgnoreCase("Last Name")) {
            formPage.preencherNome("", valor); // Para o exemplo
        } else if (campo.equalsIgnoreCase("Email")) {
            formPage.preencherEmail(valor);
        }
    }

    @When("eu seleciono o gênero {string}")
    public void selecionarGenero(String genero) {
        formPage.selecionarGenero(genero);
    }

    @When("eu preencho o campo Mobile com {string}")
    public void preencherMobile(String mobile) {
        formPage.preencherMobile(mobile);
    }

    @When("eu seleciono a data de nascimento como {string}")
    public void selecionarDataDeNascimento(String data) {
        formPage.selecionarDataDeNascimento("March", "2025", "16"); // Ajuste conforme o formato de data
    }

    @When("eu seleciono {string} em Hobbies")
    public void selecionarHobbies(String hobby) {
        formPage.selecionarHobby(hobby);
    }



    @When("eu preencho o campo Current Address com {string}")
    public void preencherEndereco(String endereco) {
        formPage.preencherEndereco(endereco);
    }

    @When("eu seleciono {string} em State")
    public void selecionarState(String estado) {
        formPage.selecionarEstado(estado);
    }

    @When("eu seleciono {string} em City")
    public void selecionarCity(String cidade) {
        formPage.selecionarCidade( cidade);
    }

    @When("eu clico no botão Submit")
    public void clicarBotaoSubmit() throws InterruptedException {
        formPage.clicarSubmit();
    }

    @Then("eu devo ver a mensagem de sucesso indicando que o formulário foi enviado")
    public void verificarMensagemDeSucesso() {
            //  dashboardPage = new DashboardPage(driver); // O driver precisa estar inicializado aqui
        String title = formPage.validarMensagem();
        
    

    // Valide o conteúdo do modal
    String textoEsperado = "Thanks for submitting the form";
    assertTrue(title.contains(textoEsperado));
   
        
        
        // Aqui você pode implementar uma validação para confirmar o envio com sucesso
        System.out.println("Formulário enviado com sucesso!");
    }
}

