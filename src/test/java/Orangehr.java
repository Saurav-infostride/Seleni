import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

class Parent{
    WebDriver driver = new ChromeDriver();

    void login(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
    }

    void adduser(){
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Thomass");
        driver.findElement(By.id("lastName")).sendKeys("Shelbyy");
        driver.findElement(By.id("employeeId")).sendKeys("1234");
        driver.findElement(By.id("btnSave")).click();
    }

    void delete(){
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Aatim897");
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.id("ohrmList_chkSelectRecord_66")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }
    void logout(){
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Select dropdown = new Select(driver.findElement(By.id("welcome")));
//        dropdown.selectByVisibleText("Logout");

        driver.findElement(By.id("welcome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.partialLinkText("Logout")).click();
    }
}
class Orangehr extends Parent{
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        Parent abc = new Parent();
        abc.login();
        abc.adduser();
        abc.delete();
        abc.logout();
    }
}
