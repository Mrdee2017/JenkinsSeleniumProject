import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Kale on 1/14/2017.
 */
public class TestingJenkinsSelInt {
    public String url = "https://www.google.com/";
    public WebDriver driver;
    public String propId, propName, propTitle;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumSetup\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test
    public void testWebTitle() {
        propTitle = "Google";
        Assert.assertEquals(driver.getTitle(),propTitle,"TestFailed:Expected title not found.");
        }
    @Test
    public void logoCheck(){
        propId = "hplogo";
        WebElement actualId = driver.findElement(By.id(propId));
        if (!(actualId.toString().contains(propId))){
            Assert.assertFalse(false,"TestFailed:Expected image not found");
        }
    }
    @Test
    public void searchBarCheck(){
        propId = "lst-ib";
        WebElement actualId = driver.findElement(By.id(propId));
        if (!(actualId.toString().contains(propId))){
            Assert.assertFalse(false,"TestFailed:Expected search bar not found");
        }
    }
    @Test
    public void SearchButton(){
        propName = "btnK";
        WebElement actualName = driver.findElement(By.name(propName));
        WebElement actualvalue= driver.findElement(By.cssSelector("input[value='Google Search'][aria-label='Google Search']"));
        System.out.println("label is: " + actualvalue);
        if (!(actualName.toString().contains(propName) || actualvalue.toString().contains("Google Search") )){
            Assert.assertFalse(false,"TestFailed:Expected Search button not found");
        }
    }

    @Test
    public void SearchFunction()throws InterruptedException {
        propId = "lst-ib";
        WebElement srcbr = driver.findElement(By.id(propId));
        propName = "btnK";
        WebElement srchbtn = driver.findElement(By.name(propName));
        srcbr.sendKeys("selenium");
    }


    @AfterTest
    public void cleanup(){
        driver.quit();
    }


}
