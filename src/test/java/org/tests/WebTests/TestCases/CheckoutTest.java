package org.tests.WebTests.TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.tests.Utils.TestData;
import org.tests.WebTests.WebPages.CartPage;
import org.tests.WebTests.WebPages.CheckoutPage;
import org.tests.WebTests.WebPages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.tests.WebTests.WebPages.RegistrationPage;

public class CheckoutTest {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    RegistrationPage registrationPage;
    String userEmail , userPassword;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver (make sure you have the correct path to chromedriver)
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicesoftwaretesting.com/");

        // Initialize Page Objects
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        registrationPage = new RegistrationPage(driver);


    }

    @Test(dataProvider = "registrationData", dataProviderClass = TestData.class , priority =0 )
    public void testUserRegistration(String firstName, String lastName, String email, String password, String dob,
                                     String address, String postcode, String city, String state, String country, String phone){
        //save user and password
        userEmail = email;
        userPassword = password;
        // Navigate to registration page
        registrationPage.goToRegister();

        // Fill the form with test data
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.setDateOfBirth(dob);
        registrationPage.enterAddress(address);
        registrationPage.enterPostcode(postcode);
        registrationPage.enterCity(city);
        registrationPage.enterState(state);
        registrationPage.selectCountryByValue(country); // Dynamic country selection
        registrationPage.enterPhone(phone);

        // Submit the form
        registrationPage.clickRegister();

//        // login
//        cartPage.LogIn(email, password);
        registrationPage.clickHome();

    }

    @Test(dataProvider = "checkoutData" , priority =1)
    public void testCheckoutProcess(String email, String password, String paymentMethod) {
        // Add product to cart
        productPage.addProductToCart();

        // Go to the cart and proceed to checkout
        cartPage.goToCheckout(email,password);

        // Enter shipping and billing information
        checkoutPage.selectPaymentMethodfromList(paymentMethod);
        // Complete the order
        checkoutPage.completeOrder();

    }

    @DataProvider
    public Object[][] checkoutData() {
        return new Object[][] {
                // her to pass user email , password and payment method to be used
                // can replace the data here to read it from a file
                { userEmail , userPassword , "cash-on-delivery"}
        };
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}

