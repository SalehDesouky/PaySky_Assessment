package org.tests.WebTests.WebPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    @FindBy(css = "a[data-test=\"nav-cart\"]")  // Replace with the actual cart icon element
    WebElement cartIcon;

    @FindBy(css = "button[data-test=\"proceed-1\"]")  // Replace with the actual checkout button element
    WebElement proceed1Button;

    @FindBy(css = "button[data-test=\"proceed-2\"]")  // Replace with the actual checkout button element
    WebElement proceed2Button;

    @FindBy(css = "button[data-test=\"proceed-3\"]")  // Replace with the actual checkout button element
    WebElement proceed3Button;

    @FindBy(css = "input[data-test=\"email\"]")  // Replace with the actual checkout button element
    WebElement emailInput;
    @FindBy(css = "input[data-test=\"password\"]")  // Replace with the actual checkout button element
    WebElement passwordInput;

    @FindBy(css = "input[data-test=\"login-submit\"]")  // Replace with the actual checkout button element
    WebElement logIn;
    WebDriverWait wait;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(55));
    }

    // Method to go to the checkout page
    public void goToCheckout(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(cartIcon));
//        cartIcon.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cartIcon);
        wait.until(ExpectedConditions.visibilityOf(proceed1Button));
        proceed1Button.click();
        // login to continue
         LogIn(email, password);
        wait.until(ExpectedConditions.visibilityOf(proceed2Button));
        proceed2Button.click();
        wait.until(ExpectedConditions.visibilityOf(proceed3Button));
        proceed3Button.click();
    }
    public void LogIn(String userEmail , String pass){

        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(userEmail);
        passwordInput.sendKeys(pass);
        wait.until(ExpectedConditions.visibilityOf(logIn));
        logIn.click();
    }
}
