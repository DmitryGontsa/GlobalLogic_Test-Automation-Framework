package AutomationPracticeTestsSuite;

import common.BaseTest;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import pageobject.AutomationPracticeSite.ShoppingCartPage;
import pageobject.AutomationPracticeSite.SummerDressesPage;

public class ChecksShoppingCartPageFunctionality_test extends BaseTest {

    @Test
    public void verifyShoppingCartPageFunctionalityOfTotalProductsPrice() {

        String navUrl = propertyHelper.readProperty("automation-practice.summer-dresses.url");
        webDriver.get(navUrl);

        float totalProductsPrice = 0.0f;
        float productsPriceBuffer1 = 0.0f;
        float productsPriceBuffer2 = 0.0f;
        float productsPriceBuffer3 = 0.0f;

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

        productsPriceBuffer1 = summerDressesPage.getProductPriceText(summerDressesPage.getProductPriceItem1());
        totalProductsPrice += productsPriceBuffer1;

        productsPriceBuffer2 = summerDressesPage.getProductPriceText(summerDressesPage.getProductPriceItem2());
        totalProductsPrice += productsPriceBuffer2;

        productsPriceBuffer3 = summerDressesPage.getProductPriceText(summerDressesPage.getProductPriceItem3());
        totalProductsPrice += productsPriceBuffer3;

        ShoppingCartPage shoppingCartPage = summerDressesPage.moveOnShoppingCartPage();
        shoppingCartPage.deleteProductItem(shoppingCartPage.getPrintedSummerDressProductItem1());

        expectedResultOfTotalProductsPrice = totalProductsPrice - productsPriceBuffer1;

        actualResultOfTotalProductsPrice = shoppingCartPage.getTotalProductsPriceText();

        Assertions.assertThat(actualResultOfTotalProductsPrice)
                .as("Error! This is Total Products Price calculated incorrectly!")
                .isEqualTo(expectedResultOfTotalProductsPrice);
    }
}
