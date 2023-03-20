package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    public static final String URL = "https://artnow.ru/";
    public CartPage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    @Step("Сравнить элементы в Корзине с требуемым")
    public void checkCostOfFirstPicture(String Price) {
        List<WebElement> ListOfPaintings = driver.findElements(By.cssSelector(".price"));
        String strPrice = ListOfPaintings.get(0).getText();
        Assert.assertEquals(Price, strPrice);
    }
}
