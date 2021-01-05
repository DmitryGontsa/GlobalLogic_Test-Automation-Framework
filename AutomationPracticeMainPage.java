package pageobject.AutomationPracticeSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class AutomationPracticeMainPage extends AbstractPage {

    @FindBy(xpath = "(//div[@class='product-container'])[7]")
    private WebElement productItem;

    @FindBy(xpath = "(//a[@class='product-name'][@title='Printed Chiffon Dress'])[1]")
    private WebElement productTitle;

    @FindBy(xpath = "//a[@title='Printed Chiffon Dress']")
    private WebElement productImageItem;

    @FindBy(xpath = "(//span[@class='price product-price'])[14]")
    private WebElement productPrice;

    public AutomationPracticeMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPresentOfProductItem() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productItem));
        boolean item = productItem.isDisplayed();
        return item;
    }

    public String getProductPriceText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));
        String text = productPrice.getText();
        String productPriceText = text.trim();
        return productPriceText;
    }

    public ProductDetailsPage moveOnProductDetailsPage() {
        actions.moveToElement(productImageItem).build().perform();
        productTitle.click();
        return new ProductDetailsPage(webDriver);
    }
}
