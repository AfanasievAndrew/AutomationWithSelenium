package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdvancedSearchPage extends BasePage {
    @FindBy(id = "glpricefrom")
    private WebElement priceFrom;

    @FindBy(css = ".n-pager button")
    private WebElement elementCountButton;

    @FindBy(xpath = "//div[contains(@class,'n-snippet-list')]" +
            "/child::div[not (contains(@class,'n-entrypoint-carousel'))" +
            " and not (contains(@class,'qa_list_entrypoint'))]")
    private List<WebElement> elementsList;

    @FindBy(id = "header-search")
    private WebElement seatchBar;

    //@FindBy(xpath = "//legend[contains(text(),'Производитель')]/parent::fieldset")
    //private WebElement manufacturers;

    public void setPriceFrom(int value){
        priceFrom.sendKeys(String.valueOf(value) + Keys.ENTER);
        waitRefreshListItems();
    }

    public void selectManufacturers(String name){
        driver.findElement(
                By.xpath("//input[@type='checkbox'][contains(@name,'" + name + "')]/../div"))
                .click();

        waitRefreshListItems();
    }

    public void setElementsCount(int elementsCount) throws IllegalArgumentException{
        if(elementsCount != 12 && elementsCount != 48){
            throw new IllegalArgumentException("Wrong input value, expected 12 or 48");
        }
        elementCountButton.click();

        driver.findElement(By.xpath("//div[@class='popup__content']//*[text()='Показывать по "+ elementsCount +"']")).click();

        waitRefreshListItems();
    }

    public void checkElementCount(int count){
        int currentCount = getElementsCount();

        Assert.assertEquals(count, currentCount);
    }

    public String getElementTitle(int elementIndex){
       return elementsList
               .get(elementIndex)
               .findElement(By.xpath(".//div[contains(@class,'title')]/a"))
               .getText();
    }

    public void clickToElement(int elementIndex){
        elementsList.get(elementIndex).findElement(By.xpath(".//div[contains(@class,'title')]/a")).click();
    }

    public void search(String content){
        seatchBar.sendKeys(content + Keys.ENTER);
    }

    private int getElementsCount()
    {
        return elementsList.size();
    }

    private void waitRefreshListItems(){
        //костыль(
        try {
            driver.findElement(By.xpath("//div[contains(@class,'n-pager-more')][(contains(@style,'display: none'))]"));
        }
        catch (Exception ex){
            //Warning
        }

        try {
            driver.findElement(By.xpath("//div[contains(@class,'n-pager-more')][not(contains(@style,'display: none'))]"));
        }
        catch (Exception ex){
            //Warning
        }
    }
}
