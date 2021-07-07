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
Feature: Connexion de l'utilisateur
  L'action de se connecter sur le site en tant que client 

	@tag1
  Scenario: L'utilisateur se connecte avec son identifiant
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'un identifiant valide
    And L'utilisateur est muni d'un mot de passe valide
    When L'utilisateur renseigne l'identifiant
    And L'utilisateur renseigne le mot de passe
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit arriver sur la page de son compte client
    And L'utilisateur doit être connecté en tant que client

  @tag2
  Scenario: L'utilisateur se connecte avec son adresse mail
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'une adresse mail valide
    And L'utilisateur est muni d'un mot de passe valide
    When L'utilisateur renseigne l'adresse mail
    And L'utilisateur renseigne le mot de passe
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit arriver sur la page de son compte client
    And L'utilisateur doit être connecté en tant que client
    
  @tag3
  Scenario: L'utilisateur se connecte avec un mot de passe vide
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'une identifiant valide
    When L'utilisateur renseigne son identifiant
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit rester sur la page de connexion
    And La page doit afficher un message d'erreur
    
  @tag4
  Scenario: L'utilisateur se connecte avec un mot de passe invalide
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'un identifiant valide
    And L'utilisateur est muni d'un mot de passe invalide
    When L'utilisateur renseigne son identifiant
    And L'utilisateur renseigne son mot de passe
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit rester sur la page de connexion
    And La page doit afficher un message d'erreur
    
  @tag5
  Scenario: L'utilisateur se connecte sans identifiant ou adresse mail
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'un mot de passe valide
    When L'utilisateur renseigne son mot de passe
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit rester sur la page de connexion
    And La page doit afficher un message d'erreur
    
  @tag6
  Scenario: L'utilisateur se connecte avec un identifiant invalide
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'un identifiant invalide
    And L'utilisateur est muni d'un mot de passe valide
    When L'utilisateur renseigne l'identifiant
    And L'utilisateur renseigne le mot de passe
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit rester sur la page de connexion
    And La page doit afficher un message d'erreur
    
  @tag7
  Scenario: L'utilisateur se connecte avec une adresse mail invalide
    Given L'utilisateur se trouve sur la page de connexion
    And L'utilisateur est muni d'une adresse mail invalide
    And L'utilisateur est muni d'un mot de passe valide
    When L'utilisateur renseigne son adresse mail
    And L'utilisateur renseigne son mot de passe
    And L'utilisateur clique sur le bouton LogIn
    Then L'utilisateur doit rester sur la page de connexion
    And La page doit afficher un message d'erreur

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    Examples: 
      | name                | login             | mot_de_passe | status   |
      | identifiant_valide  | test_kadd         | MDPtest_kadd | success  |
      | email_identifiant   | test_kadd@kadd.fr | MDPtest_kadd | success  |
      | mot_de_passe_vide   | test_kadd         |              | fail     |
      | mot_de_passe_errone | test_kadd         | qsx          | fail     |
      | login_vide          | ""                | MDPtest_kadd | fail     |
      | identifiant_errone  | osef              | MDPtest_kadd | fail     |
      | email_errone        | osef@chicken.fr   | MDPtest_kadd | fail     |
