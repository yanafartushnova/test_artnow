package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @BeforeMethod(description = "Start page")
    public void startPage(String site) {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.out.println("Browser was successfully opened");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(site);
    }
    @AfterMethod(description = "Stop page")
    public void stopPage() {
        driver.quit();
        System.out.println("Browser was successfully quited");
    }


}
