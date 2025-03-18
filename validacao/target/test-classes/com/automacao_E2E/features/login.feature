Feature: Teste de Login e Navegação

  Scenario: Login e navegação até o formulário
  Given que eu estou na página de login
  When eu insiro "practice" e "SuperSecretPassword!"
  And clico no botão de login
  Then eu devo ser redirecionado para o dashboard
  And o título da página deve conter "Secure Area page for Automation Testing Practice"
