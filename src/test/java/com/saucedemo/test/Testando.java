package com.saucedemo.test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.core.BaseTest;

public class Testando extends BaseTest {

	@Test
	public void loginLogout() throws Exception{ 
		// Print da tela de login
		tirarPrint ("CT_Login - Tela de login");
		
		//Preencher usuário e senha
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // localiza o campo username pelo id e digita o usuário
        tirarPrint("CT_Login - Preencheu usuario"); //salva evidência com usuário já digitado
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); //localiza o campo password pelo id e digita a senha
        tirarPrint("CT_Login - Preencheu senha"); //salva evidência com senha já digitado
        driver.findElement(By.id("login-button")).click(); //localiza o botao login pelo id e clica
        tirarPrint("CT_Login - Apos Login");
        
        
        
       //Verifica se o login funcionou
        String tituloPagina = driver.findElement(By.className("title")).getText();
        Assertions.assertEquals("Products", tituloPagina, "Login falhou - pagina de produtos nao carregou");
    
        
        //Logout
        driver.findElement(By.id("react-burger-menu-btn")).click(); 
        WebDriverWait waitMenu = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitMenu.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        
        driver.findElement(By.id("logout_sidebar_link")).click(); 
        
        
	   
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        tirarPrint("CT_Login - Apos logout"); 

      
        Assertions.assertTrue(
            driver.findElement(By.id("login-button")).isDisplayed(), 
            "Logout falhou - botao de login nao apareceu" 
           
            
        );          
        
	}
	
    @Test
    public void loginComUsuarioInvalido() {

        tirarPrint("CT_LoginInvalido - Tela de login"); 
        fazerLogin("usuario_errado", "senha_errada"); 

        tirarPrint("CT_LoginInvalido - Mensagem de erro"); 

     
       
        String mensagemErro = driver.findElement(By.cssSelector("[data-test='error']")).getText(); 

     
        Assertions.assertTrue(
            mensagemErro.contains("Username and password do not match any user in this service"), 
            "Mensagem de erro nao apareceu" 
        );
    }

	
	
}
