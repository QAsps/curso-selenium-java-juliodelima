package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioPageObjectsTest.csv")

public class InformacoesUsuarioPageObjectsTest {
  
	private WebDriver navegador;

    @Before
    public void setup() {
       
    	navegador = Web.abrirPagina();
    }

    @Test
    public void testAdicionarUmaInformacaoDoUsuario(
          
    		@Param(name="login")String login,
            @Param(name="senha")String senha,
            @Param(name="tipo")String tipo,
            @Param(name="contato")String contato,
            @Param(name="mensagem")String mensagemEsperada
    ){

        String mensagemToast = new LoginPage(navegador)
                .clickSignIn()
                .fazerLogin(login, senha)
                .clicarMe()
                .clicarAbaMoreDataAboutYou()
                .clicarBotaoAddMoreDataAboutYou()
                .adicionarContato(tipo, contato)
                .capturarMensagemToast();

        assertEquals(mensagemEsperada, mensagemToast);
    }

    @After
    public void tearDown() {
        // Fechar o navegador
        navegador.quit();
    }
}
