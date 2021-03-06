package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

    public static WebDriver getDriver(){return driver;}
}
