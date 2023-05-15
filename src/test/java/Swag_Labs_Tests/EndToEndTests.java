package Swag_Labs_Tests;

import Swag_Labs_Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class EndToEndTests extends BaseTests{
    LoginPage login = new LoginPage();
    @Test
    public void swagLabsTest1(){

        login.navigateToHomePage();
        login.waitUntilLoginLogoIsVisible();
        ProductsPage productPageObj = login.loginUsingValidCredentials("standard_user","secret_sauce");

        int actualNumberOfItemsInCart = productPageObj.noOfItemsInCart();

        //Assert 1 - to check if the shopping cart has zero number of items before adding items to the cart
        Assert.assertEquals(actualNumberOfItemsInCart, 0, "The cart is not empty!!");

        List<String> itemsList = List.of("Sauce Labs Backpack","Sauce Labs Bolt T-Shirt");

        //to add items to the shopping cart
        for(String item : itemsList){
            productPageObj.addToCart(item);
        }

        //Assert 2 - to check if the shopping cart has the correct number of items after product selection
        Assert.assertEquals(productPageObj.noOfItemsInCart(),itemsList.size(),"Number of items in the cart is not as expected");

        CheckoutPage checkoutPageObj = productPageObj.openShoppingCart();

        //Assert 3 - to check the items in the shopping cart are the same as the items in the shopping list
        List <String> actualItemsFromTheCart = checkoutPageObj.getItemsFromCart();
        Assert.assertTrue(actualItemsFromTheCart.containsAll(itemsList));

        UserInformationPage infoObj = checkoutPageObj.checkout();
        infoObj.getUserInformation("first","last","234");
        OverviewPage overviewPageObj = infoObj.navigateToOverviewPage();
        Double sumOfItemPricesInCart = overviewPageObj.sumOfItemPrices();

        //Assert 4 - to check the tax amount is exactly 0.08% of the total amount
        Double expectedTaxAmount = overviewPageObj.calculateTaxAmount(sumOfItemPricesInCart);
        Double actualTaxAmount = overviewPageObj.getTaxAmountFromApp();

        Assert.assertEquals(actualTaxAmount,expectedTaxAmount,"Tax amount is not as expected");

        //Assert 5 - to check the total amount from the app is as expected
        Double expectedTotalAmount = overviewPageObj.calculateTotalAmountToBePaid();
        Double actualTotalAmount = overviewPageObj.totalAmountFromTheApp();

        Assert.assertEquals(actualTotalAmount, expectedTotalAmount, "Total amount is not as expected");

        FinalPage finalPageObj = overviewPageObj.navigateToFinalPage();

        //Assert 6 - to check if the success message contains the string "Thank you"
        String actualSuccessMsg = finalPageObj.successMsgFromApp();
        Assert.assertTrue(actualSuccessMsg.contains("Thank you"));

        finalPageObj.navigateBackToHomePage();

        //Assert 7 - to verify the product page title after navigating from final page to home page
        String actualPageTitleOfProductsPage = productPageObj.getProductsPageTitle();
        Assert.assertTrue(actualPageTitleOfProductsPage.contains("Products"));
    }
}
