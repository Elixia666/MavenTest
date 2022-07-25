import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void openGooglePage() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Elixia\\Downloads\\geckodriver.exe");
        FirefoxOptions option = new FirefoxOptions();

        option.setHeadless(false);
        option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver firefox = new FirefoxDriver(option);


        firefox.get("https://www.google.com");
        firefox.manage().window().maximize(); //full screen
      //  firefox.switchTo().frame(0);
        WebElement agree = firefox.findElement(By.xpath("//div[contains(text(),'OK')]"));
        agree.click();
     //   firefox.switchTo().defaultContent();
    }
}
