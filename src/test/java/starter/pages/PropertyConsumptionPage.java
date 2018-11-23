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

@Slf4j
public class PropertyConsumptionPage extends PageObject {

    @FindBy(id = "bedrooms")
    WebElementFacade bedrooms;

    @FindBy(id = "people")
    WebElementFacade people;

    @FindBy(id = "propertyType")
    WebElementFacade propertyType;

    @FindBy(xpath = "//button[text() = 'Generate quote']")
    WebElement submitButton;

    public void submit() {
        submitButton.click();
    }

    public void inputBedrooms(int number) {
        bedrooms.selectByVisibleText("" + number);
    }

    public void inputPeople(int number) {
        people.selectByVisibleText("" + number);
    }

    public void inputPropertyType(String propertyType) {
        this.propertyType.selectByVisibleText(propertyType);
    }


}
