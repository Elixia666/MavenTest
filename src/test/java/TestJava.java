import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestJava {

    @Test
    public void openGoogle(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Elixia\\Downloads\\geckodriver.exe");
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize(); //full screen
        Dimension winsize = new Dimension(800 ,600);
        firefox.manage().window().setSize(winsize);
        firefox.get("https://www.google.com");
    }
}
