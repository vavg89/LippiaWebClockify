@CrearWorkspace
Feature: Crear un Registro de horas en Clockify

  Background:
    Given Estoy en el dashboard de clockify

  @Regression @RegistroHoras
  Scenario Outline: Crear un nuevo registro de horas <escenario>
    When El usuario hace click en el boton <boton1>
    And El usuario hace click en el boton <boton2>
    And El usuario ingresa la fecha <escenario> desde las <horaDesdeProporcionada> hasta las <horaHastaProporcionada> del <fechaProporcionada>
    Then Se visualiza el <var_logica>

    Examples:
      | escenario     | boton1     | boton2 | fechaProporcionada | horaDesdeProporcionada | horaHastaProporcionada | var_logica                   |
      | correctamente | RASTREADOR | Manual | 14/11/2024         | 18:00                  | 19:00                  | registro creado exitosamente |