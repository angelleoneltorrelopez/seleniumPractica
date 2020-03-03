package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class buscadorGoogle {
    WebDriver driver;
    //ejemplo de xpath busqueda por attibuto
    //    "//input[@name='q']"
    //encerrados en comillas dobles
    //siempre inicia doble diagonal //
    //seguido del elemento HTML a buscar = input
    //si el input tiene el atributo name se coloca entre corchetes []
    //y el signo de @
    //siguiendo por el signo =
    //y entre comilla simple el valor del atributo en este caso 'q'
    @Test
    public void busqueda(){
        driver = locaLinuxFirefox(); //Cambiar segun el sistema operativo
        WebDriverWait wait=new WebDriverWait(driver, 10); //Definir espera explicita
        driver.manage().window().maximize(); //maximizar navegador
        driver.get("http://www.google.com"); //Colocar URL en el navegador de la pagina a testear

        //Realizar busqueda en google
        //Localizar elemento input del buscador
        WebElement inputBuscadorGoogle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
        //Por ser un input se limpia (opcional)
        inputBuscadorGoogle.clear();
        //Se escribe en el imput
        inputBuscadorGoogle.sendKeys("www.ingenieriazeros.com", Keys.ENTER);

        //accion click del primer enlace
        WebElement primerEnlace = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[text() = 'Ingeniería Zeros']")));
        primerEnlace.click();

        WebElement instalarJavaUbuntu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3/a[@href = 'https://www.ingenieriazeros.com/2019/05/instalar-java-ubuntu-18.html']")));
        instalarJavaUbuntu.click();

        //obtener texto del elemento a buscar en consola de intellij
        WebElement codigoInstalarJavaUbuntu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//pre/span/span[2]")));
        System.out.println(codigoInstalarJavaUbuntu.getText());


        System.out.println();
        driver.close(); //se cierra el navegador
    }




    public static WebDriver locaLinuxFirefox(){
        System.setProperty("webdriver.gecko.driver", "Drivers/Linux/Firefox/geckodriver");
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("marionette", true);
        FirefoxDriver driver = new FirefoxDriver(capabilities);
        return driver;
    }

    public static WebDriver localWindowsFirefox(){
        System.setProperty("webdriver.gecko.driver", "Drivers\\Windows\\Firefox\\geckodriver.exe");
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("marionette", true);
        FirefoxDriver driver = new FirefoxDriver(capabilities);
        return driver;
    }

    public static WebDriver localMacOSFirefox(){
        System.setProperty("webdriver.gecko.driver", "Drivers/macOS/Firefox/geckodriver");
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("marionette", true);
        FirefoxDriver driver = new FirefoxDriver(capabilities);
        return driver;
    }

}
