package steps;

import pages.MainMenu;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{

    private MainMenu mainMenuPage = new MainMenu(driver);

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String value){
        mainMenuPage.clickToMenu(value);
    }

    @Step("выбран пункт под меню {0}")
    public void stepSelectSubMenu(String value){
        mainMenuPage.clickToSubMenu(value);
    }
}
