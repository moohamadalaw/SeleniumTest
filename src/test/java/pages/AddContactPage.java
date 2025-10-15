package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    private WebDriver driver;

    private By logoutBtn = By.id("logout");

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");


    private By birthDate = By.id("birthdate");

    private By email = By.id("email");
    private By phone = By.id("phone");


    private By stret1 = By.id("street1");

    private By stret2 = By.id("street2");

    private By city = By.id("city");
    private By state = By.id("stateProvince");


    private By postalCode = By.id("postalCode");
    private By country = By.id("country");


    private By submitBtn = By.id("submit");
    private By cancelBtn = By.id("cancel");


    public AddContactPage(WebDriver driver) {
        this.driver = driver;
    }


    public void fillContactForm(String FirstName, String Last, String dob,
                                String email, String phoneValue,
                                String st1, String st2, String city,
                                String state, String postal, String country) {

        driver.findElement(firstName).sendKeys(FirstName);
        driver.findElement(lastName).sendKeys(Last);
        driver.findElement(birthDate).sendKeys(dob);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(phone).sendKeys(phoneValue);
        driver.findElement(stret1).sendKeys(st1);
        driver.findElement(stret2).sendKeys(st2);
        driver.findElement(this.city).sendKeys(city);
        driver.findElement(this.state).sendKeys(state);
        driver.findElement(postalCode).sendKeys(postal);
        driver.findElement(this.country).sendKeys(country);
    }


    public void submitContact() {
        driver.findElement(submitBtn).click();
    }

    public void cancel() {
        driver.findElement(cancelBtn).click();
    }

    public boolean isAtAddContactPage() {
        return driver.getTitle().contains("Add Contact") ||
                driver.findElement(submitBtn).isDisplayed();
    }
    public boolean isLogoutVisible() {
        return driver.findElement(logoutBtn).isDisplayed();
    }
}
