package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SignInPage;
import automation.utils.ConfigurationProperties;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {
    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutPage checkoutPage;

//    we need to access configurationProperties in order to access the variables from there
    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializedObjects(){
        DriverSingleton.getInstance(configurationProperties.getBrowser());
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
    }

//    we define the actions that we defined in SignIn.feature file

    @Given("^I go to the Website")
    public void i_go_to_the_Website(){
        ConfigurationProperties frameworkProperties = new ConfigurationProperties();
        DriverSingleton.getInstance(frameworkProperties.getBrowser());
        WebDriver driver = DriverSingleton.getDriver();
        driver.get("http://automationpractice.com");
    }

    @When("^I click on Sign in button")
    public void i_click_on_Sing_in_button(){
        homePage.clickSignIn();
    }

    @When("^I add two elements to the cart")
    public void i_add_two_elements_to_the_cart(){
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
    }

    @And("^I specify my credentials and click Login")
    public void i_specify_my_credentials_and_click_Login(){
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
        assertEquals(configurationProperties.getUsername(), homePage.getUsername());
    }
    @Then("^The elements are bought")
    public void the_elements_are_bought(){
        assertTrue(checkoutPage.checkFinalStatus());
    }

}
