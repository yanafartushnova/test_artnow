package Pages;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import SetUp.OpenClose;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    private static final String SETTINGS_CSS = "div.topheader";
    private static final String COMPARING_CSS = "topheader";
    public static final String URL = "https://artnow.ru/";
    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    @Description("Check the start page")
    public void checkSettings() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SETTINGS_CSS)));
        WebElement settings = driver.findElement(By.cssSelector(SETTINGS_CSS));
        assertEquals(settings.getAttribute("class"), COMPARING_CSS);

    }

    @FindBy(name = "qs")
    private WebElement SearchField;

    public void inputSearchField(){
        webDriverWait.until(ExpectedConditions.visibilityOf(SearchField));
        SearchField.sendKeys("Жираф");
        SearchField.submit();
    }

    public void checkFirstPainting(){
        Boolean expected = true;
        Boolean flag = false;
        String compare = "Жираф";
        List<WebElement> ListOfPaintings = driver.findElements(By.cssSelector(".bubu"));
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(ListOfPaintings));
        String Name = ListOfPaintings.get(0).getAttribute("alt").toLowerCase();
        if (Name.toLowerCase().contains(compare.toLowerCase())) flag = true;
        Assert.assertEquals(flag, expected);
    }

}
