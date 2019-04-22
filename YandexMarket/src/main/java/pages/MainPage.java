package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    @FindBy(css = "[data-id='market']")
    WebElement market;

    public void selectMarket(){
        market.click();
    }

    // Закрытие всплывающего окна запроса места расположения
    public void closeSetRegion(){

        try{
            Wait<WebDriver> wait = new WebDriverWait(driver,10,1000);
            WebElement buttonYes = driver.findElement(By.xpath("//div[contains(@class, 'popup2')]//*[contains(text(), 'Да')]/parent::*"));
            wait.until(ExpectedConditions.visibilityOf(buttonYes));

            buttonYes.click();
        }
        catch (Exception ex){
            //Warning
        }

    }
}
