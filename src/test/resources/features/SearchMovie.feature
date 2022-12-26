#language:en

@regression
Feature: App search function

  Background:
    Given the APP is open

  @searchMovie
  Scenario Outline: Search for a movie
    When the user accesses the "Filmes" tab
    And click on the search magnifying glass
    And fill in <Film_Name>
    And click on the movie title
    Then it displays the information of <Film_Name>

    Examples:
      | Film_Name                   |
      | "Avatar: O Caminho da Água" |
      | "Adão Negro"                |
      | "A mulher rei"              |

  @searchDuration
  Scenario: Search movie duration
    When the user accesses the "Filmes" tab
    And click on the search magnifying glass
    And fill in "Pantera negra"
    And click on the movie title
    And it displays the information of "Pantera negra"
    And click on "Detalhes"
    Then "Duração" is displayed
    And "02h 41m" is displayed