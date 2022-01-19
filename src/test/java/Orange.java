import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
public class Orange {
    public static void main(String[] args) throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\SauravSharma\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String userName = "TomHArdy001";
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
        actions.moveToElement(admin).perform();
        WebElement userManagement = driver.findElement(By.id("menu_admin_UserManagement"));
        actions.moveToElement(userManagement).perform();
        WebElement userButton = driver.findElement(By.id("menu_admin_viewSystemUsers"));
        userButton.click();
        driver.findElement(By.name("btnAdd")).click();
        driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("Aarti Patil");
        driver.findElement(By.id("systemUser_userName")).sendKeys(userName);
        driver.findElement(By.name("systemUser[password]")).sendKeys("Hardy@123");
        driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("Hardy@123");
        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        Thread.sleep(2000);
        saveButton.click();
        driver.findElement(By.name("searchSystemUser[userName]")).sendKeys(userName);
        driver.findElement(By.id("searchBtn")).click();
        String searchedUsernameXpath = "//a[contains(text(),'%s')]";
        WebElement searchedUsername = driver.findElement(By.xpath(String.format(searchedUsernameXpath, userName)));
        Assert.isTrue(searchedUsername.getText().equals(userName),"Username Not found");
        driver.close();
        // driver.quit();
    }
}