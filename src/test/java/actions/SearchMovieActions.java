package actions;

import com.codeborne.selenide.SelenideElement;
import pages.SearchMoviePage;

import static utils.Commands.clickText;

public class SearchMovieActions extends SearchMoviePage {

    public static SearchMovieActions searchMovieActions() {
        return new SearchMovieActions();
    }

    public void clickBtnMovie(String Movie) {
        clickText(Movie);
    }

    public void clickMagnifier() {
        actionSearch.click();
    }

    public void fillMovie(String nameMovie) {
        searchSrcText.setValue(nameMovie);
    }

    public void clickMovieTitle() {
        txtMovie.click();
    }

    public SelenideElement movieTitle() {
        return movieTitle;
    }
}