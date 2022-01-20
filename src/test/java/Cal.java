import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Cal {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click();
        driver.findElement(By.partialLinkText("Recruitment")).click();

        // from date in calendar
        driver.findElement(By.id("candidateSearch_fromDate")).click();
        String appdate = "19-Jan-2022";
        String[] temp = appdate.split("-");
        String date = temp[0];
        String month = temp[1];
        String year = temp[2];
        Select monthlist, yearlist;
        monthlist = new Select(driver.findElement(By.className("ui-datepicker-month")));
        monthlist.selectByVisibleText(month);
        yearlist = new Select(driver.findElement(By.className("ui-datepicker-year")));
        yearlist.selectByVisibleText(year);
        WebElement cal = driver.findElement(By.className("ui-datepicker-calendar"));
        List<WebElement> rows = cal.findElements(By.tagName("tr"));
        System.out.println("Number of Rows : " + rows.size());
        boolean flag = false;
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            System.out.println("Number of Columns : " + cols.size());
            for (int j = 0; j < cols.size(); j++) {

                String caldate = cols.get(j).getText();
                if (caldate.equals(date)) {
                    cols.get(j).click();
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        //to date in calendar
        driver.findElement(By.xpath("//input[@id='candidateSearch_toDate']")).click();
        String appdates = "22-Jan-2022";
        String[] tempr = appdates.split("-");
        String dates = tempr[0];
        String months = tempr[1];
        String years = tempr[2];
        Select monthlists, yearlists;
        monthlists = new Select(driver.findElement(By.className("ui-datepicker-month")));
        monthlists.selectByVisibleText(months);
        yearlists = new Select(driver.findElement(By.className("ui-datepicker-year")));
        yearlists.selectByVisibleText(years);
        WebElement call = driver.findElement(By.className("ui-datepicker-calendar"));
        rows = call.findElements(By.tagName("tr"));
        System.out.println("Number of Rows : " + rows.size());
        boolean flags = false;
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            System.out.println("Number of Columns : " + cols.size());
            for (int j = 0; j < cols.size(); j++) {

                String caldates = cols.get(j).getText();
                if (caldates.equals(dates)) {
                    cols.get(j).click();
                    flags = true;
                    break;
                }
            }
            if (flags) {
                break;
            }
        }
    }
}
