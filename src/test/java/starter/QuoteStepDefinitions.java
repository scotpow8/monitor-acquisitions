package starter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.pages.PropertyConsumptionPage;
import starter.pages.QuotePage;

@Slf4j
public class QuoteStepDefinitions {

    @Managed(driver="chrome")
    WebDriver driver;

    QuotePage quotePage;

    @When("I select 1 Year tariff")
    public void submit() throws Throwable {
        quotePage.submit();
    }

    @When("I click Continue on popup")
    public void I_click_Continue_on_popup() throws Throwable {
        quotePage.clickContinueOnPopup();
    }

}
