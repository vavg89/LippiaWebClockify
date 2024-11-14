Feature: Login en clockify web

  Background:
    Given Ingreso a clockify web

  @Regression @Login
  Scenario Outline: El usuario intenta hacer login manualmente <escenario>
    When El usuario hace click en el boton <text1>
    And El usuario selecciona el idioma <idioma>
    And El usuario hace click en el boton <text2>
    And El usuario ingresa a clockify <escenario>
    Then El usuario debe haber <resultado>

    Examples:
      | idioma  | escenario         | text1 | text2        | resultado |
      | Español | con datos validos | Login | Login manual | accedido  |