package utils;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.BaseScreen;

import java.io.File;

import static java.lang.System.out;

public class Screenshots extends BaseScreen {

    public static void shot(Scenario scenario) {
        try {
            File screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
        } catch (Exception e) {
            out.println("Error implementing screenshot!");
        }
    }

    public static void takingScreenshot(Scenario scenario) {
        shot(scenario);
        out.println("\nScreenshot taken!");
    }
}