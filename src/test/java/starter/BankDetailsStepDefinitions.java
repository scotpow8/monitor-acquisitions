package starter;

import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import starter.pages.BankDetailsPage;

@Slf4j
public class BankDetailsStepDefinitions {

    @Managed(driver="chrome")
    WebDriver driver;

    BankDetailsPage bankDetailsPage;

    @When("I enter bank account holder (.*)")
    public void I_enter_bank_account_holder(String name) {
        bankDetailsPage.setAccountHolderName(name);
    }

    @When("I enter bank account number (.*)")
    public void I_enter_bank_account_number(String accNo) {
        bankDetailsPage.setAccountNumber(accNo);
    }

    @When("I enter sort code (.*)")
    public void I_enter_sort_code(String sortCode) {
        bankDetailsPage.setSortCode(sortCode);
    }

    @When("I check Ts and Cs")
    public void I_check_Ts_and_Cs() {
        bankDetailsPage.setTsAndCs();
    }

    @When("I submit bank details")
    public void I_submit_bank_details() {
        log.warn("ready to submit to SAP");
//        bankDetailsPage.setJoinSpButton();
    }
}
