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
  Scenario Outline: L utilisateur se connecte avec succès sur son compte client
		Given <name> - Je me trouve sur la page de connexion
    When <name> - J entre <login> dans le champ "username or email address"
    And <name> - J entre <mot_de_passe> dans le champ "password"
    And <name> - Je clique sur le bouton Log in
    Then <name> - Je dois arriver sur la page de mon compte client
    And <name> - Je dois être connecté en tant que <login>

    Examples: 
      | name                | login             | mot_de_passe |
      | identifiant_valide  | test_kadd         | MDPtest_kadd |
      | email_valide        | test_kadd@kadd.fr | MDPtest_kadd |
