import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;


public class OpenPage {
    WebDriver driver;
    GooglePage googlePage;
    FacebookPage facebookPage;

    @Test
    public void sayHi() throws Exception{
        try {
            googlePage.znajdzWGoogle("Facebook");
            facebookPage = googlePage.wybierzFacebook();
            facebookPage.zaloguj("skirsza@wp.pl","eventually66r6");
            Thread.sleep(2000);
            facebookPage.wybierzCzat("Stanisław Kirsza");
            facebookPage.wyslijWiadomosc("Cześć, tą wiadomość wysłał zautomatyzowany program testowy ;*");
        }
        catch(Exception e){
            System.out.println("Nieoczekiwany Blad:");
            throw e;
        }

    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Elixia\\Downloads\\geckodriver.exe");
        FirefoxOptions option = new FirefoxOptions();
        option.setHeadless(false);
        option.addArguments("--lang=pl");
        option.addArguments("--incognito");
        option.addArguments("start-maximized");
        driver = new FirefoxDriver(option);
        driver.get("https://www.google.com");
        driver.manage().window().maximize(); //full screen
        googlePage = new GooglePage(driver);
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        try{
            Set<String> handles = driver.getWindowHandles();
                for(String window: handles){
                    driver.switchTo().window(window);
                    driver.close();
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTestSuite(){
        try{
            driver.quit();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
