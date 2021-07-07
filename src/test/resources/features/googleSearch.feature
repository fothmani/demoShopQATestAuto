@Search
Feature: Search
  En tant qu'utilisateur, je dois être capable:
  - d'aller sur la page Google
  - Effectuer une recherche

  @searchGoogle
  Scenario: Chercher un texte dans la bar de recherche de Google
    Given Je suis sur la page de Google
    When J'accepte les cookies
    Then La popup de cookies doit disparaitre
    #When Je saisis le texte "Automatisation des tests"
    #And J'appuie sur l'entrée du clavier
    #Then Je dois être redirigé vers la page ""
    
      Scenario: Chercher un texte dans la bar de recherche de Google
    Given Je suis sur la page de Google
    When J'accepte les cookies
    Then La popup de cookies doit disparaitre
    
      Scenario: Chercher un texte dans la bar de recherche de Google
    Given Je suis sur la page de Google
    When J'accepte les cookies
    Then La popup de cookies doit disparaitre
    
      Scenario: Chercher un texte dans la bar de recherche de Google
    Given Je suis sur la page de Google
    When J'accepte les cookies
    Then La popup de cookies doit disparaitre
    