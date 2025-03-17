Feature: Teste de API com BDD

  Scenario: Validar endpoint GET
    Given que eu defino a URL base como "https://jsonplaceholder.typicode.com"
    When eu faço uma requisição GET para "/posts/1"
    Then o status code deve ser 200
    And o response body deve conter "userId" igual a 1

   
  Scenario: Validar endpoint PUT
    Given que eu defino a URL base como "https://jsonplaceholder.typicode.com"
    When eu faço uma requisição PUT para "/posts/1" com o seguinte body:
      """
      {
        "id": 1,
        "title": "updated title",
        "body": "updated body",
        "userId": 1
      }
      """
    Then o status code deve ser 200
    And o response body deve conter "title" igual a "updated title"

  Scenario: Validar endpoint DELETE
    Given que eu defino a URL base como "https://jsonplaceholder.typicode.com"
    When eu faço uma requisição DELETE para "/posts/1"
    Then o status code deve ser 200




  Scenario: Validar endpoint POST
    Given que eu defino a URL base como "https://jsonplaceholder.typicode.com"
    When eu faço uma requisição POST para "/posts" com o seguinte body:
      """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    Then o status code deve ser 201
    And o response body deve conter "title" igual a "foo"

