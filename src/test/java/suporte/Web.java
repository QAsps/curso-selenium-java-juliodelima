package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver abrirPagina(){
      
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\pannuviam\\DRIVERS\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }


}
