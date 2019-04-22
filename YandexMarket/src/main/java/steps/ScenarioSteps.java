package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();

    MarketSteps marketSteps = new MarketSteps();

    AdvancedSearchSteps advancedSearchSteps = new AdvancedSearchSteps();

    ResultSteps resultSteps = new ResultSteps();

    //Не получилось создать переменные в сценарии cucumber`а поэтому такой костыль(
    private String nameElement;

    @When("^выбран Яндекс Маркет")
    public void stepSelectYandexMarket(){
        mainSteps.selectYandexMarket();
        mainSteps.closeSetRegion();
    }

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMenu(String menuItem){
        marketSteps.selectMenuItem(menuItem);
    }

    @When("^выбран пункт под меню \"(.*)\"$")
    public void stepSelectSubMenuItem(String subMenuItem){
        marketSteps.selectSubMenuItem(subMenuItem);
    }

    @When("^задан параметр поиска от \"(.*)\" рублей$")
    public void stepSetPriceFrom(int value){
        advancedSearchSteps.setPriceFrom(value);
    }

    @When("^выбран производитель \"(.*)\"$")
    public void stepSelectManufacturers(String name){
        advancedSearchSteps.selectManufacturers(name);
    }

    @When("^установлено количество элементов на странице - \"(.*)\"$")
    public void stepSetElementsCountOnPage(int count){
        advancedSearchSteps.setElementsCountOnPage(count);
    }

    @Then("^проверено количество элементов на странице, ожидаемое значение \"(.*)\"$")
    public void stepCheckElementCountOnPage(int count){
        advancedSearchSteps.checkElementCountOnPage(count);
    }

    @When("^получено название элемента с индексом \"(.*)\" и выполнен поиск$")
    public void stepSearchElementByTitle(int index){
        nameElement = advancedSearchSteps.getElementTitle(index);
        advancedSearchSteps.searchElement(nameElement);
    }

    @Then("^проверено название результата поиска$")
    public void stepCheckResultTitle(){
        String name = resultSteps.getResultTitle();
        //"Wrong result title: expected '" + nameElement + "', now '" + name + "'"
        Assert.assertEquals(nameElement, name);
    }

    @When("^выбран \"(.*)\" элемент из списка$")
    public void stepClickToElement(int index){
        nameElement = advancedSearchSteps.getElementTitle(index);
        advancedSearchSteps.clickToElement(index);
    }

    @When("^выполнен поиск элемента \"(.*)\"$")
    public void stepSearch(String name){
        advancedSearchSteps.searchElement(name);
    }

    @When("^получено название элемента с индексом \"(.*)\"$")
    public String stepGetElementTitle(int index){
        return advancedSearchSteps.getElementTitle(index);
    }

    @Then("^получено название результата поиска$")
    public String stepGetResultTitle(){
        return resultSteps.getResultTitle();
    }
}
