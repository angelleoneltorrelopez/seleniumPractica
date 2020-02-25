package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class buscadorGoogle {
    WebDriver driver;
    @Test
    public void busqueda(){
        driver = localMacOSChrome();
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("www.ingenieriazeros.com", Keys.ENTER);
        System.out.println();
        driver.close();
    }
    public static WebDriver localMacOSChrome(){
        String pathDescarga = System.getProperty("user.dir")+"/downloads/";
        System.setProperty("webdriver.chrome.driver","Drivers/macOS/Chrome/chromedriver");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", pathDescarga);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        ChromeDriver driver= new ChromeDriver(options);
        return driver;
    }

}
