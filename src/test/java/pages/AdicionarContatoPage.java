package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdicionarContatoPage extends BasePage{

    public AdicionarContatoPage(WebDriver navegador) {
        
    	super(navegador);
    }

    public AdicionarContatoPage escolherTipoContato(String tipo){
      
    	WebElement tipoContato = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
        new Select(tipoContato).selectByVisibleText(tipo);

        return this;
    }

    public AdicionarContatoPage digitarContato(String contato){
        
    	navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(contato);

        return this;
    }

    public MePage clicarBotaoSalvar(){
       
    	navegador.findElement(By.id("addmoredata")).findElement(By.linkText("SAVE")).click();

        return new MePage(navegador);
    }

    public MePage adicionarContato(String tipo, String contato){
       
    	return escolherTipoContato(tipo)
                .digitarContato(contato)
                .clicarBotaoSalvar();
    }
}
