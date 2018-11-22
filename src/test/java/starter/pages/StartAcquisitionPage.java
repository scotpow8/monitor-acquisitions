package starter.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Optional;

@Slf4j
@DefaultUrl("https://www.scottishpower.co.uk/energyquote.process?execution=e1s1")
public class StartAcquisitionPage extends PageObject {

    @FindBy(id = "postcode")
    WebElement search;

    @FindBy(id = "address")
    WebElement address;

    @FindBy(xpath = "//form[@id='getAQuote']/div/a")
    WebElement submitButton;

    public void submit() {
        submitButton.click();
    }

    public void searchFor(String keywords) {
        search.sendKeys(keywords, Keys.ENTER);
        log.debug("Waiting for address dropdown to become enabled");
//        waitForAbsenceOf("//*[@disabled]");
        log.debug("Address dropdown enabled");
    }

    public void selectAddress(String fullAddress) {
        List<WebElement> elements = address.findElements(By.xpath("//option"));
        final Optional<WebElement> first = elements.stream().filter(x -> fullAddress.equals(x.getText())).findFirst();
        if (first.isPresent()) {
            first.get().click();
        } else {
            Assertions.fail("Failed to find address: " + fullAddress);
        }
    }

    public void assertAddressAvailable(String fullAddress) {
        List<WebElement> elements = address.findElements(By.xpath("//option"));
        log.error("Found optional elements : {} ", elements.size());

        waitFor(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//option"), 1));

        elements = address.findElements(By.xpath("//option"));
        log.error("Found optional elements : {} ", elements.size());

        Assertions.assertThat(
                elements.stream().anyMatch(x -> fullAddress.equals(x.getText()))
        ).isTrue();
    }
}
