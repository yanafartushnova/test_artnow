package SetUp;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Screenshot {
    @Attachment(value = "Page screenshot", type = "image/png")
    public static void makeScreen(){
        byte[] screenshotAs = ((TakesScreenshot) OpenClose.driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Скриншот", new ByteArrayInputStream(screenshotAs));
    }
}
