package tests;
import org.junit.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class ShoppingTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String homePageTitle = "Products";
    int numberOfAllItems = 6;
    String inventoryItemName1 = "Sauce Labs Bolt T-Shirt";
    String inventoryItemName2 = "Sauce Labs Fleece Jacket";    
    String firstName = "Aleksandar";
    String lastName = "Aćimov";
    int postalCod = 23272;
    String checkoutComplete = "Thank you for your order!"; 
     
@Test
     public void NumberOfProductsHomePage (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.verifyNumberOfProducts(numberOfAllItems);

        try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
    }      
    }
@Test
    public void verifySucessfulAddedProductsToCart (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.verifyProductsAddedToCart();
        checkoutPage.verifyAddedProductsInShoppingCart(inventoryItemName1, inventoryItemName2);

        try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
    }      
}
@Test
public void verifyCheckoutUserInformation (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(homePageTitle);
        homePage.verifyProductsAddedToCart();
        checkoutPage.verifyAddedProductsInShoppingCart(inventoryItemName1, inventoryItemName2);
        checkoutPage.clickOnCheckoutButton();
        checkoutPage.verifyUserInformationInCheckout(firstName, lastName, postalCod);
        checkoutPage.clickOnContinue();
        
        try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
    }      
}
@Test
public void verifyPriceOfProducts (){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductsAddedToCart();
    checkoutPage.verifyAddedProductsInShoppingCart(inventoryItemName1, inventoryItemName2);
    checkoutPage.clickOnCheckoutButton();
    checkoutPage.verifyUserInformationInCheckout(firstName, lastName, postalCod);
    checkoutPage.clickOnContinue();
    checkoutPage.verifyTotalPriceOfProducts();
    
    
    try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
    }     
}
@Test
public void verifyOrderCompleteMessage (){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.verifyProductsAddedToCart();
    checkoutPage.verifyAddedProductsInShoppingCart(inventoryItemName1, inventoryItemName2);
    checkoutPage.clickOnCheckoutButton();
    checkoutPage.verifyUserInformationInCheckout(firstName, lastName, postalCod);
    checkoutPage.clickOnContinue();
    checkoutPage.clickOnFinishButton(checkoutComplete);
   

    try{
          Thread.sleep(3000);
        }catch(InterruptedException e){
          e.printStackTrace();
    }      

  }
}


