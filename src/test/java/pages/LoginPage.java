package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    //O retorno ser� o nome da p�gina que ser� encaminhado o fluxo (LoginFormPage)
    public LoginFormPage clickSignIn(){
       
    	navegador.findElement(By.linkText("Sign in")).click();

        //Deve ser criado uma nova instancia da p�gina pois o fluxo ir� para a nova p�gina (LoginFormPage)
        return new LoginFormPage(navegador);
    }
}
