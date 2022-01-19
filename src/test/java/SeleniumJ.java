import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumJ {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SauravSharma\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        //driver.quit();
    }
}