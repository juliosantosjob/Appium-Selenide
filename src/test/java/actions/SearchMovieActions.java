package actions;

import pages.SearchMoviePage;

import static support.BaseScreen.click;

import static support.BaseScreen.clickText;
import static support.BaseScreen.contains;

import static support.BaseScreen.type;

public class SearchMovieActions extends SearchMoviePage {

    public void clickBtnMovie(String Movie) {
        clickText(Movie);
    }

    public void clickMagnifier() {
        click(actionSearch);
    }

    public void fillMovie(String nameMovie) {
        type(searchSrcText, nameMovie);
    }

    public void clickMovieTitle() {
        click(txtMovie);
    }

    public void seeMovieTitle(String nameMovie) {
        contains(movieTitle, nameMovie);
    }
}