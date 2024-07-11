package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import support.BaseScreen;

import static java.lang.System.out;
import static setup.Env.getPlatform;
import static setup.Env.getTools;
import static utils.Screenshots.takingScreenshot;

import static setup.Env.getTimeout;
import java.util.concurrent.TimeUnit;

import static support.GetSecrets.getSecrets;

public class Hooks extends BaseScreen {
    private String platform = getPlatform().toUpperCase();
    private String tools = getTools().toLowerCase();

    @Before
    public void start(Scenario scenario) throws Exception {
        BaseScreen.setDriver();
        getDriver().manage().timeouts().implicitlyWait(getTimeout(), TimeUnit.SECONDS);

        if (platform.equals("ANDROID")) {
            switch (tools) {
                case "appium":
                    logAppiumDetails(scenario);
                    break;

                case "bs":
                    logBrowserStackDetails(scenario);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid tools argument: " + tools);
            }
        } else {
            throw new IllegalArgumentException("Invalid platform argument: " + platform);
        }
    }

    private void logAppiumDetails(Scenario scenario) {
        out.println(
                "\n=======================================\n" +
                        "Execution by Appium \n\n" +
                        "Platform:     [" + getPlatform() + "]\n" +
                        "Scenario:     [" + scenario.getName() + "]\n" +
                        "Tags:         " + scenario.getSourceTagNames() + "\n\n" +
                        "Steps Executed:");
    }

    private void logBrowserStackDetails(Scenario scenario) {
        out.println(
                "\n=======================================*\n" +
                        "Execution by BrowserStack \n\n" +
                        "Platform:     [" + getPlatform() + "]\n" +
                        "Device:       [" + getSecrets().getDevice() + "]\n" +
                        "BS Version:   [" + getSecrets().getVersion() + "]\n" +
                        "Scenario:     [" + scenario.getName() + "]\n" +
                        "Tags:         " + scenario.getSourceTagNames() + "\n\n" +
                        "Steps Executed:");
    }

    @After
    public void finish(Scenario scenario) {
        takingScreenshot(scenario);
        out.println("\n" +
                "Status: " + (scenario.isFailed() ? "FAILED" : "PASSED") +
                "\n=======================================\n");
        BaseScreen.tearDown();
    }
}