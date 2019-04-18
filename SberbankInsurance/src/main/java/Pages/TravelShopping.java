package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.junit.Assert;

public class TravelShopping extends MainMenu {

    @FindBy(xpath = "//h3[text()='Страхование путешественников']")
    private WebElement insuranceLabel;

    @FindBy(xpath = "//h3[text()='Страхование путешественников']" +
            "/ancestor::div[contains(@class,'bp-container')][position() = 1]//a[text()='Оформить онлайн']")
    private WebElement checkoutOnlineButton;

    public TravelShopping(WebDriver driver) {
        super(driver);
    }

    public void CheckExistInsuranceLabel(){
        try {
            insuranceLabel.isDisplayed();
        }
        catch(Exception ex) {
            Assert.fail("Cannot find text 'Страхование путешественников'" + ex.getMessage());
        }
    }

    public void ClickToCheckoutOnlineButton(){
        checkoutOnlineButton.click();
    }

}
