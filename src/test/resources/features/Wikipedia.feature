@wikipedia
Feature: Busqueda de productos en wikipedia

  Background:
    Given el usuario se encuentra en la home de wikipedia

  @BuscarWikiepedia
  Scenario Outline: El usuario busca "<articulo>"
    When el usuario busca el siguiente articulo "<articulo>"
    And el usuario hace clic el boton buscar de la pagina home
    Then el usuario visualiza el resultado "<articulo>"
    And usuario visualiza titulo "<titulo>"
    Examples:
      | articulo | titulo   |
      | Selenium | Historia |