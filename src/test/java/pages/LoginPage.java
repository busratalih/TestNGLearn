package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name="accept")
    private WebElement cookieAccept;

    @FindBy(css="#nav-link-accountList")
    private WebElement loginButton;

    @FindBy(css=".nav-action-inner")
    private WebElement joinButton;

    @FindBy(css="#ap_email")
    private WebElement mailInput;


    @FindBy(css="#ap_password")
    private WebElement passwordInput;

    @FindBy(css="#twotabsearchtextbox")
    private WebElement searchBox;

    public void beLogin(){

        cookieAccept.click();
        ReusableMethods.hover(loginButton);
        //ReusableMethods.hover(joinButton);
        loginButton.click();

        mailInput.sendKeys(ConfigReader.getProperty("email")+ Keys.ENTER);
        passwordInput.sendKeys(ConfigReader.getProperty("password")+ Keys.ENTER);

       //if(cookieAccept.isDisplayed()){
       //    cookieAccept.click();
       //    ReusableMethods.hover(loginButton);
       //    //ReusableMethods.hover(joinButton);
       //    loginButton.click();

       //    mailInput.sendKeys(ConfigReader.getProperty("email")+ Keys.ENTER);
       //    passwordInput.sendKeys(ConfigReader.getProperty("password")+ Keys.ENTER);
       //}else {
       //    ReusableMethods.hover(loginButton);
       //    ReusableMethods.hover(joinButton);
       //    joinButton.click();

       //    mailInput.sendKeys(ConfigReader.getProperty("email")+ Keys.ENTER);
       //    passwordInput.sendKeys(ConfigReader.getProperty("password")+ Keys.ENTER);
       //}


    }





}
