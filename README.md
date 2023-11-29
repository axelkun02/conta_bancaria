# Projeto de conta bancária utilizando Cucumber e Junit
----------------------

## Classe conta
```

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

```

------------------------------------------------

## Classe de teste

```
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@tag
Feature: Cliente faz saque de dinheiro Como um cliente, 
eu gostaria de sacar dinheiro em caixa eletronico, 
para que eu nao tenha que esperar em uma fila do banco.

  @tag1
  Scenario: Cliente especial com saldo negativo
    Given Um cliente especial com saldo atual de -200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efetuar o saque e atualizar o saldo da conta para -300 reais
    And check more outcomes

  @tag2
  Scenario Outline: Cliente comum com um saldo negativo
    Given Um cliente comum com um saldo atual de -200 reais
    When solicitar um saque de 200 reais
    Then não deve efetuar o saque e deve retornar a mensagem Saldo insulficiente
		Examples:
		| Nome    | Saldo  | Status  |
		| Especial|    -100| Sucesso |
		| Comum   |    -100| Falha   |

```

-------------------------------------------

## Resultados obtidos após rodar o JUnit

![print_cucumber2](https://github.com/axelkun02/conta_bancaria/assets/113148503/cfa21db6-4fb9-43cc-b57d-e5d0d7a0c09a)



