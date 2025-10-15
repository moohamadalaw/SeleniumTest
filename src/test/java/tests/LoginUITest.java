package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class LoginUITest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setupPage(){
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @Test()
    public void verifyLoginPageLoads() {
        Assert.assertTrue(loginPage.isLoginButtonDisaplayed());
    }

    @Test(description = "verefy user can Login successfully with valid information")
    public void verifyValidLogin() throws InterruptedException{

        loginPage.enterEmail("malaw@gmail.com");
        loginPage.enterPassword("mohammad123");
        loginPage.clickLoginButton();
        Thread.sleep(1000);
        Assert.assertTrue(loginPage.isLoginSuccsess());


//        HomePage Home = new HomePage(driver);


    }


    @Test(description = "verify user can't login with Wrong password login ")
    public void VerifyWrongPassword() throws InterruptedException{
        loginPage.enterEmail("malaw@gmail.com");
        loginPage.enterPassword("123");
        loginPage.clickLoginButton();
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.isLoginSuccsess());
    }

    @Test(description = "verify user can't login with wrong email")
    public void VerifyWrongEmail() throws InterruptedException{
        loginPage.enterEmail("malaw@");
        loginPage.enterPassword("mohammad123");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.isLoginSuccsess());
    }

    @Test(description = "verify user can't login with Empty Email and Password")
    public void VerifyLoginWithEmptyData() throws InterruptedException{
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.isLoginSuccsess());
    }

    @Test(description = "verify user can't login with Empty Password")
    public void VerifyLoginWithEmptyPaswword() throws InterruptedException{
        loginPage.enterEmail("malaw@gmail.com");
        loginPage.enterPassword("");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.isLoginSuccsess());
    }

    @Test(description = "verify user can't login with Empty Email")
    public void VerifyLoginWithEmptyEmail() throws InterruptedException{
        loginPage.enterEmail("");
        loginPage.enterPassword("mohammad123");
        Thread.sleep(1000);
        Assert.assertFalse(loginPage.isLoginSuccsess());
    }






}
