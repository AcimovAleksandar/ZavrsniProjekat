package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage (WebDriver driver){
        super(driver);
    }
    By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By menuButtonBy = By.id("react-burger-menu-btn");   
    By logoutButtonBy = By.id("logout_sidebar_link");
    By numberOfItems = By.className("inventory_item");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    

    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    } 
    public HomePage clickOnMenuButton(){
        click(menuButtonBy);
        return this;
    }
    public HomePage clikcOnLogoutButton(){
        click(logoutButtonBy);
        return this;
    }
    public HomePage verifyNumberOfProducts ( int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfItems);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }
    public HomePage verifyProductsAddedToCart (){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisability(shoppingCartBadgeBy);
        return this;
    }
}
