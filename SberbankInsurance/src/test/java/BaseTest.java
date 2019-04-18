import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BaseTest {

    protected static Properties Properties = TestProperties.getInstance().getProperties();

    protected static WebDriver Driver;

    @BeforeClass
    public static void ClassSetUp(){
        Driver = LoadDriver(Properties.getProperty("browser"));
        Driver.manage().timeouts().pageLoadTimeout(
                Long.parseLong(Properties.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        Driver.manage().timeouts().implicitlyWait(
                Long.parseLong(Properties.getProperty("implicitlyWait")), TimeUnit.SECONDS);
    }

    private static WebDriver LoadDriver(String browserName){
        WebDriver driver;

        switch (browserName){
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", Properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            }
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", Properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            }
            default:{
                System.setProperty("webdriver.chrome.driver", Properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    @AfterClass
    public static void ClassTearDown(){
        Driver.quit();
    }

    protected String WaitNewTab(WebDriver driver, Set<String> oldTabs, int timeoutSeconds) throws TimeoutException {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0L;
        long timeoutMilliseconds = timeoutSeconds*60*1000;

        String newTab = null;

        while(newTab == null && elapsedTime < timeoutMilliseconds)
        {
            Set<String> newWindowsSet = driver.getWindowHandles();
            newWindowsSet.removeAll(oldTabs);

            newTab = newWindowsSet.size() == 0
                    ? null
                    : newWindowsSet.iterator().next();

            elapsedTime = (new Date()).getTime() - startTime;
        }

        if(elapsedTime >= timeoutMilliseconds)
        {
            throw new TimeoutException("Time out show new tab exceeded");
        }

        return newTab;
    }
}
