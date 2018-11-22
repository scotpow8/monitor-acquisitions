package starter;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.pages.PropertyConsumptionPage;

@Slf4j
public class PropertyConsumptionStepDefinitions {

    @Managed(driver="chrome")
    WebDriver driver;

    PropertyConsumptionPage propertyConsumptionPage;

    @When("I enter bedrooms (.*)")
    public void I_enter_bedrooms(int noOfBedrooms) throws Throwable {
        propertyConsumptionPage.inputBedrooms(noOfBedrooms);
    }

    @Then("I enter people (.*)")
    public void I_enter_people(int noOfPeople) throws Throwable {
        propertyConsumptionPage.inputPeople(noOfPeople);
    }

    @Then("I enter property type (.*)")
    public void I_enter_property_type(String propertyType) throws Throwable {
        propertyConsumptionPage.inputPropertyType(propertyType);
    }

    @Then("I submit property consumption")
    public void submit() throws Throwable {
        propertyConsumptionPage.submit();
    }

}
