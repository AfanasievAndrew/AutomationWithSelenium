package steps;

import pages.TravelInsurance;
import ru.yandex.qatools.allure.annotations.Step;

public class TISelectPolicySteps extends BaseSteps {

    private TravelInsurance travelInsurancePage = new TravelInsurance(driver);

    @Step("выполнено ожидание загрузки страницы")
    public void stepWaitToAppearanceLabel(){
        travelInsurancePage.SelectPolicyTab.waitToAppearanceLabel();
    }

    @Step("выбрана сумму страховой защиты {0}")
    public void stepSelectAmountInsurance(String value){
        travelInsurancePage.SelectPolicyTab.selectAmountInsurance(value);
    }

    @Step("выполнено нажатие на конпку Оформить")
    public void stepClickRegistration(){
        travelInsurancePage.SelectPolicyTab.clickRegistrationButton();
    }
}
