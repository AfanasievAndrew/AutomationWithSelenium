package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {

    MarketPage marketPage = new MarketPage();

    @Step("выбран пункт меню \"{0}\"")
    public void selectMenuItem(String menuItem){
        marketPage.selectMenu(menuItem);
    }

    @Step("выбран пункт под меню \"{0}\"")
    public void selectSubMenuItem(String subMenuItem){
        marketPage.setlectSubMenu(subMenuItem);
    }
}
