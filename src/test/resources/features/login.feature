@logingRegresion @testRegresion
Feature: Inicio de sesion en Gmail

  @loginOk
  Scenario: Inicio de sesion exitoso con credenciales validas
    Given que el usuario esta en la pagina de inicio de sesion de Gmail
    When el usuario ingresa un correo electronico y contrasena validos
    And el usuario hace clic en el boton de iniciar sesion
    Then el usuario deberia ver el icono de perfil en la esquina superior derecha

  @loginPassIvalid
  Scenario: Inicio de sesion fallido con contrasena incorrecta
    Given que el usuario esta en la pagina de inicio de sesion de Gmail
    When el usuario ingresa un correo electronico valido y una contrasena incorrecta
    And el usuario hace clic en el boton de iniciar sesion
    Then el usuario deberia ver un mensaje de error que indica contrasena incorrecta

  @loginEmailIvalid
  Scenario: Inicio de sesion fallido con correo electronico invalido
    Given que el usuario esta en la pagina de inicio de sesion de Gmail
    When el usuario ingresa un correo electronico invalido y una contrasena valida
    And el usuario hace clic en el boton de iniciar sesion
    Then el usuario deberia ver un mensaje de error que indica correo electronico invalido

  @loginSetTest
  Scenario Outline: Inicio de sesion con set de datos con resultado de login <LoginOkNoOk>
    Given que el usuario esta en la pagina de inicio de sesion de Gmail
    When el usuario ingresa un correo electronico "<email>" y contrasena "<pass>" los datos son "<LoginOkNoOk>"
    And el usuario hace clic en el boton de iniciar sesion siendo que se espera "<LoginOkNoOk>"
    Then el usuario segun el dato "<LoginOkNoOk>" vera el siguiente mensaje "<msjEsperado>"

    Examples:
      | email                  | pass          | LoginOkNoOk | msjEsperado                                   |
      | LamansysTest@gmail.com | holaMundo1989 | Ok          | LamansysTest@gmail.com                        |
      | LamansysTest@gmail.com | holaMundo198  | passFail    | Contraseña incorrecta                         |
      | LamansysTest@gmail.co  | holaMundo198  | emailFail   | No se ha podido encontrar tu cuenta de Google |
