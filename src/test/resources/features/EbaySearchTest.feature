@SearchRegresion @testRegresion
Feature: Busqueda de productos en eBay

  Background: precondicion
    Given que el usuario navega a la pagina de eBay

  @PrimerElemento
  Scenario: Busqueda de una guitarra electrica y obtencion del precio del primer resultado
    When el usuario busca el siguiente elemento "Electric Guitar"
    And el usuario muestra el precio del primer resultado en la consola

  @BuscarConCategoria
  Scenario Outline: El usuario busca "<Elemento>" en la categoria "<Categoria>"
    When el usuario busca el siguiente elemento "<Elemento>" en la categoria "<Categoria>"
    And el usuario muestra el precio del primer resultado en la consola
    Examples:
      | Elemento        | Categoria |
      | Electric Guitar | Musica    |