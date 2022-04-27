package tqs.lab4_1.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class FormPage extends BasePage {

    @FindBy(id = "inputName")
    WebElement inputName;
    @FindBy(id = "address")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "zipCode")
    WebElement zipCode;
    @FindBy(id = "creditCardNumber")
    WebElement creditCardNumber;
    @FindBy(id = "nameOnCard")
    WebElement nameOnCard;
    @FindBy(id = "rememberMe")
    WebElement rememberMeBtn;
    @FindBy(xpath= "//input[@value='Purchase Flight']")
    WebElement confirmPurchaceBtn;

    public FormPage(WebDriver driver, int timeoutSec) { 
        this(driver);
        setTimeoutSec(timeoutSec);
    }

    public FormPage(WebDriver driver) { 
        super(driver);
        visit("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    public void fillInputName( String inputName ) {
        type(this.inputName, inputName);
    }
    
    public void fillAddress( String address ) {
        type(this.address, address);

    }
    
    public void fillCity( String city ) {
        type(this.city, city);
    }
    
    public void fillState( String state ) {
        type(this.state, state);

    }
    
    public void fillZipCode( String zipCode ) {
        type(this.zipCode, zipCode);
    }
    
    public void fillCreditCardNumber( String creditCardNumber ) {
        type(this.creditCardNumber, creditCardNumber);
    }
    
    public void fillNameOnCard( String nameOnCard ) {
        type(this.nameOnCard, nameOnCard);
    }

    
    public void setRememberMeBtn(){
        rememberMeBtn.click();
    }
    public void getConfirmPurchaceBtn() {
        click(confirmPurchaceBtn);
    }

    public WebElement getInputName() {
        return inputName;
    }
    
    public WebElement getAddress() {
        return address;
    }
    
    public WebElement getCity() {
        return city;
    }
    
    public WebElement getState() {
        return state;
    }
    
    public WebElement getZipCode() {
        return zipCode;
    }
    
    public WebElement getCreditCardNumber() {
        return creditCardNumber;
    }
    
    public WebElement getNameOnCard() {
        return nameOnCard;
    }
    
    public WebElement getRememberMeBtn() {
        return rememberMeBtn;
    }
    
    public String getText(WebElement e){
        return e.getAttribute( "value" );
    }



}
