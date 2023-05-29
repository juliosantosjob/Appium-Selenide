package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AppPages {
    protected SelenideElement btnUser = $(By.id("com.ingresso.cinemas:id/userButton"));
    protected SelenideElement fldVersion = $(By.id("com.ingresso.cinemas:id/textview_version"));
    protected SelenideElement permissionMsg = $(By.id("com.android.permissioncontroller:id/permission_message"));
}