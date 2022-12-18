package steps;

import actions.AppActions;
import io.cucumber.java.en.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AppSteps extends AppActions {

    @Given("the APP is open")
    public void the_APP_is_open() {
        appActions().AppIsOpen();
    }

    @And("user click profile button")
    public void user_click_profile_button() {
        appActions().tapProfileButton();
    }

    @When("he clicks {string}")
    public void he_clicks(String btnAbout) {
        appActions().tapAboutButton(btnAbout);
    }

    @Then("he sees the app version {string}")
    public void he_sees_the_app_version(String version) {
        $(appActions().seeVersion()).shouldBe(visible);
        $(appActions().seeVersion()).shouldHave(text(version));
    }
}