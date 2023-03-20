package Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenrePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    public static final String URL = "https://artnow.ru/";
    public GenrePage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "li.menu-group")
    private WebElement ShowMore;

    @FindBy(css = "a[href='//artnow.ru/vyshitye-kartiny-kupit.html']")
    private WebElement EmbroidPaintings;

    @FindBy(css = "input[id='genre257']")
    private WebElement UrbanLandscape;

    @FindBy(css = "div[id='applymsg']")
    private WebElement Apply;

    @FindBy(css = "img[alt='Трамвайный путь. Гвоздецкая Татьяна']")
    private WebElement TramWay;

    @FindBy(css = "a[href='//artnow.ru/batik-kartiny-kupit.html']")
    private WebElement Batic;

    @FindBy(css = "div[data-id='1099595']")
    private WebElement Like;

    @FindBy(css = "img[alt='Избранное']")
    private WebElement Favourite;

    @FindBy(css = "a[href='//artnow.ru/juvelirnye-izdelija-ruchnoj-raboty.html']")
    private WebElement JewelryArt;

    @FindBy(css = "div[id='CartButton1100221']")
    private WebElement CartBtn;

    @FindBy(css = "button[class='ok-button']")
    private WebElement goToCart;

    @Step("Нажать кнопку Показать еще")
    public void clickShowMore(){
        webDriverWait.until(ExpectedConditions.visibilityOf(ShowMore));
        ShowMore.click();
    }

    @Step("Выбрать Вышитые картины")
    public void clickEmbroidPaintings(){
        webDriverWait.until(ExpectedConditions.visibilityOf(EmbroidPaintings));
        EmbroidPaintings.click();
    }

    @Step("Выбрать Ювелирное искусство")
    public void clickJewelryArt(){
        webDriverWait.until(ExpectedConditions.visibilityOf(JewelryArt));
        JewelryArt.click();
    }

    @Step("Выбрать Городские пейзажи")
    public void clickUrbanLandscape(){
        webDriverWait.until(ExpectedConditions.visibilityOf(UrbanLandscape));
        UrbanLandscape.click();
    }

    @Step("Нажать Применить")
    public void clickApply(){
        webDriverWait.until(ExpectedConditions.visibilityOf(Apply));
        Apply.click();
    }

    @Step("Проверить, что в выборке есть картина Трамвайный путь")
    public void checkNamePainting() {
        List<WebElement> Results = driver.findElements(By.cssSelector("img[alt='Трамвайный путь. Гвоздецкая Татьяна']"));
    }

    @Step("Перейти в картину Трамвайный путь")
    public void clickPainting() {
        webDriverWait.until(ExpectedConditions.visibilityOf(TramWay));
        TramWay.click();
    }

    @Step("Выбрать Батик")
    public void clickBatic() {
        webDriverWait.until(ExpectedConditions.visibilityOf(Batic));
        Batic.click();
    }

    @Step("Добавить первую картину в избранное")
    public void clickLike() {
        webDriverWait.until(ExpectedConditions.visibilityOf(Like));
        Like.click();
    }

    @Step("Добавить первую картину в корзину")
    public void clickCartBtn() {
        webDriverWait.until(ExpectedConditions.visibilityOf(CartBtn));
        CartBtn.click();
    }

    @Step("Перейти в избранное")
    public void clickFavourite() {
        webDriverWait.until(ExpectedConditions.visibilityOf(Favourite));
        Favourite.click();
    }

    @Step("Перейти в корзину")
    public void clickGoToCart() {
        webDriverWait.until(ExpectedConditions.visibilityOf(goToCart));
        goToCart.click();
    }

    @Step("Получить название первой картины")
    public String getNameOfFirstPicture() {
        List<WebElement> ListOfPaintings = driver.findElements(By.cssSelector(".bubu"));
        String NameOfFirstPicture = ListOfPaintings.get(0).getAttribute("alt");
        return NameOfFirstPicture;
    }
    @Step("Получить стоимость первой картины")
    public String getCostOfFirstPicture() {
        List<WebElement> ListOfPaintings = driver.findElements(By.cssSelector(".price"));
        String CostOfFirstPicture = ListOfPaintings.get(0).getText();
        return CostOfFirstPicture;
    }

}
