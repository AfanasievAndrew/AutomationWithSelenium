public class TestSettings
{
    public SberbankInsuranceMap SiteMap = new SberbankInsuranceMap();

    public String DriverPath = "driver/chromedriver.exe";

    public int PageLoadTimeout = 60;

    public int ImplicitlyWait = 10;

    public String MainUrl = "http://www.sberbank.ru/ru/person";
    TestSettings()
    {
        System.setProperty("webdriver.chrome.driver", DriverPath);
    }


}
