package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddContactPage;
import pages.HomePage;
import pages.LoginPage;

public class ContactUITest extends BaseTest {

    @Test()
    public void addNewContactFullDataTest() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.open();
        Thread.sleep(2000);
        login.login("malaw@gmail.com", "mohammad123");

        Thread.sleep(2000);

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isLogoutVisible());

        home.clickAddCountact();

        AddContactPage add = new AddContactPage(driver);
        Assert.assertTrue(add.isAtAddContactPage());

        add.fillContactForm(
                "Ali", "Ahmad", "1995-06-10",
                "ali.ahmad@gmail.com", "0597956626",
                "Main St 123", "Building 5", "Nablus",
                "West Bank", "00970", "Palestine"
        );
        Thread.sleep(2000);

        add.submitContact();

        Thread.sleep(2000);

        Assert.assertTrue(add.isLogoutVisible());
        Thread.sleep(2000);

    }


}
