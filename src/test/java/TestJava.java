import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class TestJava {

    @Test
    public void openGoogle(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Elixia\\Downloads\\geckodriver.exe");

        FirefoxOptions option = new FirefoxOptions();

        option.setHeadless(false);
        option.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver firefox = new FirefoxDriver(option);

        Dimension winsize = new Dimension(800 ,600);
      //  firefox.manage().window().setSize(winsize); // window size
        firefox.manage().window().maximize(); //full screen
        firefox.get("https://www.google.com");
        //((JavascriptExecutor)firefox).executeScript("window.open('https://www.youtube.com/','blank',height = 800, width = 1024)"); // odpala nowe okno z nowym adresem

      //  firefox.close(); //zamyka pierwsze okno

    }
}
