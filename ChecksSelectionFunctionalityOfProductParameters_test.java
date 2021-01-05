package AutomationPracticeTestsSuite;

import common.BaseTest;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import pageobject.AutomationPracticeSite.AutomationPracticeMainPage;
import pageobject.AutomationPracticeSite.ProductDetailsPage;
import pageobject.AutomationPracticeSite.ShoppingCartPage;

public class ChecksSelectionFunctionalityOfProductParameters_test extends BaseTest {

    @Test
    public void verifySelectionFunctionalityOfProductParameters() {

        String navUrl = propertyHelper.readProperty("automation-practice.site.url");
        webDriver.get(navUrl);

        String expectedResultOfProductTitle;
        String expectedResultOfProductSize;
        String expectedResultOfProductQuantity;

        AutomationPracticeMainPage mainPage = new AutomationPracticeMainPage(webDriver);
        ProductDetailsPage detailsPage = mainPage.moveOnProductDetailsPage();

        detailsPage.selectProductQuantity();
        detailsPage.selectProductSize();

        expectedResultOfProductTitle = detailsPage.getProductTitleText();
        expectedResultOfProductSize = detailsPage.getProductSizeItemText();
        expectedResultOfProductQuantity = detailsPage.getProductQuantityText();

        detailsPage.selectAddToCartButton();
        detailsPage.clickOnContinueShoppingButton();
        ShoppingCartPage shoppingCartPage = detailsPage.moveOnShoppingCartPage();

        String actualResultOfProductTitle = shoppingCartPage.getProductTitleText();
        String actualResultOfProductSize = shoppingCartPage.getProductSizeText();
        String actualResultOfProductQuantity = shoppingCartPage.getProductQuantityText();

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualResultOfProductTitle)
                .as("Error! This is incorrect product title!")
                .isEqualTo(expectedResultOfProductTitle);

        softAssertions.assertThat(actualResultOfProductSize)
                .as("Error! This is incorrect product size!")
                .isEqualTo(expectedResultOfProductSize);

        softAssertions.assertThat(actualResultOfProductQuantity)
                .as("Error! This is incorrect product quantity!")
                .isEqualTo(expectedResultOfProductQuantity);
        softAssertions.assertAll();
    }
}
