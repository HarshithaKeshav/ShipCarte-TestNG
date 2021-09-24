package pragra.shipcarte.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pragra.shipcarte.base.Base;

public class LoginPage {

    @FindBy(xpath = "//div[@class='mt-3']/span")
    WebElement select_customer;

    @FindBy(xpath = "//div[@class='mt-3']/span[2]")
    WebElement select_partner;

    @FindBy(xpath = "//*[@name='username']")
    WebElement text_username;

    @FindBy(xpath = "//*[@name='password']")
    WebElement text_password;

    @FindBy(xpath = "//*[@name='password']/following-sibling::div/span")
    WebElement click_showPassword;

    @FindBy(id = "gridCheck")
    WebElement checkBox_rememberMe;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement button_continue;

    @FindBy(xpath = "//button[@type='button']")
    WebElement button_loginWithGoogle;

    @FindBy(xpath = "//button[@type='button']/following-sibling::a")
    WebElement button_forgotPassword;



    public void selectCustomer(){
        select_customer.click();
    }

    public void selectPartner(){
        select_partner.click();
    }

    public void username(String text){
        text_username.sendKeys();
    }

    public void password(String text){
        text_password.sendKeys();
    }

    public void showPassword(){
        click_showPassword.click();
    }

    public void rememberMe(){
        checkBox_rememberMe.click();
    }

    public void continueButton(){
        button_continue.click();
    }

    public void loginWithGoogle(){
        button_loginWithGoogle.click();
    }

    public void forgotPassword(){
        button_forgotPassword.click();
    }


}
