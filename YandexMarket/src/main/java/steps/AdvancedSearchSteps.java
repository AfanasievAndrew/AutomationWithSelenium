package steps;

import pages.AdvancedSearchPage;
import ru.yandex.qatools.allure.annotations.Step;

public class AdvancedSearchSteps {

    AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage();

    @Step("установлена цена от \"{0}\"")
    public void setPriceFrom(int value){
        advancedSearchPage.setPriceFrom(value);
    }

    @Step("выбран производитель \"{0}\"")
    public void selectManufacturers(String name){
        advancedSearchPage.selectManufacturers(name);
    }

    @Step("установлено количество элементов на странице \"{0}\"")
    public void setElementsCountOnPage(int count){
        advancedSearchPage.setElementsCount(count);
    }

    @Step("проверено количество элементов, ожидаемое значение \"{0}\"")
    public void checkElementCountOnPage(int count){
        advancedSearchPage.checkElementCount(count);
    }

    @Step("получено название \"{0}\" элемента на странице")
    public String getElementTitle(int index){
        return advancedSearchPage.getElementTitle(index);
    }

    @Step("введено в поисковую строку значение - \"{0}\"")
    public void searchElement(String content){
        advancedSearchPage.search(content);
    }

    @Step("выбран \"{0}\" элемент из списка")
    public void clickToElement(int index){
        advancedSearchPage.clickToElement(index);
    }
}
