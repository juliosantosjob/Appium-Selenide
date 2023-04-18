package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.DriverFactory;


import static java.lang.System.out;

public class Screenshots extends DriverFactory {

    public static void shot(Scenario scenario) {
        try {
            TakesScreenshot ss = (TakesScreenshot) driver;
            byte[] screenshot = ss.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        } catch (Exception e) {
            out.println("Error implementing screenshot!");
        }
    }

    public static void takingScreenshot(Scenario scenario) {
        if (!scenario.isFailed()) {
            shot(scenario);
        } else {
            out.println(" ");
            out.println("****** Scenario: [" + scenario.getName() + "] is [" + scenario.getStatus() + "] *******");
            out.println(" ");
            shot(scenario);
        }
    }
}