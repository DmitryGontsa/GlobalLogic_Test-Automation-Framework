package pageobject.AutomationPracticeSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "(//img[@alt='Printed Chiffon Dress'])[3]")
    private WebElement productItem;

    @FindBy(xpath = "//a[text()='Printed Chiffon Dress']")
    private WebElement productTitle;

    @FindBy(xpath = "//a[text()='Color : Yellow, Size : M']")
    private WebElement productSize;

    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    private WebElement productQuantity;

    @FindBy(xpath = "//tr[@class='cart_total_price']/td[@id='total_product']")
    private WebElement totalProductsPrice;

    @FindBy(xpath = "(//a[@title='Delete'])[1]")
    private WebElement printedSummerDressProductItem1;

    public ShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isPresentOfProductItem() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productItem));
        boolean item = productItem.isDisplayed();
        return item;
    }

    public WebElement getPrintedSummerDressProductItem1() {
        return printedSummerDressProductItem1;
    }

    public String getProductTitleText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productTitle));
        String productTitleText = productTitle.getText();
        return productTitleText;
    }

    public String getProductSizeText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productSize));
        String text = productSize.getText();
        String productSizeText = text.substring(23, 24);
        return productSizeText;
    }

    public String getProductQuantityText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productQuantity));
        String productQuantityText = productQuantity.getAttribute("value");
        return productQuantityText;
    }

    public float getTotalProductsPriceText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(totalProductsPrice));
        String text = totalProductsPrice.getText();
        String totalProductsPriceText = text.substring(1, 6);
        float totalProductsPrice = Float.parseFloat(totalProductsPriceText);
        return totalProductsPrice;
    }

    public void deleteProductItem(WebElement productItem) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productItem));
        productItem.click();
    }
}
