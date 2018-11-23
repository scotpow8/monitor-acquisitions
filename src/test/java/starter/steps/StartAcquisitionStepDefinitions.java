package starter.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.pages.StartAcquisitionPage;

public class StartAcquisitionStepDefinitions {

    @Managed(driver="chrome")
    WebDriver driver;

    StartAcquisitionPage startAcquisitionPage;

    @Given("^I start acquisitions$")
    public void I_start_acquisitions() throws Throwable {
        startAcquisitionPage.open();
    }

    @When("I enter postcode '(.*)'")
    public void I_enter_postcode(String postcode) throws Throwable {
        startAcquisitionPage.searchFor(postcode);
    }

    @Then("I must see my address '(.*)'")
    public void I_must_see_my_address(String fullAddress) throws Throwable {
        startAcquisitionPage.assertAddressAvailable(fullAddress);
    }

    @When("I select address '(.*)'")
    public void I_select_address(String fullAddress) throws Throwable {
        startAcquisitionPage.selectAddress(fullAddress);
    }

    @When("I submit address")
    public void I_submit_address() throws Throwable {
        startAcquisitionPage.submitSelectedAddress();
    }

    @When("I close the cookie panel")
    public void I_close_the_cookie_panel() throws Throwable {
        startAcquisitionPage.clickCloseOnCookiePanel();
    }

}
