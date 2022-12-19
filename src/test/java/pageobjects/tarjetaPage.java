package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

public class tarjetaPage extends util {
    public static String nroTarjeta;
    public static String cvv;
    public static String mes;
    public static String year;
    public static String creditLimit;
    //Nota: Selenium solo soporta datos de entrada de tipo String.

    @FindBy(xpath = "//*[contains(text(),'Card Number:')]") protected WebElement labelNroTarjeta;
    @FindBy(xpath = "//*[contains(text(),'CVV')]") protected WebElement labelCvv;
    @FindBy(xpath = "//*[contains(text(),'Exp')]") protected WebElement labelExp;
    @FindBy(xpath = "//*[contains(text(),'Credit Limit')]") protected WebElement labelCreditLimit;

    public tarjetaPage(){
        PageFactory.initElements(driver, this);
    }

    public void obtenerNroTarjeta(){
        wait.until(ExpectedConditions.visibilityOf(labelNroTarjeta));
        String labelTxt = labelNroTarjeta.getText();
        System.out.println(labelTxt);
        nroTarjeta = labelTxt.replace("Card Number: - ", "");
    }

    public void obtenerCvv(){
        wait.until(ExpectedConditions.visibilityOf(labelCvv));
        String labelTxt = labelCvv.getText();
        System.out.println(labelTxt);
        cvv = labelTxt.replace("CVV:- ", "");
    }

    public void obtenerExp(){
        wait.until(ExpectedConditions.visibilityOf(labelExp));
        String labelTxt = labelExp.getText();
        System.out.println(labelTxt);
        String fecha[] = labelTxt.replace("Exp:- ", "").split("/");
        mes = fecha[0];
        year = fecha[1];
    }

    public void obtenerCreditLimit(){
        wait.until(ExpectedConditions.visibilityOf(labelCreditLimit));
        String labelTxt = labelCreditLimit.getText();
        System.out.println(labelTxt);
        creditLimit = labelTxt.replace("Credit Limit $", "");
    }
}
