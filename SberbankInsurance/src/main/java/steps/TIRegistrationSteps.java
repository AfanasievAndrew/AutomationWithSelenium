package steps;
import enums.Gender;
import enums.InsuredData;
import enums.PersonalData;
import pages.TravelInsurance;
import ru.yandex.qatools.allure.annotations.Step;

public class TIRegistrationSteps extends BaseSteps {

    private TravelInsurance travelInsurancePage = new TravelInsurance(driver);

    @Step("заполнено поле {0} значением {1}")
    public void stepFillField(InsuredData fieldType, String content){
        travelInsurancePage.RegistrationTab.fillField(fieldType,content);
    }

    @Step("заполнено поле {0} значением {1}")
    public void stepFillField(PersonalData fieldType, String content){
        travelInsurancePage.RegistrationTab.fillField(fieldType,content);
    }

    @Step("выбран пол {0}")
    public void stepFillField(Gender type){
        travelInsurancePage.RegistrationTab.selectGender(type);
    }

    @Step("выполнена проверка заполненых полей")
    public void stepCheckFields(){
        travelInsurancePage.RegistrationTab.checkFields();
    }

    @Step("выполнена проверка на предупреждающее сообщение")
    public void stepCheckWarning(){
        travelInsurancePage.RegistrationTab.checkWarning();
    }

    @Step("выполнено нажатие на кнопку Продолжить")
    public void stepClickToNext(){
        travelInsurancePage.RegistrationTab.clickToNext();
    }
}
