package pragra.shipcarte;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pragra.shipcarte.base.Base;
import pragra.shipcarte.pages.LoginPage;

import java.io.IOException;

public class TestBase extends Base {


    LoginPage loginPage;

    @BeforeTest
    public void setup() throws IOException {
        driver = initializeDriver();
        driver.get("http://shipcarte.pragralms.com:3000/#/signin");
        loginPage = new LoginPage();

    }

    @org.testng.annotations.Test
    public void loginPageTest(){
        loginPage.selectCustomer();
        loginPage.username("harshitha.keshav19@gmail.com");
        loginPage.password("Pragra1234$");
        loginPage.showPassword();
        loginPage.rememberMe();
        loginPage.continueButton();
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }



}
