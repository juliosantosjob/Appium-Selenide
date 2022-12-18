package support;

import static setup.BrowserStack.browserStack;
import static setup.Environments.envs;

public class GetSecrets {

    public static GetSecrets getSecrets() {
        return new GetSecrets();
    }

    public String getDevice() {
        return Boolean.parseBoolean(envs().getLocal()) ? System.getenv("BS_USER") : browserStack().getBrowserstackDevice();
    }

    public String getVersion() {
        return Boolean.parseBoolean(envs().getLocal()) ? System.getenv("BS_USER") : browserStack().getBrowserstackDevice();
    }

    public String getUser() {
        return Boolean.parseBoolean(envs().getLocal()) ? System.getenv("BS_USER") : browserStack().getBrowserstackUser();
    }

    public String getKey() {
        return Boolean.parseBoolean(envs().getLocal()) ? System.getenv("BS_KEY") : browserStack().getBrowserstackKey();
    }

    public String getHash() {
        return Boolean.parseBoolean(envs().getLocal()) ? System.getenv("BS_HASH") : browserStack().getBrowserstackHash();
    }
}