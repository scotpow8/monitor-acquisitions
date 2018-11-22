package starter.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

@Slf4j
//@DefaultUrl("https://quote.scottishpower.co.uk/#/acquisitions")
public class StartAcquisitionPage extends PageObject {

    @FindBy(id = "postcode")
    WebElement postcodeField;

    @FindBy(id = "address")
    WebElement addressList;

    @FindBy(xpath = "//button[text() = 'Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[text() = 'Close']")
    WebElement cookiePanelcloseButton;

    public void submitSelectedAddress() {
        continueButton.click();
    }

    public void searchFor(String keywords) {
        postcodeField.sendKeys(keywords, Keys.ENTER);
    }

    public void selectAddress(String fullAddress) {
        List<WebElement> elements = addressList.findElements(By.xpath("//option"));
        final Optional<WebElement> first = elements.stream().filter(x -> fullAddress.equals(x.getText())).findFirst();
        if (first.isPresent()) {
            first.get().click();
        } else {
            Assertions.fail("Failed to find address: " + fullAddress);
        }
    }

    public void assertAddressAvailable(String fullAddress) {
        List<WebElement> elements = addressList.findElements(By.xpath("//option"));
        log.error("Found optional elements : {} ", elements.size());

        waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//option"), 1));

        elements = addressList.findElements(By.xpath("//option"));
        log.error("Found optional elements : {} ", elements.size());

        Assertions.assertThat(
                elements.stream().anyMatch(x -> fullAddress.equals(x.getText()))
        ).isTrue();
    }

    public void clickCloseOnCookiePanel() {
        cookiePanelcloseButton.click();
    }
}
