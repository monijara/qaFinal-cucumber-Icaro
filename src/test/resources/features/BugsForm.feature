@BugsForm
Feature: Completar formulario

  Background:
    Given el usuario se encuentra en la home de BugsForm

  @BugsFormOk
  Scenario Outline: El usuario completa los datos con valores correctos
    When el usuario ingres First Name "<FirstName>"
    And el usuario ingres Last Name "<LastName>"
    And el usuario ingres Phone nunber "<Phonenunber>"
    And el usuario ingres Country "<Country>"
    And el usuario ingres Email address "<EmailAddress>"
    And el usuario ingres Email Password "<Password>"
    And el usuario hace clic boton Register
    Then el usuario visualiza el mensaje "<msjValidacion>"
    Examples:
      | FirstName | LastName | Phonenunber | Country   | EmailAddress    | Password   | msjValidacion                                     |
      | Pepe      | Gomez    | 3512323123  | Argentina | Gomez@gmail.com | 123Usuario | Succesfully registered the following information |
      | Pepe      | Gomez    | 3512323123  | Argentina | Gomez@gmail.com | 123Usuario | Successfully registered the following information |