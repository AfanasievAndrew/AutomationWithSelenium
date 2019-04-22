package steps;
import enums.Gender;
import enums.InsuredData;
import enums.PersonalData;
import pages.TravelInsurance;
import ru.yandex.qatools.allure.annotations.Step;

public class TIRegistrationSteps {

    private TravelInsurance travelInsurancePage = new TravelInsurance();

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

    @Step("выполнена проверка на предупреждающее сообщение {0}")
    public void stepCheckWarning(String warning){
        travelInsurancePage.RegistrationTab.checkWarning(warning);
    }

    @Step("выполнено нажатие на кнопку Продолжить")
    public void stepClickToNext(){
        travelInsurancePage.RegistrationTab.clickToNext();
    }
}
