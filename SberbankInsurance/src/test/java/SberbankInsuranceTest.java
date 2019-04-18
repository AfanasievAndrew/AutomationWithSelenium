import Enums.Gender;
import Enums.InsuredData;
import Enums.PersonalData;
import Pages.MainMenu;
import Pages.TravelInsurance;
import Pages.TravelShopping;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;

public class SberbankInsuranceTest extends BaseTest{

    @Before
    public void BeforeTest(){
        Driver.get(Properties.getProperty("app.url"));

        Driver.manage().window().maximize();
    }

    @After
    public void AfterTest(){
        Set<String> windowsSet = Driver.getWindowHandles();

        for (String tab:
                windowsSet) {
            Driver.switchTo().window(tab);
            Driver.close();
        }
    }

    @Test
    public void TestMethod(){
        MainMenu menuPage = new MainMenu(Driver);
        menuPage.ClickToMenu("Страхование");
        menuPage.ClickToSubMenu("Путешествия и покупки");

        Set<String> oldTabs = Driver.getWindowHandles();

        TravelShopping travelShoppingPage = new TravelShopping(Driver);
        travelShoppingPage.CheckExistInsuranceLabel();
        travelShoppingPage.ClickToCheckoutOnlineButton();

        try
        {
            String newTab = WaitNewTab(Driver, oldTabs, 20 );
            Driver.switchTo().window(newTab);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        TravelInsurance travelInsurance = new TravelInsurance(Driver);

        travelInsurance.SelectPolicyTab.WaitToAppearanceLabel();
        travelInsurance.SelectPolicyTab.SelectAmountInsurance("Минимальная");
        travelInsurance.SelectPolicyTab.ClickRegistrationButton();

        travelInsurance.RegistrationTab.FillField(InsuredData.Surname,"Surname");
        travelInsurance.RegistrationTab.FillField(InsuredData.Name,"Name");
        travelInsurance.RegistrationTab.FillField(InsuredData.BirthDate,"01.01.2000");

        travelInsurance.RegistrationTab.FillField(PersonalData.Surname,"Фамилия");
        travelInsurance.RegistrationTab.FillField(PersonalData.Name,"Имя");
        travelInsurance.RegistrationTab.FillField(PersonalData.Middlename,"Отчество");
        travelInsurance.RegistrationTab.FillField(PersonalData.BirthDate,"01.01.2000");
        travelInsurance.RegistrationTab.SelectGender(Gender.Male);

        travelInsurance.RegistrationTab.FillField(PersonalData.PassportSeries,"1111");
        travelInsurance.RegistrationTab.FillField(PersonalData.PassportNumber,"111111");
        travelInsurance.RegistrationTab.FillField(PersonalData.PassportIssueDate,"01.01.2014");
        travelInsurance.RegistrationTab.FillField(PersonalData.PassportIssuePlace,"Кем выдан");

        travelInsurance.RegistrationTab.CheckFields();

        travelInsurance.RegistrationTab.ClickToNext();

        travelInsurance.RegistrationTab.CheckFields();

        travelInsurance.RegistrationTab.CheckWarning();
    }
}
