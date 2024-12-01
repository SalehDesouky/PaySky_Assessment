package org.tests.WebTests.WebPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "payment-method")  // Replace with the actual billing address input field
    WebElement selectPaymentMethod;

    @FindBy(css = "button[data-test=\"finish\"]")  // Replace with the actual "Complete Order" button element
    WebElement confirmButton;

    @FindBy(css = "div.help-block")  // Replace with the actual "Complete Order" button element
    WebElement successMessageElement;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    // Method to  select Payment Method
    public void selectPaymentMethodfromList(String paymentMethodValue) {
        Select paymentMethodSelect = new Select(selectPaymentMethod);
        // Select "Cash on Delivery" by value
        paymentMethodSelect.selectByValue(paymentMethodValue);

    }

    // Method to complete the order
    public void completeOrder() {

        confirmButton.click();
        wait.until(ExpectedConditions.visibilityOf(successMessageElement));
        String actualMessage = successMessageElement.getText();

        // Expected message
        String expectedMessage = "Payment was successful";

            // Assert the success message
            Assert.assertEquals(actualMessage, expectedMessage, "Assertion failed: Message does not match!");
//
    }
}
