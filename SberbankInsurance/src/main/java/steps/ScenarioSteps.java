package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Gender;
import enums.InsuredData;
import enums.PersonalData;
import org.junit.Assert;
import pages.BasePage;

import java.util.Set;

public class ScenarioSteps {
    MainSteps mainSteps = new MainSteps();

    TravelShoppingSteps travelShoppingSteps = new TravelShoppingSteps();

    TIRegistrationSteps tiRegistrationSteps = new TIRegistrationSteps();

    TISelectPolicySteps tiSelectPolicySteps = new TISelectPolicySteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMenu(String menuItem){
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^выбран пункт под меню \"(.*)\"$")
    public void stepSelecSupMenu(String subMenuItem){
        mainSteps.stepSelectSubMenu(subMenuItem);
    }

    @Then("^проверен label на новой странице$")
    public void stepCheckInsuranceLabel(){
        travelShoppingSteps.stepCheckInsuranceLabel();
    }

    @When("^выполнено нажатие на кнопку \"Оформить онлайн\"$")
    public void stepClickCheckoutOnline(){
        Set<String> oldTabs = BaseSteps.getDriver().getWindowHandles();

        travelShoppingSteps.stepCheckoutOnline();

        try
        {
            String newTab = BaseSteps.waitNewTab(oldTabs, 20 );
            BaseSteps.getDriver().switchTo().window(newTab);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
    }

    @Then("^выполнено ожидание загрузки страницы страхования$")
    public void stepWaitTravelInsuranceLabel(){
        tiSelectPolicySteps.stepWaitToAppearanceLabel();
    }

    @When("^выбрана сумму страховой защиты \"(.*)\"$")
    public void stepSelectAmountInsurance(String value){
        tiSelectPolicySteps.stepSelectAmountInsurance(value);
    }

    @When("^выполнено нажатие на конпку \"Оформить\"$")
    public void stepClickRegistration(){
        tiSelectPolicySteps.stepClickRegistration();
    }

    @When("^заполняются поля Застрахованные:$")
    public void stepFillInsuredFields(DataTable fields){
        fields.asMap(InsuredData.class,String.class).forEach(
                (key,value) -> tiRegistrationSteps.stepFillField(key,value)
        );
    }

    @When("^заполняются поля Страхователь:$")
    public void stepFillPersonalFields(DataTable fields){
        fields.asMap(PersonalData.class,String.class).forEach(
                (key,value) -> tiRegistrationSteps.stepFillField(key,value)
        );
    }

    @When("^выбран пол \"(.*)\"$")
    public void stepFillGenderField(Gender type){
        tiRegistrationSteps.stepFillField(type);
    }

    @Then("^выполнена проверка заполненых полей$")
    public void stepCheckFields(){
        tiRegistrationSteps.stepCheckFields();
    }

    @When("^выполнено нажатие на кнопку \"Продолжить\"$")
    public void stepClickToNext(){
        tiRegistrationSteps.stepClickToNext();
    }

    @Then("^выполнена проверка на предупреждающее сообщение \"(.*)\"$")
    public void stepCheckWarning(String warning){
        tiRegistrationSteps.stepCheckWarning(warning);
    }
}
