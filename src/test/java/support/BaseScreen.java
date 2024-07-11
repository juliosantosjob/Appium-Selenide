package support;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import setup.Env;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.disabled;

import static java.lang.System.out;

public class BaseScreen {
    public static AppiumDriver<MobileElement> driver;

    /**
     * Command to set driver.
     * 
     * @throws MalformedURLException
     * Example: setDriver();
     */

    public static void setDriver() throws MalformedURLException {
        driver = new Instances().getDriverInstance();
        WebDriverRunner.setWebDriver(driver);
    }

    /**
     * Command to get driver.
     * 
     * @return driver
     */

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    /**
     * Command to close driver.
     * Example: tearDown();
     */

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Command to validate visible text on the screen.
     * Example: textVisible("my text");
     *
     * @param text
     */

    public static void textVisible(String text) {
        $(By.xpath("//*[@text='" + text + "']")).should(exist);
        $(By.xpath("//*[@text='" + text + "']")).shouldBe(visible);
    }

    /**
     * Valid element contains text.
     * 
     * @param selenideElement
     * @param text
     */

    public static SelenideElement contains(SelenideElement selenideElement, String text) {
        $(selenideElement).shouldBe(visible);
        $(selenideElement).shouldHave(text(text));

        return selenideElement;
    }

    /**
     * Valid element is displayad.
     * 
     * @param selenideElement
     * @param text
     */

    public static SelenideElement isVisible(SelenideElement selenideElement) {
        $(selenideElement).should(exist);
        $(selenideElement).shouldBe(visible);

        return selenideElement;
    }

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
            selenideElement.shouldBe(enabled, Duration.ofSeconds(Env.getTimeout()));
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

    public static SelenideElement type(SelenideElement selenideElement, String text) {
        selenideElement.setValue(text);

        return selenideElement;
    }

}