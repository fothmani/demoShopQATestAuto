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
Feature: Connexion de l\'utilisateur
  L\'action de se connecter sur le site en tant que client 

  @tag1
  Scenario Outline: L\'utilisateur se connecte avec succès sur son compte client
		Given Je me trouve sur la page de connexion
    And Je suis muni de l\'identifiant <login>
    And Je suis muni du mot de passe <mot_de_passe>
    When J\'entre <login> dans le champ "username or email address"
    And J\'entre <mot_de_passe> dans le champ "password"
    And Je clique sur le bouton Log in
    Then Je dois arriver sur la page de son compte client
    And Je dois être connecté en tant que <login>

    Examples: 
      | name                | login             | mot_de_passe | status   |
      | identifiant_valide  | test_kadd         | MDPtest_kadd | success  |
      | email_identifiant   | test_kadd@kadd.fr | MDPtest_kadd | success  |
      
	@tag2
  Scenario Outline: L\'utilisateur tente de se connecter avec un mot de passe incorrect
		Given Je me trouve sur la page de connexion
    And Je suis muni de l\'identifiant <login>
    And Je suis muni du mot de passe <mot_de_passe>
    When J\'entre <login> dans le champ "username or email address"
    And J\'entre <mot_de_passe> dans le champ "password"
    And Je clique sur le bouton Log in
    Then Je dois rester sur la page de connexion
    And La page doit afficher un message d\'erreur

    Examples: 
      | name                | login             | mot_de_passe | status   |
      | mot_de_passe_vide   | test_kadd         |              | fail     |
      | mot_de_passe_errone | test_kadd         | qsx          | fail     |

	@tag3
  Scenario Outline: L\'utilisateur tente de se connecter avec un login incorrect
		Given Je me trouve sur la page de connexion
    And Je suis muni de l\'identifiant <login>
    And Je suis muni du mot de passe <mot_de_passe>
    When J\'entre <login> dans le champ "username or email address"
    And J\'entre <mot_de_passe> dans le champ "password"
    And Je clique sur le bouton Log in
    Then Je dois rester sur la page de connexion
    And La page doit afficher un message d\'erreur
    
    Examples: 
      | name                | login             | mot_de_passe | status   |
      | login_vide          | ""                | MDPtest_kadd | fail     |
      | identifiant_errone  | osef              | MDPtest_kadd | fail     |
      | email_errone        | osef@chicken.fr   | MDPtest_kadd | fail     |
