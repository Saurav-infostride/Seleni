import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//import java.util.List;
public class OrangeHrm {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SauravSharma\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(160));

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        String UserName = "Alphaaa";

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
       // WebElement mainMenu = driver.findElement(By.xpath("menu_admin_UserManagement"));
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.id("firstName")).sendKeys("Tom");
        driver.findElement(By.id("lastName")).sendKeys("Hardy");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("btnAddAttachment")).click();
        driver.findElement(By.id("ufile")).sendKeys("C:\\Users\\SauravSharma\\OneDrive - InfoStride Inc\\Pictures\\logo.jpg");
        driver.findElement(By.id("btnSaveAttachment")).click();
//        driver.findElement(By.id("system_userName")).sendKeys(UserName);
//        driver.findElement(By.name("systemUser[password]")).sendKeys("Hello*#@123");
//        driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("Hello*#@123");
//        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
//        Thread.sleep(2000);
//        saveButton.click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;          //This will help
//        js.executeScript("window.scrollBy(0,2000)", "");  // scrolling the window downwards

        //driver.close();
        // driver.quit();
    }
}