package org.tests.WebTests.WebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriverWait wait;

    // Locators
    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "dob")
    private WebElement dobInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "country")
    private WebElement countryDropdown;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[data-test=\"register-submit\"]")
    private WebElement registerButton;

    @FindBy(css = "a[data-test=\"nav-sign-in\"]")
    private WebElement signInButton;

    @FindBy(css = "a[data-test=\"register-link\"]")
    private WebElement registerLink;

    @FindBy(css = "a[data-test=\"nav-home\"]")
    private WebElement homeLink;

    // Constructor
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjusted wait time
    }

    // Actions
    public void goToRegister() {
        wait.until(ExpectedConditions.visibilityOf(signInButton)).click();
        wait.until(ExpectedConditions.visibilityOf(registerLink)).click();
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void setDateOfBirth(String dob) {
        dobInput.sendKeys(dob); // Assumes 'yyyy-MM-dd' format
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterPostcode(String postcode) {
        postcodeInput.sendKeys(postcode);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        stateInput.sendKeys(state);
    }

    public void selectCountryByValue(String countryValue) {
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        Select select = new Select(countryDropdown);
        select.selectByValue(countryValue); // Example: "EG" for Egypt
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void clickRegister() {
        registerButton.click();
    }
    public void clickHome(){
        homeLink.click();
    }
}
