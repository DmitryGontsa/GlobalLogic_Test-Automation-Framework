package AutomationPracticeTestsSuite;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.AutomationPracticeSite.ShoppingCartPage;
import pageobject.AutomationPracticeSite.SummerDressesPage;

public class ChecksAddToCartFunctionality_test extends BaseTest {

    @Test
    public void verifyAddToCartButtonFunctionality() {

        String navUrl = propertyHelper.readProperty("automation-practice.summer-dresses.url");
        webDriver.get(navUrl);

        SummerDressesPage summerDressesPage = new SummerDressesPage(webDriver);
        summerDressesPage.selectAddToCartButton();
        summerDressesPage.clickOnContinueShoppingButton();

        ShoppingCartPage shoppingCartPage = summerDressesPage.moveOnShoppingCartPage();

        Assert.assertTrue("Error! Product Item is not displayed!",
                shoppingCartPage.isPresentOfProductItem());
    }
}
