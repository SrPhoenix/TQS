package tqs.lab4_1.pagemodels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LastPage extends BasePage{

    @FindBy(xpath = "/html/body/div[2]/div/pre") 
    WebElement e;
  
    public String getTexte(){
        return e.getText();
    }
    

    public LastPage(WebDriver driver) { 
        super(driver);
    }
}
