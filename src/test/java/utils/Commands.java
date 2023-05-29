package utils;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.disabled;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.System.out;
import static setup.Environments.getTimeout;

public class Commands {

    /**
     * click element.
     * Example: click(element);
     *
     * @see WebElement#click()
     */

    public static SelenideElement click(SelenideElement selenideElement) {
        selenideElement.click();

        return selenideElement;
    }

    /**
     * Command to click visible text on screen
     * Example: clickText("my text");
     *
     * @param text
     */

    public static void clickText(String text) {
        try {
            $(By.xpath("//*[@text='" + text + "']")).click();
        } catch (Exception e) {
            out.println("Failed to click on element" + e);
        }
    }

    /**
     * Command to validate visible text on the screen.
     * Example: isEnable("my selendeElement");
     *
     * @param selenideElement
     */

    /**
     * Checks that element is not disabled
     *
     * @see WebElement#isEnabled()
     */

    public static SelenideElement ifEnabled(SelenideElement selenideElement) {
        try {
            selenideElement.shouldBe(enabled, Duration.ofSeconds(getTimeout()));
        } catch (Exception e) {
            out.println("Failed to wait for element to enabled! " + e);
        }
        return selenideElement;
    }

    /**
     * Checks that element is disabled
     * Example: isEnabled("my selenideElement");
     *
     * @see WebElement#isEnabled()
     */

    public static void ifDisabled(SelenideElement selenideElement) {
        try {
            selenideElement.shouldBe(disabled, Duration.ofSeconds(10));
        } catch (Exception e) {
            out.println("Failed to wait for element to disabled! " + e);
        }
    }

    /**
     * Command to fill string on input.
     * 
     * @param selenideElement
     * @param text
     */

    public static SelenideElement fill(SelenideElement selenideElement, String text) {
        selenideElement.setValue(text);

        return selenideElement;
    }
}