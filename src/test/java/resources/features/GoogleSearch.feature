@Search
  Feature: Search
    En tant qu'utilisateur, je dois etre capable:
    -daller sur google
    -effectuer une recherche

  @searchGoogle
  Scenario: chercher un texte dans la barre de recherche de google
    Given Je suis sur la page DemoShop
    When Je clique sur dismiss
    Then La fenetre d'info doit disparaitre
    When Je clique sur le bouton mail
    Then il doit etre cliquable et présent
    When Je clique sur le numero telephone
    Then il doit etre cliquable et présent