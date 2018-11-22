package starter.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

public class BankDetailsPage extends PageObject {

    @FindBy(id = "accountHolderName")
    WebElementFacade accountHolderName;

    @FindBy(id = "accountNumber")
    WebElementFacade accountNumber;

    @FindBy(id = "sortCode")
    WebElementFacade sortCode;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[1]/div[2]/div[2]/div/div[2]")
    WebElementFacade tsAndCs;

    @FindBy(xpath = "//button[text() = 'Join ScottishPower']")
    WebElementFacade joinSpButton;

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName.type(accountHolderName);
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber.type(accountNumber);
    }

    public void setSortCode(String sortCode) {
        this.sortCode.type(sortCode);
    }

    public void setTsAndCs() {
        this.tsAndCs.click();
    }

    public void setJoinSpButton() {
        this.joinSpButton.click();
    }

}
