package pageobject.AutomationPracticeSite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobject.AbstractPage;

public class ProductDetailsPage extends AbstractPage {

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productTitle;

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement productPrice;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement productQuantity;

    @FindBy(xpath = "//select[@name='group_1']/option[@title='S']")
    private WebElement productSize;

    @FindBy(xpath = "//a[@name='Yellow']")
    private WebElement productColor;

    @FindBy(xpath = "(//tr[@class='odd']/td)[2]")
    private WebElement productCompositions;

    @FindBy(xpath = "(//tr[@class='even']/td)[2]")
    private WebElement productStyles;

    @FindBy(xpath = "(//tr[@class='odd']/td)[4]")
    private WebElement productProperties;

    @FindBy(xpath = "//select[@name='group_1']/option[@title='M']")
    private WebElement productSizeItem;

    @FindBy(xpath = "(//a[@data-field-qty='qty']/span)[2]")
    private WebElement addProductQuantityButton;

    @FindBy(xpath = "(//select[@name='group_1']/option)[2]")
    private WebElement selectProductSizeItem;

    @FindBy(xpath = "//button[@type='submit']/span[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement shoppingCartButton;

    public ProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getProductTitleText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productTitle));
        String productTitleText = productTitle.getText();
        return productTitleText;
    }

    public String getProductPriceText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productPrice));
        String productPriceText = productPrice.getText();
        return productPriceText;
    }

    public String getProductQuantityText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productQuantity));
        String productQuantityText = productQuantity.getAttribute("value");
        return productQuantityText;
    }

    public String getProductSizeText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productSize));
        String productSizeText = productSize.getAttribute("title");
        return productSizeText;
    }

    public String getProductSizeItemText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productSizeItem));
        String productSizeItemText = productSizeItem.getAttribute("title");
        return productSizeItemText;
    }

    public String getProductColorText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productColor));
        String productColorText = productColor.getAttribute("title");
        return productColorText;
    }

    public String getProductCompositionsText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productCompositions));
        String productCompositionsText = productCompositions.getText();
        return productCompositionsText;
    }

    public String getProductStylesText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productStyles));
        String productStylesText = productStyles.getText();
        return productStylesText;
    }

    public String getProductPropertiesText() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productProperties));
        String productPropertiesText = productProperties.getText();
        return productPropertiesText;
    }

    public void selectProductQuantity() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addProductQuantityButton));
        addProductQuantityButton.click();
    }

    public void selectProductSize() {
        webDriverWait.until(ExpectedConditions.visibilityOf(productSize));
        productSize.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectProductSizeItem));
        selectProductSizeItem.click();
    }

    public void selectAddToCartButton() {
        webDriverWait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void clickOnContinueShoppingButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public ShoppingCartPage moveOnShoppingCartPage() {
        actions.moveToElement(shoppingCartButton).build().perform();
        shoppingCartButton.click();
        return new ShoppingCartPage(webDriver);
    }
}
