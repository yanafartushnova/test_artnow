package SetUp;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class OpenClose {
    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public String browser = "chrome";
    public static final String URL = "https://artnow.ru/";
    @BeforeMethod(description = "Start page")
    public void startPage() {
        if (browser.equalsIgnoreCase("chrome")) {
            // Set the path to the Chrome driver executable
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            // Create a new instance of the Chrome driver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
            System.out.println("Browser was successfully opened");
            FirefoxOptions options = new FirefoxOptions();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod(description = "Stop page")
    public void stopPage() {
        driver.quit();
        System.out.println("Browser was successfully quited");
    }
}
