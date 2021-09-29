package io.pragra.shipcarte.test;

import io.pragra.shipcarte.data.ExcelData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.pragra.shipcarte.pages.LoginPage;

import java.io.IOException;

public class LoginPageTest extends Base {


    LoginPage loginPage;
    ExcelData excelData = new ExcelData();

    @BeforeTest
    public void setup() throws IOException {
        driver = initializeDriver();
        driver.get("http://shipcarte.pragralms.com:3000/#/signin");
        loginPage = new LoginPage(driver);

    }

    @Test
    public void positiveTestCase(){

        loginPage.selectCustomer();
        loginPage.username("harshitha.keshav19@gmail.com");
        loginPage.password("Pragra1234$");
        loginPage.showPassword();
        loginPage.rememberMe();
        loginPage.continueButton();
    }

    @Test
    public void negativeTestCase(){

    }

   @DataProvider(name = "Login")
   public Object[][] getData(){

       return new Object[0][];
   }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();

    }



}
