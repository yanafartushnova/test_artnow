package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StylePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait;
    public static final String URL = "https://artnow.ru/";
    public StylePage(WebDriver driver, WebDriverWait webDriverWait) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 10);
    }

    public void checkStyle(){
        WebElement style = driver.findElement(By.cssSelector("a[href='//artnow.ru/kartiny-realism.html']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(style));
    }

}
