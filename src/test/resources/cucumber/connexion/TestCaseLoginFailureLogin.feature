#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

@tag
Feature: Connexion de l utilisateur
  L action de se connecter sur le site en tant que client 

  @tag1
  Scenario Outline: L utilisateur tente de se connecter avec un login incorrect
		Given <name> - FL - Je me trouve sur la page de connexion
    When <name> - FL - J entre <login> dans le champ "username or email address"
    And <name> - FL - J entre <mot_de_passe> dans le champ "password"
    And <name> - FL - Je clique sur le bouton Log in
    Then <name> - FL - Je dois rester sur la page de connexion
    And <name> - FL - La page doit afficher le message d erreur <error>
    
    Examples: 
      | name                | login           | mot_de_passe | error                                                                         |
      | login_vide          | ""              | MDPtest_kadd | Error: Username is required.                                                  |
      | identifiant_errone  | osef            | MDPtest_kadd | ERROR: The username or password you entered is incorrect. Lost your password? |
      | email_errone        | osef@chicken.fr | MDPtest_kadd | ERROR: The username or password you entered is incorrect. Lost your password? |
