package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    /*Corazon del bot*/
    public static WebDriver driver;

    /*Tiene que ser @Before de io.cucumber*/
    @Before
    public static void setUp(){
        /*Indicamos el webdriver con el que trabajaremos y su ubicacion*/
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        /*Inicializa el navegador*/
        driver = new ChromeDriver();

        /*Maximiza la ventana del navegador*/
        driver.manage().window().maximize();
    }
    @After
    public static void tearDown(){
        /*Elimina las cookies*/
        driver.manage().deleteAllCookies();

        /*Cierra el navegador para evitar que se abran multiples ventanas por test*/
        driver.quit();
    }
}
