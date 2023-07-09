package pages;
import  org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage (WebDriver driver){
        super(driver);
    }
    By inventoryItemName1By =By.xpath("//*[@id='item_1_title_link']/div");
    By inventoryItemName2By = By.xpath("//*[@id='item_5_title_link']/div");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By checkoutButtonBy = By.xpath("//*[@id='checkout']");
    By firstNameBy = By.xpath("//*[@id='first-name']");
    By lastNameBy = By.xpath("//*[@id='last-name']");
    By zipPostalCod = By.xpath("//*[@id='postal-code']");
    By continueBy = By.id("continue");
    By finishButtonBy = By.xpath("//*[@id='finish']");
    By checkoutCompleteBy = By.className("complete-header");
    By s1 = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]");
    By s2 = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");
    By s3 = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[8]");

    public CheckoutPage verifyAddedProductsInShoppingCart ( String expectedText1, String expectedText2){
        click(shoppingCartBadgeBy);
        String actualText1 = readText(inventoryItemName1By);
        assertTextEquals(expectedText1, actualText1);      
        waitVisability(inventoryItemName1By);
       
        String actualText2 = readText(inventoryItemName2By);
        assertTextEquals(expectedText2, actualText2);      
        waitVisability(inventoryItemName2By);
        return this;    
    }
    public CheckoutPage clickOnCheckoutButton (){
        click(checkoutButtonBy);
        return this;
    } 
    public CheckoutPage verifyUserInformationInCheckout ( String firstName, String lastName, int postalCod){
        writetext(firstNameBy, firstName);
        writetext(lastNameBy, lastName);
        enterNumber(zipPostalCod,postalCod);
        return this;
    }
    public CheckoutPage clickOnContinue (){
        click(continueBy);
        return this;         
    }    
    public CheckoutPage verifyTotalPriceOfProducts ( ) {
       String s1Text = readText(s1);
       String itemTotalNo$ = s1Text.substring(s1Text.indexOf("$") + 1);
       double itemTotal = Double.parseDouble(itemTotalNo$);
       Assert.assertEquals(itemTotal,Double.parseDouble(readText(s1).substring(s1Text.indexOf("$") + 1)), 0.001 );
       
       String s2Text = readText(s2);
       String itemTaxNo$ = s2Text.substring(s2Text.indexOf("$") + 1);
       double itemTax = Double.parseDouble(itemTaxNo$); 
       Assert.assertEquals(itemTax,Double.parseDouble(readText(s2).substring(s2Text.indexOf("$") + 1)), 0.001 );
       
       String s3Text = readText(s3);
       String totalNo$ = s3Text.substring(s3Text.indexOf("$") +1);
       double total = Double.parseDouble(totalNo$);        
       Assert.assertEquals(total,Double.parseDouble(readText(s3).substring(s3Text.indexOf("$") + 1)), 0.001 );
       
       double expectedSum = itemTotal + itemTax;
       double tolerance = 0.001;
       Assert.assertEquals(expectedSum, total, tolerance);
      
       return this;
    }
     public CheckoutPage clickOnFinishButton (String expectedText){ 
        click(finishButtonBy);
        String actualText = readText(checkoutCompleteBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }
}

