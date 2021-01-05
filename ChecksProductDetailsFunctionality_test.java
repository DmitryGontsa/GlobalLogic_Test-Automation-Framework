package AutomationPracticeTestsSuite;

import common.BaseTest;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pageobject.AutomationPracticeSite.AutomationPracticeMainPage;
import pageobject.AutomationPracticeSite.ProductDetailsPage;

public class ChecksProductDetailsFunctionality_test extends BaseTest {

    @Test
    public void verifyProductDetailsPageFunctionality() {

        String navigateUrl = propertyHelper.readProperty("automation-practice.site.url");
        webDriver.get(navigateUrl);

        String expectedResultOfProductTitle = "Printed Chiffon Dress";
        String expectedResultOfProductPrice = "$16.40";
        String expectedResultOfProductQuantity = "1";
        String expectedResultOfProductSize = "S";
        String expectedResultOfProductColor = "Yellow";
        String expectedResultOfProductCompositions = "Polyester";
        String expectedResultOfProductStyles = "Girly";
        String expectedResultOfProductProperties = "Midi Dress";

        AutomationPracticeMainPage mainPage = new AutomationPracticeMainPage(webDriver);
        ProductDetailsPage detailsPage = mainPage.moveOnProductDetailsPage();

        String actualResultOfProductTitle = detailsPage.getProductTitleText();
        String actualResultOfProductPrice = detailsPage.getProductPriceText();
        String actualResultOfProductQuantity = detailsPage.getProductQuantityText();
        String actualResultOfProductSize = detailsPage.getProductSizeText();
        String actualResultOfProductColor = detailsPage.getProductColorText();
        String actualResultOfProductCompositions = detailsPage.getProductCompositionsText();
        String actualResultOfProductStyles = detailsPage.getProductStylesText();
        String actualResultOfProductProperties = detailsPage.getProductPropertiesText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResultOfProductTitle, expectedResultOfProductTitle, "This is incorrect product title!");
        softAssert.assertEquals(actualResultOfProductPrice, expectedResultOfProductPrice, "This is incorrect product price!");
        softAssert.assertEquals(actualResultOfProductQuantity, expectedResultOfProductQuantity, "This is incorrect product quantity!");
        softAssert.assertEquals(actualResultOfProductSize, expectedResultOfProductSize, "This is incorrect product size!");
        softAssert.assertEquals(actualResultOfProductColor, expectedResultOfProductColor, "This is incorrect product color!");
        softAssert.assertEquals(actualResultOfProductCompositions, expectedResultOfProductCompositions, "This is incorrect product compositions!");
        softAssert.assertEquals(actualResultOfProductStyles, expectedResultOfProductStyles, "This is incorrect product styles!");
        softAssert.assertEquals(actualResultOfProductProperties, expectedResultOfProductProperties, "This is incorrect product properties!");
        softAssert.assertAll();
    }
}
