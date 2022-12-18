package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchMoviePage {
    protected SelenideElement actionSearch = $(By.id("action_search"));
    protected SelenideElement searchSrcText = $(By.id("search_src_text"));
    protected SelenideElement txtMovie = $(By.id("movie_name"));
    protected SelenideElement movieTitle = $(By.id("movieTitle"));
}