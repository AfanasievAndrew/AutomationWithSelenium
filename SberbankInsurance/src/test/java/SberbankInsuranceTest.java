import enums.Gender;
import enums.InsuredData;
import enums.PersonalData;
import steps.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.Set;

public class SberbankInsuranceTest extends BaseSteps {

    MainSteps mainSteps = new MainSteps();
    TravelShoppingSteps travelShoppingSteps = new TravelShoppingSteps();
    TISelectPolicySteps tISelectPolicySteps = new TISelectPolicySteps();
    TIRegistrationSteps tIRegistrationSteps= new TIRegistrationSteps();

    @Before
    public void beforeTest(){
        driver.get(properties.getProperty("app.url"));

        driver.manage().window().maximize();
    }

    @After
    public void afterTest(){
        Set<String> windowsSet = driver.getWindowHandles();

        for (String tab:
                windowsSet) {
            driver.switchTo().window(tab);
            driver.close();
        }
    }

    @Test
    @Title("Страхование путешественников")
    public void testMethod(){

        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Путешествия и покупки");

        Set<String> oldTabs = driver.getWindowHandles();

        travelShoppingSteps.stepCheckInsuranceLabel();
        travelShoppingSteps.stepCheckoutOnline();

        try
        {
            String newTab = waitNewTab(oldTabs, 20 );
            driver.switchTo().window(newTab);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        tISelectPolicySteps.stepWaitToAppearanceLabel();
        tISelectPolicySteps.stepSelectAmountInsurance("Минимальная");
        tISelectPolicySteps.stepClickRegistration();

        tIRegistrationSteps.stepFillField(InsuredData.Surname,"Surname");
        tIRegistrationSteps.stepFillField(InsuredData.Name,"Name");
        tIRegistrationSteps.stepFillField(InsuredData.BirthDate,"01.01.2000");

        tIRegistrationSteps.stepFillField(PersonalData.Surname,"Фамилия");
        tIRegistrationSteps.stepFillField(PersonalData.Name,"Имя");
        tIRegistrationSteps.stepFillField(PersonalData.Middlename,"Отчество");
        tIRegistrationSteps.stepFillField(PersonalData.BirthDate,"01.01.2000");
        tIRegistrationSteps.stepFillField(Gender.Male);

        tIRegistrationSteps.stepFillField(PersonalData.PassportSeries,"1111");
        tIRegistrationSteps.stepFillField(PersonalData.PassportNumber,"111111");
        tIRegistrationSteps.stepFillField(PersonalData.PassportIssueDate,"01.01.2014");
        tIRegistrationSteps.stepFillField(PersonalData.PassportIssuePlace,"Кем выдан");

        tIRegistrationSteps.stepCheckFields();

        tIRegistrationSteps.stepClickToNext();

        tIRegistrationSteps.stepCheckFields();

        tIRegistrationSteps.stepCheckWarning();
    }
}
