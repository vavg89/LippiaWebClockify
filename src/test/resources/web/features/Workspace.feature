@CrearWorkspace
Feature: Crear un Workspace en Clockify

  Background:
    Given Estoy en el dashboard de clockify

  @Regression @Workspace
  Scenario Outline: Crear un nuevo espacio de trabajo <escenario>
    When El usuario hace click en el boton <boton1>
    And El usuario hace click en el boton <boton2>
    And El usuario hace click en el boton <boton3>
    And El usuario ingresa el nombre del espacio de trabajo <escenario> y hace click en el boton CREAR
    Then Se muestra el <var_logica>

    Examples:
      | escenario     | boton1    | boton2                        | boton3                         | boton4          | var_logica                   |
      | correctamente | workspace | gestionar espacios de trabajo | crear nuevo espacio de trabajo | CREAR WORKSPACE | workspace creado como activo |