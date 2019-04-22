package steps;

import pages.ResultPage;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultSteps {
    ResultPage resultPage = new ResultPage();

    @Step("получено имя элемента")
    public String getResultTitle(){
        return resultPage.getResultText();
    }
}
