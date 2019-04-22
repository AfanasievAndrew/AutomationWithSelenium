package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class BasePage {

    protected WebDriver driver;

    public BasePage(){
        driver = BaseSteps.getDriver();
        PageFactory.initElements(driver, this);
    }
}
