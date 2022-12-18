package steps;

import actions.SearchMovieActions;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchMovieSteps extends SearchMovieActions {

    @When("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String button) {
        searchMovieActions().clickBtnMovie(button);
    }

    @When("click on the search magnifying glass")
    public void click_on_the_search_magnifying_glass() {
        searchMovieActions().clickMagnifier();
    }

    @When("fill in {string}")
    public void fill_in(String nameMovie) {
        searchMovieActions().fillMovie(nameMovie);
    }

    @When("click on the movie title")
    public void click_on_the_movie_title() {
        searchMovieActions().clickMovieTitle();
    }

    @When("click on {string}")
    public void click_on(String txtBtn) {
        searchMovieActions().tapText(txtBtn);
    }

    @Then("{string} is displayed")
    public void is_displayed(String msgDisplayed) {
        searchMovieActions().textDisplayed(msgDisplayed);
    }

    @Then("it displays the information of {string}")
    public void it_displays_the_information_of(String nameMovie) {
        $(searchMovieActions().movieTitle()).shouldBe(visible);
        $(searchMovieActions().movieTitle()).shouldHave(text(nameMovie));
    }
}