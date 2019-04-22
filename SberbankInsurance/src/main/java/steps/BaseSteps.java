package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.TestProperties;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BaseSteps {

    protected static Properties properties = TestProperties.getInstance().getProperties();

    protected static WebDriver driver;

    protected static String baseUrl;

    @Before
    public static void classSetUp(){
        driver = loadDriver(properties.getProperty("browser"));
        driver.manage().timeouts().pageLoadTimeout(
                Long.parseLong(properties.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(
                Long.parseLong(properties.getProperty("implicitlyWait")), TimeUnit.SECONDS);

        baseUrl = properties.getProperty("app.url");
        System.out.println(baseUrl);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    private static WebDriver loadDriver(String browserName){
        WebDriver driver;

        switch (browserName){
            case "firefox":{
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            }
            case "chrome":{
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            }
            default:{
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
            }
        }
        return driver;
    }

    @After
    public static void classTearDown(){
        driver.quit();
    }

    protected static String waitNewTab(Set<String> oldTabs, int timeoutSeconds) throws TimeoutException {
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

    public static WebDriver getDriver(){return driver;}
}
