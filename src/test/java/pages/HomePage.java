package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;

    private By logoutButton = By.id("logout");
    private By addContactButton = By.id("add-contact");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isLogoutVisible() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void clickAddCountact(){
        driver.findElement(addContactButton).click();
    }


}
