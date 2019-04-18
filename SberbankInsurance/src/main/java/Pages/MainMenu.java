package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends BasePage{

    @FindBy(xpath = "//ul[contains(@class,'lg-menu__list')]")
    private WebElement menuItems;

    @FindBy(xpath = "//div[@class='lg-menu__sub']")
    private WebElement menuSubItem;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public void ClickToMenu(String itemName){
        menuItems.findElement(By.xpath(".//*[contains(text(),'"+itemName+"')]")).click();
    }

    public void ClickToSubMenu(String itemName){
        driver.findElement(By.xpath("//div[@class='lg-menu__sub']//a[text()='Путешествия и покупки']")).click();
        //menuSubItem.findElement(By.xpath(".//a[text()='"+itemName+"']")).click();
    }
}
