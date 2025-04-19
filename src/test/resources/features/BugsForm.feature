@BugsForm
Feature: Completar formulario

  Background:
    Given el usuario se encuentra en la home de BugsForm

  @BugsFormOk
  Scenario Outline: El usuario completa los datos con valores correctos
    When el usuario ingres Full Name "<FullName>"
    And el usuario ingres Email address "<EmailAddress>"
    And el usuario ingres Phone nunber "<Phonenunber>"
    And el usuario ingres Message "<Message>"
    And el usuario hace clic boton Register
    Then el usuario visualiza el mensaje "<msjValidacion>"
    Examples:
      | FullName   | EmailAddress     | Phonenunber | Message       | msjValidacion                                     |
      | Pepe       | Gomez@gmail.com  | 3512323123  | Test message  | ¡El envío del formulario fue exitoso! |
