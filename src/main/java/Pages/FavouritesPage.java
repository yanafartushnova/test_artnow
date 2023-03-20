package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FavouritesPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    public static final String URL = "https://artnow.ru/";
    public FavouritesPage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }


    @Step("Сравнить элементы в Избранном с требуемым")
    public void checkNameOfFirstPicture(String Name) {
        Boolean expected = true;
        Boolean flag = false;
        List<WebElement> ListOfPaintings = driver.findElements(By.cssSelector(".bubu"));
        for (WebElement img : ListOfPaintings) {
            if (img.getAttribute("alt").equals(Name)) flag = true;
        }
        Assert.assertEquals(flag, expected);
    }
}
