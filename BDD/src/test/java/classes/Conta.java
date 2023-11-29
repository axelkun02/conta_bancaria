package classes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 *@author Axelkun02
 *
 * A classe Conta representa uma conta bancária especial.
 * Esta classe é usada para testar o comportamento de saque da conta.
 */

public class Conta {
	
	int saldo;
	String cliente;
	boolean valida;
	
	 /**
     * Configura um cliente especial com um saldo inicial especificado.
     *
     * @param int1 variavel que representa o saldo de um cliente especial
     * @throws Throwable em caso de exceção durante a execução do teste.
     */
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		this.valida = true;
		saldo = int1;
		cliente = "especial";
		System.out.println("Saldo: " + saldo);	
	}

	 /**
     * Realiza uma solicitação de saque na conta especial.
     *
     * @param int1 O valor a ser sacado da conta.
     * @throws Throwable Em caso de exceção durante a execução do teste.
     */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		System.out.println("Foi solicitado um saque no valor de: " + int1 + "R$");
	}

	 /**
     * Verifica se o saque foi efetuado com sucesso e atualiza o saldo da conta.
     *
     * @param arg1 O saldo esperado da conta após o saque.
     * @throws Throwable Em caso de exceção durante a execução do teste.
     */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		if(cliente=="especial") {
			saldo = saldo - int1; 
			System.out.println("Saque efetuado e saldo atualizado com sucesso!" + "\n Saldo atual: " + saldo);
			
		} else if (cliente =="comum" && saldo >= 0) {
			saldo = saldo + int1;
			System.out.println("Saque efetuado e saldo atualizado com sucesso!" + "\n Saldo atual: " + saldo);
			
		} else if (cliente =="comum" && saldo < 0)
			System.out.println("Saldo insulficiente!" + "\n Saldo atual: " + saldo);
	}


	 /**
    * Realiza verificações adicionais após o saque.
    *
    * @throws Throwable Em caso de exceção durante a execução do teste.
    */
	@Then("check more outcomes")
	public void check_more_outcomes() {
	    System.out.println("Aguardando instruções.");
	}

	/**
     * Configura um cliente especial com um saldo inicial especificado.
     *
     * @param int1 variavel que representa o saldo de um cliente especial
     * @throws Throwable em caso de exceção durante a execução do teste.
     */
	@Given("Um cliente comum com um saldo atual de {int} reais")
	public void um_cliente_comum_com_um_saldo_atual_de_reais(Integer int1) {
		this.valida = false;
		saldo = int1;
		cliente = "comum";
		System.out.println("Saldo: " + saldo);	
	}
	
	 /**
     * Realiza uma solicitação de saque na conta especial.
     *
     * @param int1 O valor a ser sacado da conta.
     * @throws Throwable Em caso de exceção durante a execução do teste.
     */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		System.out.println("Foi solicitado um saque no valor de: " + int1 + "R$");
	}
	

	 /**
   * Realiza verificações adicionais após o saque.
   *
   * @throws Throwable Em caso de exceção durante a execução do teste.
   */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo insulficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insulficiente() {
		if(cliente=="comum") {
			System.out.println("Saldo insulficiente!" + "\n Saldo atual: " + saldo);
		}
	}

}
