import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

class Parent{
    WebDriver driver = new ChromeDriver();

    void login()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
    }

    void adduser()
    {
        String firstName = RandomStringUtils.randomAlphabetic(8);
        String lastName = RandomStringUtils.randomAlphabetic(8);
        String employeeID = RandomStringUtils.randomNumeric(4);
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("employeeId")).sendKeys(employeeID);
        driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\SauravSharma\\" +
                "OneDrive - InfoStride Inc\\Pictures\\logo.jpg");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)", "");
        driver.findElement(By.id("btnSave")).click();
    }

    void edit() throws InterruptedException
    {
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.xpath("//*[contains(@href,'saveSystemUser?userId=1')]")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("systemUser_userName")).clear();
        driver.findElement(By.id("systemUser_userName")).sendKeys("Aayushi");
        driver.findElement(By.name("btnSave")).click();
        driver.findElement(By.id("btnSave")).click();
    }

    void delete()
    {
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Aayushkhadel");
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.id("ohrmList_chkSelectRecord_79")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }

    void logout()
    {
        driver.findElement(By.id("welcome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.partialLinkText("Logout")).click();
    }

}
class Orangehr extends Parent{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        Parent abc = new Parent();
        abc.login();
        abc.adduser();
        abc.edit();
        abc.delete();
        abc.logout();
    }
}
