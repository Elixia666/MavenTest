import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.Clock;

public class PageService extends BasePageObject{


    private Actions actions = new Actions(this.driver);
    private JavascriptExecutor js = (JavascriptExecutor)this.driver;
    public WebDriverWait webDriverWait;

    public Duration czas = Duration.ofSeconds(60) ;

    public PageService(WebDriver driver) {
        super(driver);
        webDriverWait = new WebDriverWait(driver,czas);
    }


    public void sendKeysToElement(WebElement webElement, String string) throws InterruptedException {
        int attempts = 0; //licznik prób kliknięcia w element
        while(attempts < 5) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
                webElement.clear();
                actions.doubleClick(webElement).perform();
                Thread.sleep(200);
                webElement.sendKeys(string);
                Thread.sleep(500);
                System.out.println("Wpisałem: "+string+" w pole: "+webElement.toString());
                if(getElementAttributeString("value", webElement).equals(string)||getElementAttributeString("value", webElement).equals(string+".00")) {
                    System.out.println("ide dalej");
                    break;
                }

            }
            catch (StaleElementReferenceException | ElementNotInteractableException e){
                System.out.println(e + "  ... Retry....");
                Thread.sleep(1000);
            }
            attempts++;
        }


    }
    public String getElementAttributeString(String attribute, WebElement webElement) throws InterruptedException {
        int attempts = 0; //licznik prób kliknięcia w element
        while(attempts < 4){
            try {
                scrollIntoView(webElement);

                break;
            }
            catch (StaleElementReferenceException e){
                Thread.sleep(1000);
            }
            attempts++;
        }
        return webElement.getAttribute(attribute);
    }
    public void scrollIntoView(WebElement webElement) {
        js.executeScript("arguments[0].scrollIntoView();",webElement);
    }
    public void clickElement(WebElement webElement) throws InterruptedException {
        int attempts = 0; //licznik prób kliknięcia w element
        while(attempts < 2){
            try{
                webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
                //actions.click(webElement).perform();
                webElement.click();
                System.out.println("kliknalem w: "+webElement.toString());
                break;
            }
            catch (StaleElementReferenceException | ElementClickInterceptedException e){
                System.out.println(e);
                Thread.sleep(1000);
            }
            attempts++;
        }
    }
    public boolean isElementEnabled(WebElement webElement){
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.isEnabled();
    }
    public boolean isElementVisible(WebElement webElement){
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        }
        catch (org.openqa.selenium.TimeoutException | org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
