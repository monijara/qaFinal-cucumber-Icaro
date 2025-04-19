@productstore
Feature: Busqueda de productos en Product Store

  Background:
    Given el usuario se encuentra en la home de Product Store

  @LoadProductStore
  Scenario Outline: El usuario entra a la home page
    When el usuario entra
    Then el usuario visualiza el titulo "<titulo>"
    Examples:
      | titulo   |
      | PRODUCT STORE |