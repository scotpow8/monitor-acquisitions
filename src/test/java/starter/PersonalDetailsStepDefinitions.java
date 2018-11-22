package starter;

import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Managed;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import starter.pages.PersonalDetailsPage;
import starter.pages.QuotePage;

import java.time.Month;

import static starter.PersonalDetailsStepDefinitions.YesNo.YES;

@Slf4j
public class PersonalDetailsStepDefinitions {

    enum YesNo {YES, NO};

    @Managed(driver="chrome")
    WebDriver driver;

    PersonalDetailsPage personalDetailsPage;

    @When("I enter dob (.*) (.*) (.*)")
    public void setDob(int dayOfMonth, String monthString, int year) {
        final Month month = Month.valueOf(StringUtils.upperCase(monthString));
        personalDetailsPage.setDob(dayOfMonth, month, year);
    }

    @When("I enter title (.*)")
    public void setTitle(String title) {
        personalDetailsPage.setTitle(title);
    }

    @When("I enter first name (.*)")
    public void setFirstName(String firstName) {
        personalDetailsPage.setFirstName(firstName);
    }

    @When("I enter surname (.*)")
    public void setSurname(String surname) {
        personalDetailsPage.setSurname(surname);
    }

    @When("I enter telephone number (.*)")
    public void setTelNumber(String telNumber) {
        personalDetailsPage.setTelNumber(telNumber);
    }

    @When("I enter email (.*)")
    public void setEmail(String email) {
        personalDetailsPage.setEmail(email);
    }


    @When("I enter smart meter (.*)")
    public void setEmail(YesNo haveSmartMeter) {
        if (YES == haveSmartMeter) {
            personalDetailsPage.setSmartMeterYes();
        } else {
            personalDetailsPage.setSmartMeterNo();
        }
    }


    @When("I enter marketing consent email (.*)")
    public void I_enter_marketing_consent_email(YesNo consent) {
        if (YES == consent) {
            personalDetailsPage.clickMarketingConsentsEmail();
        }
    }

    @When("I enter marketing consent letter (.*)")
    public void I_enter_marketing_consent_letter(YesNo consent) {
        if (YES == consent) {
            personalDetailsPage.clickMarketingConsentsLetter();
        }
    }

    @When("I enter marketing consent sms (.*)")
    public void I_enter_marketing_consent_sms(YesNo consent) {
        if (YES == consent) {
            personalDetailsPage.clickMarketingConsentsSms();
        }
    }

    @When("I enter marketing consent phone (.*)")
    public void I_enter_marketing_consent_phone(YesNo consent) {
        if (YES == consent) {
            personalDetailsPage.clickMarketingConsentsPhone();
        }
    }

    @When("I submit personal details")
    public void I_submit_personal_details() {
        personalDetailsPage.clickContinue();
    }

}
