package definitions;

import io.cucumber.java.es.*;
import pageobjects.*;

import java.io.IOException;

import static support.util.evidencias;

public class carritoDefinition {
    menuPage menu;
    tarjetaPage tarjeta;
    carritoPage carrito;
    pagoPage pago;
    confirmacionPage confirmacion;

    public carritoDefinition(){
        menu = new menuPage();
        tarjeta = new tarjetaPage();
        carrito = new carritoPage();
        pago = new pagoPage();
        confirmacion = new confirmacionPage();
    }
    @Dado("que la web este operativa")
    public void queLaWebEsteOperativa() {
        hooks.driver.get("https://demo.guru99.com/payment-gateway/purchasetoy.php");
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
        pago.escribirNroTarjeta(tarjetaPage.nroTarjeta);
        pago.seleccionarMes(tarjetaPage.mes);
        pago.seleccionarYear(tarjetaPage.year);
        pago.escribirCvv(tarjetaPage.cvv);
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
