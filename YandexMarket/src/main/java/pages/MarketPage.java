package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class,'n-w-tabs__horizontal-tabs n-adaptive-layout')]")
    private WebElement mainMenu;

    @FindBy(xpath = "//a[contains(text(),'Телевизоры')]")
    private WebElement subMenu;

    public void selectMenu(String item){
        mainMenu.findElement(By.xpath(".//*[contains(text(),'" + item + "')]")).click();
    }

    public void setlectSubMenu(String item){
        driver.findElement(By.xpath("//a[contains(text(),'" + item + "')]")).click();
    }
}
