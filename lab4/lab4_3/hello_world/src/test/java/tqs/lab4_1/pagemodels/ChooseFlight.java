package tqs.lab4_1.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ChooseFlight extends BasePage {

    @FindBy(css = "/html/body/div[2]/table/tbody/tr[3]/td[1]/input")
    WebElement chooseFlight; 


    @FindBy(xpath = "/html/body/div[2]/table/thead/tr[1]/th[4]")
    WebElement departs; 

    @FindBy(xpath = "/html/body/div[2]/table/thead/tr[1]/th[5]")
    WebElement arrives; 

    @FindBy(xpath = "/html/body/div[2]/table/tbody/tr[3]/td[6]")
    WebElement price; 

    public ChooseFlight(WebDriver driver, int timeoutSec) { 
        this(driver);
        setTimeoutSec(timeoutSec);
    }

    public ChooseFlight(WebDriver driver) { 
        super(driver);
    }

    public String getDepartCountry(){
      return departs.getText().replace("Departs: ","");
    }
    public String getArrivesCountry(){
      return arrives.getText().replace("Arrives: ","");
    }
    
    public String getFlightPrice(){
      return price.getText();
    }
      
    public void confirmFlight() {
      click(chooseFlight);
    }


}
