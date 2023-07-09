package pages;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
   
    public WebDriver driver;
    public WebDriverWait wait;
    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void waitVisability (By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void writetext (By elementBy, String text){   
        waitVisability(elementBy); 
        driver.findElement(elementBy).clear(); 
        driver.findElement(elementBy).sendKeys(text); 
    }
    public void click (By elementBy){ 
        waitVisability(elementBy);
        driver.findElement(elementBy).click();
    }
    public String readText (By elemntBy){ 
        waitVisability(elemntBy); 
        return driver.findElement(elemntBy).getText();
    }    
    public void assertTextEquals (String expectedText, String actualText){  
        Assert.assertEquals( expectedText, actualText);
    }
    public int countItems (By elementBy){
       waitVisability(elementBy);
       return driver.findElements(elementBy).size(); 
    }
    public void assertIntegerEquals (int expectedInt, int actualInt){ 
        Assert.assertEquals(expectedInt, actualInt);
    }
    public void enterNumber (By elementBy, int number){
        waitVisability(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(By.xpath("//*[@id='postal-code']")).sendKeys("23272");   
    }
    public void assertDoubleEquals( double expectedDouble, double actualDouble){
        Assert.assertEquals(expectedDouble, actualDouble, 0.001);
    }   
}