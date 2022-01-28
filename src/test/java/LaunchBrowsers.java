import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowsers {
    public static void main(String[] args) {
                                            //for chrome
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\SauravSharma\\Drivers\\chromedriver.exe\\");
                                            //for firefox
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\SauravSharma\\IdeaProjects\\New\\src" +
                "\\main\\resources\\geckodriver.exe\\");
                                            //for chrome
        //WebDriver driver = new ChromeDriver();
                                            //for firefox
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/?gws_rd=ssl");
    }
}