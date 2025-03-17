Feature: Preenchimento do formulário de registro

  Scenario: Preencher e enviar o formulário com sucesso
    Given que eu estou na página do formulário de registro
    When eu preencho o campo "First Name" com "José"
    And eu preencho o campo "Last Name" com "Silva"
    And eu preencho o campo "Email" com "jose.silva@email.com"
    And eu seleciono o gênero "Male"
    And eu preencho o campo "Mobile" com "1234567890"
    And eu seleciono a data de nascimento como "16 Mar 2025"
    And eu seleciono "Sports" em Hobbies
    And eu preencho o campo "Current Address" com "Rua das Flores, 123"
    And eu seleciono "NCR" em State
    And eu seleciono "Delhi" em City
    And eu clico no botão "Submit"
    Then eu devo ver a mensagem de sucesso indicando que o formulário foi enviado


