#language:en

@regression
Feature: App search function

  Background:
    Given the APP is open

  @app_version
  Scenario: App version
    And user click profile button
    When he clicks "Sobre o App"
    Then he sees the app version "Versão"