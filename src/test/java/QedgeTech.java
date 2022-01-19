import io.github.bonigarcia.wdm.WebDriverManager;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
public class QedgeTech {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\SauravSharma\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://projects.qedgetech.com/webapp/login.php");
//        driver.findElement(By.id("username")).sendKeys("admin");
//        driver.findElement(By.id("password")).sendKeys("master");
        driver.findElement(By.id("btnsubmit")).click();
        driver.findElement(By.id("mi_a_customers")).click();
//        driver.findElement(By.className("btn btn-default ewAddEdit ewAdd btn-sm")).click();
        //for male  driver.findElement(By.xpath("//*[contains(text(),'Male')]")).click();
        driver.findElement(By.xpath("//*[contains(@href,'a_customersadd.php?showdetail=')]")).click();
        driver.findElement(By.id("x_Customer_Name")).sendKeys("Tom Hardy");
        driver.findElement(By.id("x_Address")).sendKeys("#007");
        driver.findElement(By.id("x_City")).sendKeys("Mohali");
        driver.findElement(By.id("x_Country")).sendKeys("India");
        driver.findElement(By.id("x_Contact_Person")).sendKeys("Bob Hardy");
        driver.findElement(By.id("x_Phone_Number")).sendKeys("100102911");
        driver.findElement(By.id("x__Email")).sendKeys("tomhardy@gmail.com");
        driver.findElement(By.id("x_Mobile_Number")).sendKeys("0987654321");
        driver.findElement(By.id("x_Notes")).sendKeys("Hello");
        driver.findElement(By.name("btnAction")).click();
        driver.findElement(By.xpath("//button[contains(text(),'OK!')]"));
//        Alert confirmationAlert = driver.switchTo().alert();
//        System.out.println(confirmationAlert.getText());
        Thread.sleep(2000);
//        confirmationAlert.accept();
//        Thread.sleep(2000);

        //driver.findElement(By.className("ajs-button btn btn-primary")).click();
        //driver.quit();
    }
}
