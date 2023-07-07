package support;

import definitions.Hooks;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class Util extends Hooks {
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public Util() {
        /*Timer de espera para que cargue toda la página*/
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;
    }

    public void ventanaActiva(){
        Set<String> identificadores = driver.getWindowHandles();
        for(String identificador : identificadores){
            driver.switchTo().window(identificador);
        }
    }

    public void ventanaInicial(){
        driver.close(); //Cerramos la ventana para volver a la inicial
        driver.switchTo().window("");// "" indica que regrese a la ventana inicial (ventana default)
    }

    //En caso aparezca un anuncio que no permita al robot continuar con el flujo
    public void scrollVertical(){
        js.executeScript("window.scrollBy(0, 1000)");
    }

    public static void evidencias() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        String path = "C:/Users/Bryan Corrales/Desktop/QA Automation/Selenium/selenium-cucumber/target/evidencias/";
        String nombre = formato.format(fecha) + "_evidencia.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //La excepción es necesaria para poder detectar el error de que la ruta (path) sea invalida
        FileUtils.copyFile(file, new File(path + nombre));
    }
}
