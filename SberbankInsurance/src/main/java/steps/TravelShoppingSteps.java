package steps;

import pages.TravelShopping;
import ru.yandex.qatools.allure.annotations.Step;

public class TravelShoppingSteps extends BaseSteps {

    private TravelShopping travelShoppingPage = new TravelShopping(driver);

    @Step("проверен label на новой странице")
    public void stepCheckInsuranceLabel(){
        travelShoppingPage.checkExistInsuranceLabel();
    }

    @Step("выполнено нажатие на кнопку оформить онлайн")
    public void stepCheckoutOnline(){
        travelShoppingPage.clickToCheckoutOnlineButton();
    }
}
