package tests;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user"; 
    String Password = "secret_sauce"; 
    String homePageTitle = "Products";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String invalidUsername = "arja";
    String invalidUsernameError = "Epic sadface: Username and password do not match any user in this service";
    String invalidPassword = "dasa";
    String invalidPasswordError = "Epic sadface: Username and password do not match any user in this service";
    

@Test
public void openURL (){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();

    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
} 
@Test
public void verifySuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage(); 
    loginPage.login(standardUsername,Password);
    homePage.verifySuccesfulLogin(homePageTitle);

    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
@Test
public void verifyUnsuccesfulEmptypassword(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccesfulLogin(emptyPasswordError);

    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
@Test
public void verifyUnsuccesfullInvaldUsernameLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(invalidUsername, Password);
    loginPage.verifyUnsuccesfulLogin(invalidUsernameError);
    
    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
@Test
public void verifyUnsuccesfulInvalidPassword(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername,invalidPassword);
    loginPage.verifyUnsuccesfulLogin(invalidPasswordError);

    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
@Test
public void verifySuccessfulLogout(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, Password);
    homePage.verifySuccesfulLogin(homePageTitle);
    homePage.clickOnMenuButton();
    homePage.clikcOnLogoutButton();
    loginPage.verifyLogout();

    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        e.printStackTrace();
    }
}
}
