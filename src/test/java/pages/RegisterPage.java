package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    private WebDriver driver;

    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By submitButton = By.id("submit");
    private By signUpLink = By.id("signup");

    private By errorMessage = By.id("error");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void openRegisterPage(){
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        driver.findElement(signUpLink).click();
    }

    public void registerNewUser(String firstName, String LastName, String email, String password){
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(LastName);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.submitButton).click();
    }
    public boolean isRegistrationSuccessful() {

        System.out.println("area 1 ");

        String expectedTitle = "My Contacts";

        System.out.println("Title : "+ driver.getTitle());

        if (!driver.getTitle().equals(expectedTitle)) {
            System.out.println("area 2 ");
            return false;
        }

        System.out.println("area  3");

        boolean add_contact = driver.findElement(By.id("add-contact")).isDisplayed();
        System.out.println("welcomeText : "+ add_contact);

        if(!add_contact){
            return false;
        }

        return true;
    }

    public boolean isInvalidEmailErrorMessageDisapled(){
        if(!driver.findElement(errorMessage).isDisplayed()){
            return false;
        }
        else{
            if (driver.findElement(errorMessage).getText().contains("Email is invalid")){
                return true;
            }
            return false;

        }
    }

    public boolean isInvalidPasswordWrongDisapled(){
        if(!driver.findElement(errorMessage).isDisplayed()){
            return false;
        }
        else{
            if (driver.findElement(errorMessage).getText().contains("is shorter than the minimum allowed length (7)")){
                return true;
            }
            return false;

        }


    }

    public boolean isFirstNameFieldRequiredErrorMessageDisapled(){
        if(!driver.findElement(errorMessage).isDisplayed()){
            return false;
        }
        else{
            if (driver.findElement(errorMessage).getText().contains("`firstName` is required")){
                return true;
            }
            return false;
        }

    }

    public boolean isLastNameFieldRequiredErrorMessageDisapled(){
        if(!driver.findElement(errorMessage).isDisplayed()){
            return false;
        }
        else{
            if (driver.findElement(errorMessage).getText().contains("`lastName` is required")){
                return true;
            }
            return false;
        }

    }

    public boolean isPasswordFieldRequiredErrorMessageDisapled(){
        if(!driver.findElement(errorMessage).isDisplayed()){
            return false;
        }
        else{
            if (driver.findElement(errorMessage).getText().contains("`password` is required")){
                return true;
            }
            return false;
        }

    }

}