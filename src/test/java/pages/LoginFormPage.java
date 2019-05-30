package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    /*
     * O retorno ser� o nome da p�gina que ser� encaminhado o fluxo (LoginFormPage)
     * Ficar� na mesma p�gina 
     * Deve haver par�metro pois ser� informado um valor
     */

    public LoginFormPage digitarLogin(String login) {
        
    	navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        //O fluxo ir� retornar a mesma p�gina (LoginPage)
        return this;
    }

    public LoginFormPage digitarSenha(String senha) {
       
    	navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);

        return this;
    }

    public SecretaPage clicarSignIn(){
        
    	navegador.findElement(By.linkText("SIGN IN")).click();

        return new SecretaPage(navegador);
    }

    public SecretaPage fazerLogin (String login, String senha){
        
    	return digitarLogin(login)
                .digitarSenha(senha)
                .clicarSignIn();
    }
}

