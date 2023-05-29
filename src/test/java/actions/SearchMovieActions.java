package actions;

import pages.SearchMoviePage;

import static utils.Commands.clickText;
import static utils.Commands.click;
import static utils.Commands.fill;

import static utils.Asserts.contains;

public class SearchMovieActions extends SearchMoviePage {

    public void clickBtnMovie(String Movie) {
        clickText(Movie);
    }

    public void clickMagnifier() {
        click(actionSearch);
    }

    public void fillMovie(String nameMovie) {
        fill(searchSrcText, nameMovie);
    }

    public void clickMovieTitle() {
        click(txtMovie);
    }

    public void seeMovieTitle(String nameMovie) {
        contains(movieTitle, nameMovie);
    }
}