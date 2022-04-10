package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SignInPage;
import automation.utils.ConfigurationProperties;
import automation.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutPage checkoutPage;

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects(){
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
    }

    @Given("^I go to the Website")
    public void i_go_to_the_Website(){
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @When("^I click on Sign In button")
    public void i_click_on_sign_in_button(){
        homePage.clickSignIn();
    }

    @When("^I add two elements to the cart")
    public void i_add_two_elements_to_the_cart() {
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
    }

    @And("^I specify my credentials and click Login")
    public void i_specify_my_credentials_and_click_login(){
        signInPage.logIn(configurationProperties.getEmail(), configurationProperties.getPassword());
    }

    @And("^I proceed to checkout")
    public void i_proceed_to_checkout(){
        checkoutPage.goToCheckout();
    }

    @And("^I confirm address, shipping, payment and final order")
    public void i_confirm_address_shipping_payment_and_final_order(){
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
    }

    @Then("^I can log into the website")
    public void i_can_log_into_the_website(){
        assertEquals(configurationProperties.getUsername(), homePage.getUserName());
    }

    @Then("^The elements are bought")
    public void the_elements_are_bought(){
        assertTrue(checkoutPage.checkFinalStatus());
    }
}
