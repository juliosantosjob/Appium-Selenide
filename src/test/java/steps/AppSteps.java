package steps;

import actions.AppActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static java.lang.System.out;

public class AppSteps extends AppActions {
    private static AppActions app = new AppActions();

    @Given("the APP is open")
    public void the_APP_is_open() {
        app.AppIsOpen();
        out.println("- The APP is open");
    }

    @And("user click profile button")
    public void user_click_profile_button() {
        app.tapProfileButton();
        out.println("- User click profile button");
    }

    @When("he clicks {string}")
    public void he_clicks(String btnAbout) {
        app.tapAboutButton(btnAbout);
        out.println("- He clicks \"" + btnAbout + "\"");
    }

    @Then("he sees the app version {string}")
    public void he_sees_the_app_version(String version) {
        app.seeVersion(version);
        out.println("- He sees the app version \"" + version + "\"");
    }
}