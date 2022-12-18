package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AppPages {
    protected SelenideElement alertButton = $(By.id("alert_positive_button"));
    protected SelenideElement allowVisible = $(By.id("com.android.packageinstaller:id/dialog_container"));
    protected SelenideElement btnAllow = $(By.id("com.android.packageinstaller:id/permission_allow_button"));
    protected SelenideElement usrButton = $(By.id("userButton"));
    protected SelenideElement btnAllowDuringUse = $(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"));
    protected SelenideElement version = $(By.id("com.ingresso.cinemas:id/textview_version"));
}