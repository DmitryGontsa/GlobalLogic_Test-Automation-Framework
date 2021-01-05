package AutomationPracticeTestsSuite;

import common.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pageobject.AutomationPracticeSite.AutomationPracticeMainPage;

public class ChecksProductPrices_test extends BaseTest {

    @Test
    public void verifyProductPrice() {

        String navigateUrl = propertyHelper.readProperty("automation-practice.site.url");
        webDriver.get(navigateUrl);
        String expectedResult = "$16.40";

        AutomationPracticeMainPage mainPage = new AutomationPracticeMainPage(webDriver);
        String actualResult = mainPage.getProductPriceText();

        Assert.assertTrue("Error! Product Item is not displayed!",
                mainPage.isPresentOfProductItem());
        Assert.assertEquals("Error! This is the wrong price!",
                expectedResult, actualResult);
    }
}
