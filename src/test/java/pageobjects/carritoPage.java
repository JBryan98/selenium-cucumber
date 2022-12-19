package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class carritoPage extends util {
    @FindBy(name = "quantity")
    protected WebElement cboxQuantity;

    @FindBy(xpath = "//input[@value='Buy Now']")
    protected WebElement btnBuyNow;

    public carritoPage(){
        PageFactory.initElements(driver, this);
    }

    public void seleccionarCantidad(String cantidad){
        wait.until(ExpectedConditions.visibilityOf(cboxQuantity));
        new Select(cboxQuantity).selectByVisibleText(cantidad);
        //selectByValue
        //selectByIndex
    }

    public void clickComprar(){
        wait.until(ExpectedConditions.elementToBeClickable(btnBuyNow));
        btnBuyNow.click();
    }
}
