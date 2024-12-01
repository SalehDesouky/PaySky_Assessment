package org.tests.WebTests.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    WebDriver driver;

    // Assuming the "Add to Cart" button is identified by this CSS selector.
    @FindBy(css = "img[alt=\"Combination Pliers\"]")
    WebElement selectedItem;

    @FindBy(id = "btn-add-to-cart")
    WebElement addToCartButton;
    WebDriverWait wait;

    // Constructor to initialize the WebDriver and PageFactory
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Method to add the product to the cart
    public void addProductToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(selectedItem));
        selectedItem.click();
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
    }
}
