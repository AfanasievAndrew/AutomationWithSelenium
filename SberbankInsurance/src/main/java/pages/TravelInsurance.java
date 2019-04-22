package pages;

import enums.Gender;
import enums.InsuredData;
import enums.PersonalData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class TravelInsurance {

    public SelectPolicyTab SelectPolicyTab;

    public RegistrationTab RegistrationTab;

    public TravelInsurance(){
        SelectPolicyTab = new SelectPolicyTab();
        RegistrationTab = new RegistrationTab();
    }

    public class SelectPolicyTab extends BasePage
    {
        @FindBy(xpath = "//*[text()='Выбор полиса']")
        private WebElement tabLabel;

        @FindBy(xpath = "//form//*[text()='Оформить']")
        private WebElement registrationButton;

        public SelectPolicyTab() {
            super();
        }

        public void waitToAppearanceLabel(){
            Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);

            wait.until(ExpectedConditions.visibilityOf(tabLabel));
        }

        public void selectAmountInsurance(String value){
            driver.findElement(By.xpath("//div[contains(text(),'"+value+"')]/parent::div")).click();
        }

        public void clickRegistrationButton(){
            registrationButton.click();
        }
    }

    public class RegistrationTab extends BasePage {

        @FindBy(name = "insured0_surname")
        private WebElement insuredSurname;
        @FindBy(name = "insured0_name")
        private WebElement insuredName;
        @FindBy(name = "insured0_birthDate")
        private WebElement insuredBirthDate;

        @FindBy(name = "surname")
        private WebElement surname;
        @FindBy(name = "name")
        private WebElement name;
        @FindBy(name = "middlename")
        private WebElement middlename;
        @FindBy(name = "birthDate")
        private WebElement birthDate;
        @FindBy(name = "passport_series")
        private WebElement passportSeries;
        @FindBy(name = "passport_number")
        private WebElement passportNumber;
        @FindBy(name = "issueDate")
        private WebElement issueDate;
        @FindBy(name = "issuePlace")
        private WebElement issuePlace;

        @FindBy(xpath = "//*[text()='Продолжить']")
        private WebElement nextButton;

        private WebElement warningLabel;

        private Map<Integer, String> fieldValues = new HashMap<Integer, String>();

        public RegistrationTab() {
            super();
        }

        public void clickToNext(){
            nextButton.click();
        }

        public void checkWarning(String warning){
            driver.findElement(By.xpath("//div[contains(@class,'form-error-message')]"
                    + "/child::div[text()='"
                    + warning
                    + "'][not (contains(@class,'ng-hide'))]")).isDisplayed();
        }

        public void selectGender(Gender value){

            switch (value) {
                case Male:
                    driver.findElement(By.name("male")).click();
                    break;
                case Female:
                    driver.findElement(By.name("female")).click();
                    break;
            }
        }

        public void fillField(PersonalData field, String content){

            switch (field){
                case Surname:
                {
                    surname.clear();
                    surname.sendKeys(content);
                    break;
                }
                case Name:
                {
                    name.clear();
                    name.sendKeys(content);
                    break;
                }
                case Middlename:
                {
                    middlename.clear();
                    middlename.sendKeys(content);
                    break;
                }
                case BirthDate:
                {
                    birthDate.clear();
                    birthDate.sendKeys(content);
                    break;
                }
                case PassportSeries:
                {
                    passportSeries.clear();
                    passportSeries.sendKeys(content);
                    break;
                }
                case PassportNumber:
                {
                    passportNumber.clear();
                    passportNumber.sendKeys(content);
                    break;
                }
                case PassportIssueDate:
                {
                    issueDate.clear();
                    issueDate.sendKeys(content);
                    break;
                }
                case PassportIssuePlace:
                {
                    issuePlace.clear();
                    issuePlace.sendKeys(content);
                    break;
                }
            }

            if(!fieldValues.containsKey(field.getValue())) {
                fieldValues.put(field.getValue(), content);
            }else {
                fieldValues.replace(field.getValue(), content);
            }
        }

        public void fillField(InsuredData field, String content){

            switch (field){
                case Surname:
                {
                    insuredSurname.clear();
                    insuredSurname.sendKeys(content);
                    break;
                }
                case Name:
                {
                    insuredName.clear();
                    insuredName.sendKeys(content);
                    break;
                }
                case BirthDate:
                {
                    insuredBirthDate.clear();
                    insuredBirthDate.sendKeys(content);
                    break;
                }
            }

            if(!fieldValues.containsKey(field.getValue())) {
                fieldValues.put(field.getValue(), content);
            }else {
                fieldValues.replace(field.getValue(), content);
            }
        }
        
        public void checkFields(){

            for (Map.Entry<Integer, String> entry :
                    fieldValues.entrySet()) {
                Integer mapKey = entry.getKey();
                String mapValue = entry.getValue();

                if(PersonalData.isFromEnum(mapKey)){
                    PersonalData personalData = PersonalData.valueOf(mapKey);
                    checkPersonalDataFields(personalData, mapValue);
                }else{
                    InsuredData insuredData = InsuredData.valueOf(mapKey);
                    checkInsuredDataFields(insuredData, mapValue);
                }
            }
        }

        private void checkPersonalDataFields(PersonalData mapKey, String mapValue){
            String realValue = "";

            switch (mapKey){
                case Surname:
                {
                    realValue = surname.getAttribute("value");
                    break;
                }
                case Name:
                {
                    realValue = name.getAttribute("value");
                    break;
                }
                case Middlename:
                {
                    realValue = middlename.getAttribute("value");
                    break;
                }
                case BirthDate:
                {
                    realValue = birthDate.getAttribute("value");
                    break;
                }
                case PassportSeries:
                {
                    realValue = passportSeries.getAttribute("value");
                    break;
                }
                case PassportNumber:
                {
                    realValue = passportNumber.getAttribute("value");
                    break;
                }
                case PassportIssueDate:
                {
                    realValue = issueDate.getAttribute("value");
                    break;
                }
                case PassportIssuePlace:
                {
                    realValue = issuePlace.getAttribute("value");
                    break;
                }
            }

            Assert.assertEquals("Wrong value in element " + mapKey , realValue, mapValue);
        }

        private void checkInsuredDataFields(InsuredData mapKey, String mapValue){
            String realValue = "";

            switch (mapKey){
                case Surname:
                {
                    realValue = insuredSurname.getAttribute("value");
                    break;
                }
                case Name:
                {
                    realValue = insuredName.getAttribute("value");
                    break;
                }
                case BirthDate:
                {
                    realValue = insuredBirthDate.getAttribute("value");
                    break;
                }
            }

            Assert.assertEquals("Wrong value in element " + mapKey , realValue, mapValue);
        }
    }
}

