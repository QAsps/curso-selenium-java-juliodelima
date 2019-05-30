package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage{

    public LoginFormPage(WebDriver navegador) {
        super(navegador);
    }

    /*
     * O retorno será o nome da página que será encaminhado o fluxo (LoginFormPage)
     * Ficará na mesma página 
     * Deve haver parâmetro pois será informado um valor
     */

    public LoginFormPage digitarLogin(String login) {
        
    	navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

        //O fluxo irá retornar a mesma página (LoginPage)
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

