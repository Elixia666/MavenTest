import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestJava {

    @Test
    public void openGoogle(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Elixia\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
    }
}
