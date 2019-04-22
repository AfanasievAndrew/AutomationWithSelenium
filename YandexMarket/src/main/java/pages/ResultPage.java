package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultPage extends BasePage{
    @FindBy(css = ".n-product-summary__headline h1")
    private WebElement resultHeader;

    public String getResultText(){
        return resultHeader.getText();
    }
}
