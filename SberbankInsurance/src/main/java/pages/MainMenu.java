package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends BasePage{

    @FindBy(xpath = "//ul[contains(@class,'lg-menu__list')]")
    private WebElement menuItems;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public void clickToMenu(String itemName){
        menuItems.findElement(By.xpath(".//*[contains(text(),'"+itemName+"')]")).click();
    }

    public void clickToSubMenu(String itemName){
        driver.findElement(By.xpath("//div[@class='lg-menu__sub']//a[text()='"+itemName+"']")).click();
    }


}
