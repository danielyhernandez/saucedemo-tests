package com.saucedemo.test;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.saucedemo.core.BaseTest;


public class CheckoutTest extends BaseTest{
	
	@Test
	public void finalizarCompra() {
		
		fazerLogin("standard_user","secret_sauce");
		tirarPrint("CT_Checkout - Apos login");
		
		//adicionar produto ao carrinho
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		tirarPrint("CT_Checkout - Produto adicionado");
		
		//abrir o carrinho
		driver.findElement(By.className("shopping_cart_link")).click();
		tirarPrint("CT_Checkout - Tela carrinho");
		
		//clicar em Checkout
		driver.findElement(By.id("checkout")).click();

		// espera o campo first-name aparecer antes de preencher
		WebDriverWait waitForm = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForm.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));

		tirarPrint("CT_Checkout - Tela de dados");
		
		//preencher dados pessoais
		driver.findElement(By.id("first-name")).sendKeys("Daniely");
		driver.findElement(By.id("last-name")).sendKeys("Hernandez");
		driver.findElement(By.id("postal-code")).sendKeys("15906490");
		tirarPrint("CT_Checkout - Dados preenchidos");
		
		//clicar em continue
		driver.findElement(By.id("continue")).click();
		tirarPrint("CT_Checkout - Resumo da compra");
		
		// Espera o produto aparecer no resumo
		WebDriverWait waitResumo = new WebDriverWait(driver, Duration.ofSeconds(10));

		waitResumo.until(
		    ExpectedConditions.visibilityOfElementLocated(
		        By.className("inventory_item_name")
		    )
		);

		
		//Verificar o Resumo da Compra
		String nomeProduto = driver.findElement(By.cssSelector(".cart_list .inventory_item_name")).getText();
		 Assertions.assertEquals("Sauce Labs Bike Light", nomeProduto, "Produto errado no resumo da compra");
		 
		 //finalizar a compra
		 driver.findElement(By.id("finish")).click();
		
		    // 9. Espera a confirmação aparecer
		   
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));
	        tirarPrint("CT_Checkout - Compra finalizada");

	        
	        // 10. Verifica a mensagem de confirmação
	    
	        String mensagemConfirmacao = driver.findElement(By.className("complete-header")).getText();
	  
	        Assertions.assertEquals("Thank you for your order!", mensagemConfirmacao, "Compra nao foi finalizada com sucesso");
 		
		
		
		
	}
	

}
