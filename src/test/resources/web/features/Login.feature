Feature: Login en clockify web

  Background:
    Given Ingreso a clockify web

  @Regression @Login
  Scenario Outline: El usuario intenta hacer login manualmente con "<caso>"
    When El usuario hace click en el boton <text1>
    And El usuario selecciona el idioma <idioma>
    And El usuario hace click en el boton <text2>
    And El usuario ingresa las credenciales <username> y la contraseña <password> he ingresa
    Then El usuario debe haber <resultado>

    Examples:
      | idioma  | caso          | text1 | text2        | username     | password     | resultado |
      | Español | Datos validos | Login | Login manual | USERNAME_ENV | PASSWORD_ENV | accedido  |