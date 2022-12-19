# language: es
Característica: Funcionalidad del carrito de compra

  @smoke
  Escenario: Compra de un producto
    Dado que la web este operativa
    Cuando se genera el número de tarjeta
    Y selecciona la cantidad "5"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Entonces validar el mensaje de pago "Payment successfull!"

  @regresion
  Esquema del escenario: Compra de un producto con múltiples cantidades
    Dado que la web este operativa
    Cuando se genera el número de tarjeta
    Y selecciona la cantidad "<cantidad>"
    Y realiza la compra del producto
    E ingresa los datos de la tarjeta
    Y paga el producto
    Entonces validar el mensaje de pago "<mensaje>"
    Ejemplos: Tabla de cantidades
      | cantidad | mensaje              |
      | 4        | Payment successfull! |
      | 6        | Payment successfull! |
      | 8        | Payment fail |
