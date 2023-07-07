package definitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pageobjects.CarritoPage;
import pageobjects.ConfirmacionPage;
import pageobjects.MenuPage;
import pageobjects.PagoPage;
import pageobjects.TarjetaPage;

import java.io.IOException;

import static support.Util.evidencias;

public class CarritoDefinition {
    MenuPage menu;
    TarjetaPage tarjeta;
    CarritoPage carrito;
    PagoPage pago;
    ConfirmacionPage confirmacion;

    public CarritoDefinition(){
        menu = new MenuPage();
        tarjeta = new TarjetaPage();
        carrito = new CarritoPage();
        pago = new PagoPage();
        confirmacion = new ConfirmacionPage();
    }
    @Dado("que la web este operativa")
    public void queLaWebEsteOperativa() {
        Hooks.driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
    }

    @Cuando("se genera el número de tarjeta")
    public void seGeneraElNumeroDeTarjeta() throws IOException {
        menu.clickGenerarTarjeta();
        menu.ventanaActiva();
        tarjeta.obtenerNroTarjeta();
        tarjeta.obtenerExp();
        tarjeta.obtenerCvv();
        tarjeta.obtenerCreditLimit();
        evidencias(); //Nota: El IOException parte de aqui.
        tarjeta.ventanaInicial();
    }

    @Y("selecciona la cantidad {string}")
    public void seleccionaLaCantidad(String cantidad) {
        carrito.seleccionarCantidad(cantidad);
    }

    @Y("realiza la compra del producto")
    public void realizaLaCompraDelProducto() {
        carrito.clickComprar();
    }

    @E("ingresa los datos de la tarjeta")
    public void ingresaLosDatosDeLaTarjeta() throws IOException {
        pago.escribirNroTarjeta(TarjetaPage.nroTarjeta);
        pago.seleccionarMes(TarjetaPage.mes);
        pago.seleccionarYear(TarjetaPage.year);
        pago.escribirCvv(TarjetaPage.cvv);
        evidencias();
    }

    @Y("paga el producto")
    public void pagaElProducto() {
        pago.scrollVertical();
        pago.clickPagar();
    }

    @Entonces("validar el mensaje de pago {string}")
    public void validarElMensajeDePago(String mensaje) throws IOException {
        confirmacion.validarMensaje(mensaje);
        evidencias();
        confirmacion.mostrarCodigo();
    }
}
