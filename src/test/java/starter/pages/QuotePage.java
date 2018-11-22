package starter.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;

@Slf4j
public class QuotePage extends PageObject {

    @FindBy(xpath = "//button[text() = 'Continue with this tariff']")
    WebElementFacade continueWithTariffButton;

    @FindBy(xpath = "//button[text() = 'Continue']")
    WebElementFacade continueOnPopupButton;

    public void submit() {
        continueWithTariffButton.click();
    }

    public void clickContinueOnPopup() {
        continueOnPopupButton.click();
    }


}
