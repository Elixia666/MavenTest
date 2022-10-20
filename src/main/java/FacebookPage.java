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

public class FacebookPage extends BasePageObject{
    PageService pageService;

    public FacebookPage(WebDriver driver){
        super(driver);
        pageService = new PageService(driver);
    }
    // labels


    // inputs
    @FindBy(xpath = "//input[@id='email']")
    WebElement loginInput;
    @FindBy(xpath = "//input[@id='pass']")
    WebElement hasloInput;
    @FindBy(xpath = "//div[@aria-label='Wiadomość']")
    WebElement messageInput;
    @FindBy(xpath = "//input[@aria-label='Wyślij wiadomość do:']")
    WebElement personFilterInput;

    //buttons
    @FindBy(xpath ="//button[.='Zezwól na korzystanie z niezbędnych i opcjonalnych plików cookie']")
    WebElement fbCookiesAccept;
    @FindBy(xpath = "//button[.='Zaloguj się']")
    WebElement logInButton;
    @FindBy(xpath = "//div[@aria-label='Wyszukaj osobę lub grupę']")
    WebElement searchPersonButton;
    @FindBy(xpath = "//div[@aria-label='Naciśnij klawisz Enter, aby wysłać']")
    WebElement sendMessageButton;
    @FindBy(xpath = "//div[@aria-label='Zamknij czat']")
    WebElement closeChatButton;


    //methods
    public void zaloguj(String login, String haslo) throws Exception{
        pageService.clickElement(fbCookiesAccept);
        pageService.sendKeysToElement(loginInput,login);
        pageService.sendKeysToElement(hasloInput,haslo);
        pageService.clickElement(logInButton);
    }
    public void wybierzCzat(String osoba) throws Exception{
        pageService.clickElement(searchPersonButton);
        Thread.sleep(1000);
        pageService.sendKeysToElement(personFilterInput,osoba);
        Thread.sleep(2000);
        WebElement czat = driver.findElement(By.xpath("//li[@role='option']//span[contains(text(),'"+osoba+"')]"));
        Thread.sleep(3000);
        pageService.clickElement(czat);
        Thread.sleep(2000);
    }
    public void wyslijWiadomosc(String wiadomosc) throws Exception{
        String temp = "";
        for(int i=0; i< wiadomosc.length();i++){
            temp = String.valueOf(wiadomosc.charAt(i));
            messageInput.sendKeys(temp);
        }
        pageService.clickElement(sendMessageButton);
        Thread.sleep(1000);
        pageService.clickElement(closeChatButton);

    }
}
