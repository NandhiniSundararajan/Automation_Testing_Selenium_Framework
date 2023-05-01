package Swag_Labs_Tests;

import Swag_Labs_Pages.LoginPage;
import Swag_Labs_Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTests{

    LoginPage login = new LoginPage();
    String errorNotificationFromLoginPage;

    @Test
    public void standard_userLoginTest(){
        login.navigateToHomePage();
        login.waitUntilLoginLogoIsVisible();

        //to login using valid username and password
        ProductsPage productsPageObj = login.loginUsingValidCredentials("standard_user","secret_sauce");

        //To check if we get the page title of Products page on successful login
        Assert.assertEquals(productsPageObj.getProductsPageTitle(),"Products","Products page title doesn't match!");
        System.out.println(productsPageObj.getProductsPageTitle());
    }

    @Test
    public void invalidUsernameLoginTest(){

        login.navigateToHomePage();
        login.waitUntilLoginLogoIsVisible();

        //to login using invalid username and valid password
        login.loginUsingInvalidCredentials("123","secret_sauce");

        errorNotificationFromLoginPage = login.getErrorNotification();
        //To check for the error notification when using an invalid username
        Assert.assertTrue(errorNotificationFromLoginPage.contains("Username and password do not match"));
    }


    @Test
    public void invalidPasswordLoginTest(){

        login.navigateToHomePage();
        login.waitUntilLoginLogoIsVisible();

        //to login using valid username and invalid password
        login.loginUsingInvalidCredentials("standard_user","invalid");
        errorNotificationFromLoginPage = login.getErrorNotification();

        //To check for the error notification when using an invalid password
        Assert.assertTrue(errorNotificationFromLoginPage.contains("Username and password do not match"));
    }

    @Test
    public void invalidUsernameAndPasswordLoginTest(){

        login.navigateToHomePage();
        login.waitUntilLoginLogoIsVisible();

        //to login using invalid username and password
        login.loginUsingInvalidCredentials("123","invalid");
        errorNotificationFromLoginPage = login.getErrorNotification();

        //To check for the error notification when using an invalid username and password
        Assert.assertTrue(errorNotificationFromLoginPage.contains("Username and password do not match"));
    }
}
