package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class RegisterUITest extends BaseTest {

    RegisterPage RP;
    @BeforeMethod
    public void setupPage(){
        RP = new RegisterPage(driver);
        RP.openRegisterPage();
    }



    @Test(description = "Regester with valid information")
    public void validRegester() throws InterruptedException {
        String randomEmail = "mohammad" + System.currentTimeMillis() + "@gmail.com";

        RP.registerNewUser("mohammad", "Alawnah230", randomEmail, "mohammad123");

        Thread.sleep(2000);
        boolean success = RP.isRegistrationSuccessful();
        Assert.assertTrue(success);
    }



    @Test(description = "Regester with Wrong Email Format")
    public void WrongEmailRegester() throws InterruptedException{
        RP.registerNewUser("FirstName", "Last", "invalidemail@", "1234510259");
        Thread.sleep(1000);

        Assert.assertTrue(RP.isInvalidEmailErrorMessageDisapled());
    }

    @Test(description = "Regester with Invalid password")
    public void InvalidPassword()throws InterruptedException{
        RP.registerNewUser("FirstName", "Last", "valid@gmail.com", "123");
        Thread.sleep(1000);
        Assert.assertTrue(RP.isInvalidPasswordWrongDisapled());
    }

    @Test(description = "Regester with Invalid Email And password")
    public void InvalidEmailAndPassword() throws InterruptedException{
        RP.registerNewUser("FirstName", "Last", "valid@", "123");
        Thread.sleep(1000);
        Assert.assertTrue(RP.isInvalidPasswordWrongDisapled() && RP.isInvalidEmailErrorMessageDisapled());








    }

    @Test(description = "Regester with Empty Data")
    public void emptyDataRegister() throws InterruptedException{
        RP.registerNewUser("","","","");
        Thread.sleep(1000);
        Assert.assertTrue(RP.isFirstNameFieldRequiredErrorMessageDisapled() && RP.isLastNameFieldRequiredErrorMessageDisapled()&& RP.isInvalidEmailErrorMessageDisapled() &&RP.isPasswordFieldRequiredErrorMessageDisapled());
    }






}
