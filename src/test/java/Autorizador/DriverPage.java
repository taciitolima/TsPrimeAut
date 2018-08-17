package Autorizador;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverPage{

    public WebDriver driver;
    public WebDriver wait;

    public void getChrome(String url){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\701033\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //Maximizar Browser
        getUrl(url); // Navegação para a url solicitada

    }
    // Método para inserir url
    public void getUrl(String url){
        driver.get(url);
    }

}
