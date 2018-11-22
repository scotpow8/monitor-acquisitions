package starter.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.sf.cglib.core.Local;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;

@Slf4j
public class PersonalDetailsPage extends PageObject {

    @FindBy(id = "title")
    WebElementFacade title;

    @FindBy(id = "firstName")
    WebElementFacade firstName;

    @FindBy(id = "surname")
    WebElementFacade surname;

    @FindBy(id = "telNumber")
    WebElementFacade telNumber;

    @FindBy(id = "email")
    WebElementFacade email;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[6]/div/div/div[2]/div/span[1]")
    WebElementFacade smartMeterYes;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[6]/div/div/div[2]/div/span[2]")
    WebElementFacade smartMeterNo;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[7]/div/div[1]")
    WebElementFacade marketingConsentsEmail;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[7]/div/div[2]")
    WebElementFacade marketingConsentsLetter;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[7]/div/div[3]")
    WebElementFacade marketingConsentsSms;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[7]/div/div[4]")
    WebElementFacade marketingConsentsPhone;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/div/div/div[4]/form/div[2]/div[3]/div/div[2]/div[1]/div/div/input")
    WebElementFacade dob;

    @FindBy(xpath = "//button[text() = 'Continue']")
    WebElement continueButton;


    public void clickContinue() {
        continueButton.click();
    }

    public void setDob(int dayOfMonth, Month month, int year) {
        final LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        final String format = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate);

        dob.typeAndTab(format);
    }


    public void setTitle(String title) {
        this.title.selectByVisibleText(title);
    }

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setSurname(String surname) {
        this.surname.sendKeys(surname);
    }

    public void setTelNumber(String telNumber) {
        this.telNumber.sendKeys(telNumber);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setSmartMeterYes() {
        this.smartMeterYes.setWindowFocus();
//        this.smartMeterYes.sendKeys(" ");
        this.smartMeterYes.click();
    }

    public void setSmartMeterNo() {
        this.smartMeterNo.click();
    }

    public void clickMarketingConsentsEmail() {
        new Actions(getDriver()).moveToElement(marketingConsentsEmail);
        this.marketingConsentsEmail.click();
    }

    public void clickMarketingConsentsLetter() {
        this.marketingConsentsLetter.click();
    }

    public void clickMarketingConsentsSms() {
        this.marketingConsentsSms.click();
    }

    public void clickMarketingConsentsPhone() {
        this.marketingConsentsPhone.click();
    }
}
