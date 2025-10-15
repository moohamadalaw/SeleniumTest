package pages;
import org.openqa.selenium.*;
import org.testng.Assert;

public class LoginPage {
    private WebDriver driver;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submit");

    private By error = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }


    public void login(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginButtonDisaplayed(){
        return driver.findElement(loginButton).isDisplayed();
    }

    public boolean isErrorMessageDisapled(){
        if(driver.findElement(error).isDisplayed())
            return true;

        return false;
    }

    public boolean isLoginSuccsess() {

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

}
