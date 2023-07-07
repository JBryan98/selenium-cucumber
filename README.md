## Automatización Web con Selenium y Cucumber
### Descripción:
El proyecto es una muestra de como implementar Selenium y Cucumber para automatización Web. Se automatizo un flujo
de compras de la web https://demo.guru99.com/payment-gateway/purchasetoy.php.
### Instalación
Para ejecutar el proyecto es necesaria la siguiente configuración:
- Empezamos por clonar el proyecto: 
````agsl
 git clone https://github.com/JBryan98/selenium-cucumber.git
````

- Despues procedemos a descargar el chromedriver mas reciente de acuerdo a la versión de Google Chrome que tengamos.
Para ello abrimos Google Chrome y en la opción y hacemos click en **Ayuda** y seleccionamos la opción **Información de Google Chrome**
<img src="https://www.muycomputer.com/wp-content/uploads/2022/09/Comprobar-actualizaciones-de-Google-Chrome-en-Windows-y-macOS-1.png">


- Verificamos la versión de Google Chrome y procedemos a descargar el chrome driver que sea compatible con nuestra versión en
https://chromedriver.chromium.org/downloads
- Una vez descargado el driver, guardarlo en la siguiente ruta y reemplazar el driver que se encuentra en: ```src/test/resources/drivers/```
- Finalmente, en el package **support** editar la función **evidencias()** de la clase *Util* y reemplazar 
el path por la ruta actual donde tienes el proyecto. Este paso es necesario para que las capturas de pantalla se guarden correctamente.
```
String path = "C:/Users/Bryan Corrales/Desktop/QA Automation/Selenium/selenium-cucumber/target/evidencias/";
```
- En caso hayas seguido los pasos y no logre ejecutar el proyecto, quizas el error se solucione actualizando la dependencia
de *Selenium*, para ello visita maven repository https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java 
y actualiza la versión en el archivo pom.xml 


### Ejecución
Para ejecutar el proyecto se creo el runner **RunTest** que se encuentra en el package **support**.
Puedes cambiar el parametro tags de **@CucumberOptions** para cambiar el scenario que deseas ejecutar, 
los cuales son **@regression** y **@smoke**
````
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/carrito.feature",
                 glue = "definitions",
                 tags = "@regression",
                 plugin = {"html:target\\cucumber-report\\index.html","json:target\\cucumber-report\\cucumber.json"})
public class RunTest {
}
````

### Acceder al reporte
- Cada vez que uno ejecuta la prueba desde el runner, este generará un archivo cucumber.json, el cual se ubicará en la ruta especificada
```target/cucumber-report/cucumber.json``` , para visualizar este reporte básico solo hay que abrir 
el archivo **index.html** que se encuentra dentro de la ruta anteriormente mencionada junto al archivo cucumber.json.
- Para acceder al reporte personalizado de **cluecumber-report-plugin** desde el archivo pom.xml ejecutamos el comando de maven
````agsl
 maven verify
````
- Este comando generará un reporte personalizado y mas detallado a partir del archivo cucumber.json anteriormente mencionado.
Este reporte se generará en la ruta ``target/generated-report/${Report_folder}/index.html`` donde **Report_folder** viene a ser 
el nombre de la carpeta en formato **yyMMdd_HHmm** que contiene al reporte. Para visualizarlo solo hay que abrir el archivo
**index.html**
