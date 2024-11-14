Feature: Crear un proyecto en Clockify

  Background:
    Given Estoy en el dashboard de clockify

  @Regression @Proyecto
  Scenario Outline: Crear un nuevo proyecto <escenario>
    When El usuario hace click en el boton <boton1>
    And El usuario hace click en el boton <boton2>
    And El usuario completa el formulario <escenario>
    And El usuario hace click en el boton <boton3>
    Then El usuario visualiza el <var_logica>

    Examples:
      | escenario     | boton1    | boton2               | boton3 | var_logica                    |
      | correctamente | PROYECTOS | CREAR NUEVO PROYECTO | CREAR  | proyecto creado correctamente |

