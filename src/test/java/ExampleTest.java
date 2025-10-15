//import org.testng.annotations.*;
//
//public class ExampleTest {
//    @BeforeClass
//    public void setup(){
//        System.out.println("open browser\n");
//    }
//
//    @BeforeMethod
//    public void beforEach(){
//        System.out.println("open new page\n");
//    }
//
//    @Test
//    public void testLogin(){
//        System.out.println("Login\n");
//    }
//
//    @Test(description = "This is the log out\n")
//    public void testLogout(){
//        System.out.println("Logout\n");
//    }
//
//    @DataProvider(name = "loginData")
//    public Object[][] provideData() {
//        return new Object[][] {
//                {"mohammad", "mohammad123"},
//                {"wrongUser", "wrongPass"}
//        };
//    }
//
//    @Test(dataProvider = "loginData")
//    public void testLogin(String username, String password) {
//        System.out.println("Test Login : " + username + " / " + password);
//    }
//
//    @AfterMethod
//    public void afterEach(){
//        System.out.println("clean the page\n");
//    }
//
//    @AfterClass
//    public void destruction(){
//        System.out.println("close the browser\n\n");
//    }
//
//
//
//}


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import org.testng.annotations.*;
public class ExampleTest {
   // WebDriver driver;
    @Test
    @Parameters({"author", "searchKey"})
    public void testParameterWithXML(@Optional("Abc") String author, String searchKey) throws InterruptedException {
        driver = new FirefoxDriver();

        driver.get("https://google.com");

        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);

        System.out.println("Welcome -> " + author + " | Your search key is -> " + searchKey);
        System.out.println("Thread will sleep now...");
        Thread.sleep(3000);

        System.out.println("Value in Google Search Box = "
                + searchText.getAttribute("value")
                + " ::: Value given by input = " + searchKey);

        Assert.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
        driver.quit();
    }

//    @DataProvider(name="searchData")
//    public Object[][] getData() {
//        return new Object[][] { {"Google", "Selenium"}, {"Bing", "Java"} };
//    }



    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
    }

    @DataProvider(name = "SearchProvider")
    public Object[][]getData(){
        return new Object[][]{
                { "Mohammad", "India" },
                { "Ali", "UK" },
                { "Sara", "USA" }
        };
    }


    @Test(dataProvider = "SearchProvider")
    public void testMethod(String author, String searchKey) throws InterruptedException {
        WebElement searchText = driver.findElement(By.name("q"));
        searchText.sendKeys(searchKey);

        System.out.println("Welcome -> " + author + " Your search key is -> " + searchKey);
        Thread.sleep(3000);

        String testValue = searchText.getAttribute("value");
        System.out.println("Value in Google Search Box = " + testValue + " ::: " + searchKey);
        searchText.clear();

        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));

    }
}

