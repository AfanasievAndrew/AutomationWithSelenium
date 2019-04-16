import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SberbankInsurance
{
    private WebDriver chromeDriver;

    private TestSettings testSettings = new TestSettings();

    public SberbankInsurance()
    {
        chromeDriver = new ChromeDriver();

        chromeDriver.manage().timeouts().pageLoadTimeout(testSettings.PageLoadTimeout, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(testSettings.ImplicitlyWait, TimeUnit.SECONDS);
    }

    @Before
    public void BeforeTest()
    {
        chromeDriver.get(testSettings.MainUrl);

        chromeDriver.manage().window().maximize();
    }

    @After
    public void AfterTest()
    {
        chromeDriver.quit();
    }

    @Test
    public void TestMethod()
    {
        chromeDriver.findElement(By.xpath(testSettings.SiteMap.Person.InsuranceMenu)).click();
        chromeDriver.findElement(By.xpath(testSettings.SiteMap.Person.InsuranceSubMenu)).click();

        try
        {
            chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelShopping.InsuranceLabel)).click();
        }
        catch(Exception ex)
        {
            Assert.fail("Cannot find text 'Страхование путешественников'" + ex.getMessage());
        }

        Set<String> oldTabs = chromeDriver.getWindowHandles();

        chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelShopping.CheckoutOnlineButton)).click();

        try
        {
            String newTab = WaitNewTab(chromeDriver, oldTabs, 20 );
            chromeDriver.switchTo().window(newTab);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        Wait<WebDriver> wait = new WebDriverWait(chromeDriver,10,1000);

        wait.until(
                ExpectedConditions.visibilityOf(
                        chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelInsurance.SelectPolicyTab.TabLabel))));

        chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelInsurance.SelectPolicyTab.MinimalPolicy)).click();

        chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelInsurance.SelectPolicyTab.RegistrationButton)).click();

        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.InsuredSurname, "Surname");
        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.InsuredName, "Name");
        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.InsuredBirthDate, "01.01.2000");

        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.Surname, "Фамилия");
        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.Name, "Имя");
        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.Middlename, "Отчество");
        FillField(chromeDriver, testSettings.SiteMap.TravelInsurance.RegistrationTab.BirthDate, "01.01.2000");
        chromeDriver.findElement(By.name("male")).click();

        FillField(chromeDriver,testSettings.SiteMap.TravelInsurance.RegistrationTab.PassportSeries, "1111");
        FillField(chromeDriver,testSettings.SiteMap.TravelInsurance.RegistrationTab.PassportNumber, "111111");
        FillField(chromeDriver,testSettings.SiteMap.TravelInsurance.RegistrationTab.IssueDate, "01.01.2014");
        FillField(chromeDriver,testSettings.SiteMap.TravelInsurance.RegistrationTab.IssuePlace, "Кем выдан");

        chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelInsurance.RegistrationTab.NextButton)).click();

        chromeDriver.findElement(By.xpath(testSettings.SiteMap.TravelInsurance.RegistrationTab.WarningLabel));
    }

    private String WaitNewTab(WebDriver driver, Set<String> oldTabs, int timeoutSeconds) throws TimeoutException
    {
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

    private void FillField(WebDriver driver, String name, String content)
    {
        WebElement field = driver.findElement(By.name(name));
        field.sendKeys(content);

        Assert.assertEquals("Wrong value in element " + name , field.getAttribute("value"), content);
    }
}
