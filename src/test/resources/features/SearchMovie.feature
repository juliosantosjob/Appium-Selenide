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
      | Film_Name     |
      | "A Freira 2"  |
      | "Oppenheimer" |
      | "Barbie"      |