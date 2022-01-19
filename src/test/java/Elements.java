import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
//112123
public class Elements {
    public static void main(String[] args){
        //WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(160));

//        driver.get("https://google.com");
//        driver.findElement(By.name("q")).click();
//        driver.findElement(By.name("q")).sendKeys("Hello");  //will write Hello in search bar
//        driver.findElement(By.name("btnK")).click();  //will click on Google search button

//        WebElement searchBox = driver.findElement(By.name("q"));   //Will do same write,search,enter like above
//        searchBox.sendKeys("Hello", Keys.ENTER);
        driver.navigate().to("https://trytestingthis.netlify.app/");
//        List<WebElement> options = driver.findElements(By.name("Optionwithcheck[]"));  //This will get the list
//                            //and store it in a list of type web elements.
//        for(WebElement element : options){     //and we can use any loop to traverese through any list
//            System.out.println(element.getText());
//        }
        driver.findElement(By.cssSelector("#fname")).sendKeys("Jake ");
        driver.findElement(By.cssSelector("#lname")).sendKeys("Adams");
//      driver.findElement(By.xpath("//*[contains(text(),'Female')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Male')]")).click();//for male
//        JavascriptExecutor js = (JavascriptExecutor) driver;          //This will help
//        js.executeScript("window.scrollBy(0,2000)", "");  // scrolling the window downwards

        driver.close();
       // driver.quit();
    }
}
