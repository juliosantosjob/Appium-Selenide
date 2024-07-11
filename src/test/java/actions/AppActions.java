package actions;

import pages.AppPages;

import static support.BaseScreen.click;
import static support.BaseScreen.textVisible;
import static support.BaseScreen.clickText;
import static support.BaseScreen.contains;
import static support.BaseScreen.isVisible;

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