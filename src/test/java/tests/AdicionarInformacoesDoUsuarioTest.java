package tests;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import suporte.Generator;
import suporte.Screenshot;

public class AdicionarInformacoesDoUsuarioTest {

	private WebDriver navegador;

	@Before
	public void setup() {
		// Abrindo o navegador
		System.setProperty("webdriver.chrome.driver", "D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-selenium-java-juliodelima\\src\\test\\java\\drivers\\chromedriver.exe");
		
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Navegando para a página do Taskit
		navegador.get("http://www.juliodelima.com.br/taskit");

		// Clicar no link que possui o texto "Sign In"
		navegador.findElement(By.linkText("Sign in")).click();

		// Identificando o formulário de Login
		WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

		// Digitar o texto "julio0001" no input que possui o name "login" que está
		// dentro do form que possui o id "signinbox"
		formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

		// Digitar o texto "123456" no campo que possui o name "password" que está
		// dentro do form que possui o id "signinbox"
		formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link que possui o texto "SIGN IN"
		formularioSignInBox.findElement(By.linkText("SIGN IN")).click();

		// Clicar no link que possui a class "me"
		navegador.findElement(By.className("me")).click();

		// Clicar no link que possui o texto "MORE DATA ABOUT YOU"
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
	}

	@Rule
	public TestName test = new TestName();
    @Test
	public void testAdicionarInformacaoDoUsuario() {
		// Clicar no botão que possui o xpath //button[@data-target="addmoredata"]
		navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

		// Identificar a popup que possui o id "addmoredata"
		WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

		// Escolher a opção "Phone" na combo que possui o name "type"
		WebElement campoType = popupAddMoreData.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");

		// Digitar "+447923453477" no campo que possui o name "contact"
		popupAddMoreData.findElement(By.name("contact")).sendKeys("+447923456789");

		// Clicar no link com texto "SAVE" que está dentro da popup
		popupAddMoreData.findElement(By.linkText("SAVE")).click();

		// Na mensagem de id "toast-container", validar se texto "Your contact has been
		// added!" é apresentado
		WebElement mensagemPopup = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPopup.getText();
		assertEquals("Your contact has been added!", mensagem);
		
		//Tirar screenshot
		String screenshotArquivo = "D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-selenium-java-juliodelima\\screenshots/" + Generator.gerarDataArquivo() + test.getMethodName() + ".png";
		Screenshot.tirarScreenshot(navegador, screenshotArquivo);
	}

	@Test
	public void testRemoverInformacaoDoUsuario() {
		// Clicar no elemento através do xpath span[text()='+447923456789']/following-sibling::a
		navegador.findElement(By.xpath("//span[text()=\"+447923456789\"]/following-sibling::a")).click();

		// Clicar em OK na janela javascript
		navegador.switchTo().alert().accept();

		// Na mensagem de id "toast-container", validar se texto "Rest in peace, dear phone!" é apresentado
		WebElement mensagemPopup = navegador.findElement(By.id("toast-container"));
		String mensagem = mensagemPopup.getText();
		assertEquals("Rest in peace, dear phone!", mensagem);

		// Aguardar até 10 segundos para que a mensagem desapareça
		WebDriverWait aguardar = new WebDriverWait(navegador, 10);
		aguardar.until(ExpectedConditions.stalenessOf(mensagemPopup));
		
		//Tirar screenshot
		String screenshotArquivo = "D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-selenium-java-juliodelima\\screenshots/" + Generator.gerarDataArquivo() + test.getMethodName() + ".png";
		Screenshot.tirarScreenshot(navegador, screenshotArquivo);

		// Clicar no link que possui o texto "Logout"
		navegador.findElement(By.linkText("Logout"));
	}

	@After
	public void fecharNavegador() {
		// Fechar o navegador
		navegador.quit();
	}
}
