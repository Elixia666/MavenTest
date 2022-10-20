import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;
import java.time.Duration;

public class GooglePage extends BasePageObject{

    PageService pageService;

    public GooglePage(WebDriver driver){
        super(driver);
        pageService = new PageService(driver);
    }

    @FindBy(xpath = "//input[@class='gLFyf gsfi']")
    WebElement googleSearchInput;

    @FindBy(xpath = "//div[.='Zaakceptuj wszystko']")
    WebElement googleAcceptTerms;

    @FindBy(xpath = "//input[@aria-label='Szukaj w Google']")
    WebElement szukajWGoogle;

    // methods
    public void znajdzWGoogle(String szukane)throws Exception{

        zaakceptujWarunkiGoogle();
        wpiszSzukane(szukane);
        szukajWGoogleClick();
    }

    // input
    public void wpiszSzukane(String dane)throws Exception{
        pageService.sendKeysToElement(googleSearchInput,dane);
    }
    // click
    public void zaakceptujWarunkiGoogle()throws Exception{
        pageService.clickElement(googleAcceptTerms);
    }
    public void szukajWGoogleClick()throws Exception{
        pageService.clickElement(szukajWGoogle);
    }
    public FacebookPage wybierzFacebook()throws Exception{
        WebElement szukane = driver.findElement(By.xpath("//h3[.='Facebook – zaloguj się lub zarejestruj']"));
        pageService.clickElement(szukane);
        return new FacebookPage(driver);
    }

}
