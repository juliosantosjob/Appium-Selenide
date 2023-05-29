package actions;

import pages.AppPages;

import static utils.Commands.click;
import static utils.Commands.clickText;

import static utils.Asserts.isVisible;
import static utils.Asserts.textVisible;
import static utils.Asserts.contains;

public class AppActions extends AppPages {

    public void AppIsOpen() {
        textVisible("Quer encontrar os cinemas mais próximos de você?");
        clickText("OK");

        if(permissionMsg.isDisplayed()) {
            clickText("Only this time");
        } else {
            clickText("Allow");
        }
    }

    public void tapProfileButton() {
        isVisible(btnUser);
        click(btnUser);
    }

    public void tapAboutButton(String btnAbout) {
        clickText(btnAbout);
    }

    public void seeVersion(String version) {
        contains(fldVersion, version);
    }
}