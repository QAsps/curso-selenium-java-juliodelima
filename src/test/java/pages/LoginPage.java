package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    //O retorno será o nome da página que será encaminhado o fluxo (LoginFormPage)
    public LoginFormPage clickSignIn(){
       
    	navegador.findElement(By.linkText("Sign in")).click();

        //Deve ser criado uma nova instancia da página pois o fluxo irá para a nova página (LoginFormPage)
        return new LoginFormPage(navegador);
    }
}
