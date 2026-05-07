package com.saucedemo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.saucedemo.core.BaseTest;

public class CarrinhoTest extends BaseTest{
	
	@Test
	public void adicionarProdutoAoCarrinho () {
	
		fazerLogin("standard_user", "secret_sauce");
		tirarPrint("CT_Carrinho - Apos login");
		
		//adicionar o produto ao carrinho
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		tirarPrint("CT_Carrinho - Prduto adicionado");
		
		//Verificar se o contador do carrinho apareceu com 1 produto
		// getText() captura o texto visível do elemento na tela
		String contadorCarrinho = driver.findElement(By.className("shopping_cart_badge")).getText();
		Assertions.assertEquals("1", contadorCarrinho, "Produto nao foi adiconado ao carrinho");
		// assertEquals verifica se o valor esperado ("1") é igual ao valor real (contadorCarrinho)
		// se não for igual, o teste falha e exibe a mensagem "Produto nao foi adicionado ao carrinho"
		
		
		//Clica no icone do carrinho para abrir
		driver.findElement(By.className("shopping_cart_link")).click();
		tirarPrint("CT_Carrinho - Tela do carrinho");
		
		//Verificar se o produto esta no carrinho
		String nomeProduto = driver.findElement(By.cssSelector(".cart_item .inventory_item_name")).getText();
		Assertions.assertEquals("Sauce Labs Backpack", nomeProduto, "Produto nao encontrado no carrinho");
		
	}
	
	@Test
	public void removerProdutoDoCarrinho() {

	    // 1. Login
	    fazerLogin("standard_user", "secret_sauce");
	    tirarPrint("CT_RemoverCarrinho - Apos login");

	    // 2. Adiciona o produto ao carrinho
	    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	    tirarPrint("CT_RemoverCarrinho - Produto adicionado");

	    // 3. Abre o carrinho
	    driver.findElement(By.className("shopping_cart_link")).click();
	    tirarPrint("CT_RemoverCarrinho - Tela do carrinho com produto");

	    // 4. Remove o produto do carrinho
	    driver.findElement(By.id("remove-sauce-labs-backpack")).click();

	    // 5. Print DEPOIS de remover — carrinho vazio
	    tirarPrint("CT_RemoverCarrinho - Carrinho vazio apos remover");

	    // 6. Verifica se o carrinho ficou vazio
	    boolean carrinhoVazio = driver.findElements(By.className("shopping_cart_badge")).isEmpty();
	    Assertions.assertTrue(carrinhoVazio, "Carrinho nao ficou vazio apos remover o produto");

	}
	

}
