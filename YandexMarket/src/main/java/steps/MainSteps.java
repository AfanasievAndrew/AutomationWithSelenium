package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("выбран Яндекс Маркет")
    public void selectYandexMarket(){
        mainPage.selectMarket();
    }

    @Step("закрыто всплывающее окно запроса места расположения")
    public void closeSetRegion(){
        mainPage.closeSetRegion();
    }
}
