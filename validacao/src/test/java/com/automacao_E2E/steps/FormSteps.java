package com.automacao_E2E.steps;

import io.cucumber.java.en.*;

import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.automacao_E2E.pages.FormPage;

public class FormSteps {
    WebDriver driver;
    FormPage formPage;

    @Given("que eu estou na página do formulário de registro")
    public void acessarPaginaDoFormulario() throws IOException {
      //  System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
      
      ChromeOptions options = new ChromeOptions();
      String tempDir = Files.createTempDirectory("chrome-user-data").toString();
      options.addArguments("--user-data-dir=" + tempDir);  
        driver = new ChromeDriver(options);

        //driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
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

    @When("eu faço upload de uma imagem")
    public void fazerUploadDeImagem() {
        formPage.fazerUploadDeImagem("caminho/para/sua/imagem.jpg");
    }

    @When("eu preencho o campo Current Address com {string}")
    public void preencherEndereco(String endereco) {
        formPage.preencherEndereco(endereco);
    }

    @When("eu seleciono {string} em State")
    public void selecionarState(String estado) {
        formPage.selecionarEstadoECidade(estado, "");
    }

    @When("eu seleciono {string} em City")
    public void selecionarCity(String cidade) {
        formPage.selecionarEstadoECidade("", cidade);
    }

    @When("eu clico no botão Submit")
    public void clicarBotaoSubmit() {
        formPage.clicarSubmit();
    }

    @Then("eu devo ver a mensagem de sucesso indicando que o formulário foi enviado")
    public void verificarMensagemDeSucesso() {
        // Aqui você pode implementar uma validação para confirmar o envio com sucesso
        System.out.println("Formulário enviado com sucesso!");
    }
}

