package actions;

import com.codeborne.selenide.SelenideElement;
import pages.AppPages;

import static com.codeborne.selenide.Condition.visible;
import static utils.Commands.clickText;
import static utils.Commands.ifEnabled;


public class AppActions extends AppPages {

    public static AppActions appActions() {
        return new AppActions();
    }

    public void AppIsOpen() {
        alertButton.click();

        if (allowVisible.isDisplayed()) {
            btnAllow.click();
            usrButton.should(visible);
        } else {
            btnAllowDuringUse.click();
        }
    }

    public void tapProfileButton() {
        ifEnabled(usrButton);
        ifEnabled(usrButton).click();
    }

    public void tapAboutButton(String btnAbout) {
        clickText(btnAbout);
    }

    public SelenideElement seeVersion() {
        return version;
    }
}