package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.util;

/*Nota: Heredamos de la clase util y no de hooks, ya que util tiene la propiedad del tiempo (Wait)*/
public class menuPage extends util {
    /*LINK TEXT*/
    @FindBy(linkText = "Generate Card Number")
    protected WebElement linkGenerarTarjeta; /*Utilizamos protected porque al utilizar la variable, esta se pinta a diferencia de private*/

    /*CSS SELECTOR*/
    @FindBy(css = "#nav > a:nth-child(2)")
    protected WebElement linkGenerarTarjeta2;

    /*XPATH - relativo*/
    @FindBy(xpath = "//nav/a[@href='cardnumber.php']")
    protected WebElement linkGenerarTarjeta3;

    /*NOTA: LOS XPATH ABSOLUTOS INCLUYEN LA POSICION DEL OBJETO EN LA PAGINA*/

    /*Por cada clase que creamos, debemos crearle su constructor*/


    public menuPage() {
        /*Inicializa todos los elementos que hemos definido con FindBy (los objetos localizados)*/
        PageFactory.initElements(driver, this); //Con this referenciamos
    }

    public void clickGenerarTarjeta(){
        wait.until(ExpectedConditions.elementToBeClickable(linkGenerarTarjeta3));
        linkGenerarTarjeta3.click();
    }
}
