package AutomationPracticeTestsSuite;

import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import pageobject.AutomationPracticeSite.ShoppingCartPage;
import pageobject.AutomationPracticeSite.SummerDressesPage;

public class ChecksCalculationTotalProductsPrice_test extends BaseTest {

    @Test
    public void verifyCalculationFunctionalityOfTotalProductsPrice() {

        String navigateUrl = propertyHelper.readProperty("automation-practice.summer-dresses.url");
        webDriver.get(navigateUrl);

        float expectedResultOfTotalProductsPrice = 0.0f;
        float actualResultOfTotalProductsPrice = 0.0f;

        SummerDressesPage summerDressesPage = new SummerDressesPage(webDriver);

        summerDressesPage.addProductItemToShoppingCart(summerDressesPage.getProductContainer1(),
                summerDressesPage.getProductItem1());
        summerDressesPage.clickOnContinueShoppingButton();

        summerDressesPage.addProductItemToShoppingCart(summerDressesPage.getProductContainer2(),
                summerDressesPage.getProductItem2());
        summerDressesPage.clickOnContinueShoppingButton();

        summerDressesPage.addProductItemToShoppingCart(summerDressesPage.getProductContainer3(),
                summerDressesPage.getProductItem3());
        summerDressesPage.clickOnContinueShoppingButton();

        expectedResultOfTotalProductsPrice += summerDressesPage.getProductPriceText(summerDressesPage.getProductPriceItem1());
        expectedResultOfTotalProductsPrice += summerDressesPage.getProductPriceText(summerDressesPage.getProductPriceItem2());
        expectedResultOfTotalProductsPrice += summerDressesPage.getProductPriceText(summerDressesPage.getProductPriceItem3());

        ShoppingCartPage shoppingCartPage = summerDressesPage.moveOnShoppingCartPage();
        actualResultOfTotalProductsPrice = shoppingCartPage.getTotalProductsPriceText();

        Assertions.assertThat(actualResultOfTotalProductsPrice)
                .as("Error! This is Total Products Price calculated incorrectly!")
                .isEqualTo(expectedResultOfTotalProductsPrice);
    }
}
