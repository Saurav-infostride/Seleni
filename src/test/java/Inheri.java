import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Scanner;

class Parent{
    WebDriver driver = new ChromeDriver();
    String txtUsername = "Admin";
    String txtPassword = "admin123";
    String firstName = RandomStringUtils.randomAlphabetic(8);
    String lastName = RandomStringUtils.randomAlphabetic(8);
    String employeeID = RandomStringUtils.randomNumeric(4);
    String fullName = firstName + lastName;
    Select drag;

    void login() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys(txtUsername);
        driver.findElement(By.id("txtPassword")).sendKeys(txtPassword);
        driver.findElement(By.name("Submit")).click();
    }
    void recruit(String da,String dat) throws InterruptedException {
        driver.findElement(By.linkText("Recruitment")).click();
        driver.findElement(By.linkText("Candidates")).click();
        drag= new Select(driver.findElement(By.id("candidateSearch_jobTitle")));
        drag.selectByValue("27");
        Thread.sleep(2000);
        drag = new Select(driver.findElement(By.id("candidateSearch_jobVacancy")));
        drag.selectByVisibleText("All");
        Thread.sleep(2000);
        drag = new Select(driver.findElement(By.id("candidateSearch_hiringManager")));
        drag.selectByValue("7");
        Thread.sleep(2000);
        driver.findElement(By.id("candidateSearch_fromDate")).clear();
        driver.findElement(By.id("candidateSearch_fromDate")).sendKeys(da);
        driver.findElement(By.id("candidateSearch_toDate")).clear();
        driver.findElement(By.id("candidateSearch_toDate")).sendKeys(dat);
        driver.findElement(By.id("btnSrch")).click();
    }
    void adduser() {
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("employeeId")).sendKeys(employeeID);
        driver.findElement(By.id("photofile")).sendKeys("C:\\Users\\SauravSharma\\" +
                "OneDrive - InfoStride Inc\\Pictures\\logo.jpg");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(fullName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"searchBtn\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_44\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[@id=\"btnDelete\"]")).click();
    }
    void edit() {
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys(txtUsername);
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.xpath("//*[contains(@href,'saveSystemUser?userId=1')]")).click();
        driver.findElement(By.id("btnSave")).click();
        driver.findElement(By.id("systemUser_userName")).clear();
        driver.findElement(By.id("systemUser_userName")).sendKeys(fullName);
        driver.findElement(By.name("btnSave")).click();
        driver.findElement(By.id("btnSave")).click();
    }
    void delete() {
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("searchSystemUser_userName")).sendKeys(fullName);
        driver.findElement(By.id("searchBtn")).click();
        driver.findElement(By.id("ohrmList_chkSelectRecord_79")).click();
        driver.findElement(By.id("btnDelete")).click();
        driver.findElement(By.id("dialogDeleteBtn")).click();
    }
    void logout() {
        driver.findElement(By.id("welcome")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.partialLinkText("Logout")).click();
    }
}
class Inheri extends Parent{
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enter search from date as YYYY-MM-DD");
        Scanner obj=new Scanner(System.in);
        String date=obj.nextLine();
        System.out.println("Enter search to date as YYYY-MM-DD");
        String dat=obj.nextLine();
        WebDriverManager.chromedriver().setup();
        Parent abc = new Parent();
        abc.login();
        abc.adduser();
        abc.recruit(date,dat);
        abc.edit();
        abc.delete();
        abc.logout();
    }
}
