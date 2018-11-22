package starter.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@Slf4j
@DefaultUrl("https://www.scottishpower.co.uk/energyquote.process?execution=e4s1")
public class QuotePage extends PageObject {

    @FindBy(xpath = "//div[@id='1YF']/div/div/input[@type='submit']")
    WebElementFacade _1yfTariffSubmit;


    public void submit() {
        _1yfTariffSubmit.click();
    }


}
