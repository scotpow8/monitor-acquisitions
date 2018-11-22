package starter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.pages.StartAcquisitionPage;

@Slf4j
public class StartAcquisitionStepDefinitions {

    @Managed(driver="chrome")
    WebDriver driver;

    StartAcquisitionPage startAcquisitionPage;

    @Given("^I start acquisitions$")
    public void I_start_acquisitions() throws Throwable {
        log.error("I_start_acquisitions");
//        driver.get("http://www.google.com");
        startAcquisitionPage.open();
    }

    @When("I enter postcode '(.*)'")
    public void I_enter_postcode(String postcode) throws Throwable {
        log.error("I_enter_postcode {}", postcode);
        startAcquisitionPage.searchFor(postcode);
    }

    @Then("I must see my address '(.*)'")
    public void I_must_see_my_address(String fullAddress) throws Throwable {
        log.error("I_must_see_my_address {}", fullAddress);
        startAcquisitionPage.assertAddressAvailable(fullAddress);
    }

    @Then("I select address '(.*)'")
    public void I_select_address(String fullAddress) throws Throwable {
        log.error("I_select_address {}", fullAddress);
        startAcquisitionPage.selectAddress(fullAddress);
    }

    @Then("I submit address")
    public void I_submit_address() throws Throwable {
        startAcquisitionPage.submit();
    }

}
