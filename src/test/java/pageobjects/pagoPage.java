package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import support.util;

public class pagoPage extends util {
    @FindBy(id = "card_nmuber") protected WebElement inputTarjeta;
    @FindBy(id = "month") protected WebElement cboxMonth;
    @FindBy(id = "year") protected WebElement cboxYear;
    @FindBy(id = "cvv_code") protected WebElement inputCvv;
    @FindBy(name = "submit") protected WebElement btnPay;

    public pagoPage() {
        PageFactory.initElements(driver, this);
    }

    public void escribirNroTarjeta(String cardNumber){
        wait.until(ExpectedConditions.visibilityOf(inputTarjeta));
        inputTarjeta.sendKeys(cardNumber);
    }

    public void seleccionarMes(String month){
        new Select(cboxMonth).selectByVisibleText(month);
    }

    public void seleccionarYear(String year){
        new Select(cboxYear).selectByVisibleText(year);
    }

    public void escribirCvv(String cvv){
        inputCvv.sendKeys(cvv);
    }

    public void clickPagar(){
        btnPay.click();
    }
}
