package pageobject.AutomationPracticeSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class SummerDressesPage extends AbstractPage {

    @FindBy(xpath = "(//div[@class='product-container'])[3]")
    private WebElement productItem;

    @FindBy(xpath = "(//a[@title='Add to cart'])[3]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "(//div[@class='product-container'])[1]")
    private WebElement productContainer1;

    @FindBy(xpath = "(//div[@class='product-container'])[2]")
    private WebElement productContainer2;

    @FindBy(xpath = "(//div[@class='product-container'])[3]")
    private WebElement productContainer3;

    @FindBy(xpath = "(//a[@title='Add to cart'])[1]")
    private WebElement productItem1;

    @FindBy(xpath = "(//a[@title='Add to cart'])[2]")
    private WebElement productItem2;

    @FindBy(xpath = "(//a[@title='Add to cart'])[3]")
    private WebElement productItem3;

    @FindBy(xpath = "(//span[@itemprop='price'])[2]")
    private WebElement productPriceItem1;

    @FindBy(xpath = "(//span[@itemprop='price'])[4]")
    private WebElement productPriceItem2;

    @FindBy(xpath = "(//span[@itemprop='price'])[6]")
    private WebElement productPriceItem3;

    public SummerDressesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getProductContainer1() {
        return productContainer1;
    }

    public WebElement getProductContainer2() {
        return productContainer2;
    }

    public WebElement getProductContainer3() {
        return productContainer3;
    }

    public WebElement getProductItem1() {
        return productItem1;
    }

    public WebElement getProductItem2() {
        return productItem2;
    }

    public WebElement getProductItem3() {
        return productItem3;
    }

    public WebElement getProductPriceItem1() {
        return productPriceItem1;
    }

    public WebElement getProductPriceItem2() {
        return productPriceItem2;
    }

    public WebElement getProductPriceItem3() {
        return productPriceItem3;
    }

    public void selectAddToCartButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productItem));
        actions.moveToElement(productItem).build().perform();
        addToCartButton.click();
    }

    public void clickOnContinueShoppingButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public void addProductItemToShoppingCart(WebElement productContainer, WebElement productItem) {
        actions.moveToElement(productContainer).build().perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productItem));
        productItem.click();
    }

    public float getProductPriceText(WebElement productPriceItem) {
        webDriverWait.until(ExpectedConditions.visibilityOf(productPriceItem));
        String text1 = productPriceItem.getText();
        String text2 = text1.trim();
        String productPriceText = text2.substring(1, 6);
        float productPrice = Float.parseFloat(productPriceText);
        return productPrice;
    }

    public ShoppingCartPage moveOnShoppingCartPage() {
        actions.moveToElement(shoppingCartButton).build().perform();
        shoppingCartButton.click();
        return new ShoppingCartPage(webDriver);
    }
}
