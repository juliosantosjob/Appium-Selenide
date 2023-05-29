package utils;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

public class Asserts {

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
     * @param selenideElement
     * @param text
     */

    public static SelenideElement isVisible(SelenideElement selenideElement) {
        $(selenideElement).should(exist);
        $(selenideElement).shouldBe(visible);

        return selenideElement;
    }
}
