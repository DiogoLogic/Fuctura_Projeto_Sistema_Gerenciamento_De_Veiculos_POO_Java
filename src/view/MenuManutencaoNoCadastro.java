package view;


import java.util.Scanner;

import controller.GerenciadorDeCliente;
import controller.GerenciadorDeLoja;
import controller.GerenciadorDeVeiculos;
import controller.GerenciadorDeVenda;
import controller.GerenciadorDeVendedor;

public class MenuManutencaoNoCadastro {

	public void exibirManutencaoCadastro() {
		Scanner scan = new Scanner(System.in);
		int opcao1;
	try {
		do {
			System.out.println("______________________________________");
			System.out.println("==== MANUTENÇÃO NO CADASTRO ====");
			System.out.println("1. Gerenciar Veículo");
			System.out.println("2. Gerenciar Loja");
			System.out.println("3. Gerenciar Vendedor");
			System.out.println("4. Gerenciar Cliente");
			System.out.println("5. Gerenciar Venda");
			System.out.println("6. Voltar para o menu principal");
			System.out.print("Escolha uma opção: ");
			opcao1 = scan.nextInt();

			switch (opcao1) {
			case 1:

				int opcao2;
				boolean voltarMenuSuperior = false;
				do {
					System.out.println("______________________________________");
					System.out.println("==== GERENCIAR VEICULO ====");
					System.out.println("1. Cadastrar Veículo");
					System.out.println("2. Excluir Veículo");
					System.out.println("3. Alterar dados do veículo");
					System.out.println("4. Voltar para o menu superior");

					opcao2 = scan.nextInt();

					switch (opcao2) {
					case 1:
						GerenciadorDeVeiculos cadastrarVeiculo = new GerenciadorDeVeiculos();
						cadastrarVeiculo.cadastrarVeiculo();
						break;
					case 2:
						GerenciadorDeVeiculos ExcluirVeiculo = new GerenciadorDeVeiculos();
						ExcluirVeiculo.excluirVeiculo();
					case 3:
						GerenciadorDeVeiculos AlterarCadastro = new GerenciadorDeVeiculos();
						AlterarCadastro.alterarDadosVeiculo();

						break;
					}
					break;

				} while (opcao2 != 4 && !voltarMenuSuperior);
				break;

			case 2:
				int opcao3;
				boolean voltarMenuSuperior1 = false;
				do {
					System.out.println("______________________________________");
					System.out.println("==== GERENCIAR LOJA ====");
					System.out.println("1. Cadastrar Loja");
					System.out.println("2. Excluir Loja");
					System.out.println("3. Alterar dados da Loja");
					System.out.println("4. Voltar para o menu superior");

					opcao3 = scan.nextInt();

					switch (opcao3) {
					case 1:
						GerenciadorDeLoja cadastroLoja = new GerenciadorDeLoja();
						cadastroLoja.cadastrarLoja();
						break;
					case 2:
						GerenciadorDeLoja ExcluirLojas = new GerenciadorDeLoja();
						ExcluirLojas.excluirLoja();
					case 3:
						GerenciadorDeLoja AlterarCadastroLoja = new GerenciadorDeLoja();
						AlterarCadastroLoja.alterarDadosLoja();

						break;
					}
					break;

				} while (opcao3 != 4 && !voltarMenuSuperior1);
				break;
				
			case 3:
				int opcao4;
				boolean voltarMenuSuperior2 = false;
				do {
					System.out.println("______________________________________");
					System.out.println("==== GERENCIAR VENDEDOR ====");
					System.out.println("1.  Cadastrar Vendedor");
					System.out.println("2. Excluir Vendedor");
					System.out.println("3. Alterar do Vendedor");
					System.out.println("4. Voltar para o menu superior");

					opcao4 = scan.nextInt();

					switch (opcao4) {
					case 1:
						GerenciadorDeVendedor cadastroVendedor= new GerenciadorDeVendedor();
						cadastroVendedor.cadastrarVendedor();
						
						break;
					case 2:
						GerenciadorDeVendedor ExcluirVendedor= new GerenciadorDeVendedor();
						ExcluirVendedor.excluirVendedor();
					case 3:
						GerenciadorDeVendedor alterarVendedor= new GerenciadorDeVendedor();
						alterarVendedor.alterarDadosVendedor();

						break;
					}
					break;

				} while (opcao4 != 4 && !voltarMenuSuperior2);
				break;
				
			
			case 4:
				int opcao5;
				boolean voltarMenuSuperior3 = false;
				do {
					System.out.println("______________________________________");
					System.out.println("==== GERENCIAR CLIENTE ====");
					System.out.println("1. Cadastrar Cliente");
					System.out.println("2. Excluir Cliente");
					System.out.println("3. Alterar dados do CLiente");
					System.out.println("4. Voltar para o menu superior");

					opcao5= scan.nextInt();

					switch (opcao5) {
					case 1:
						GerenciadorDeCliente cadastroCliente = new GerenciadorDeCliente();
						cadastroCliente.cadastrarCliente();
						
						break;
					case 2:
						GerenciadorDeCliente excluirCliente = new GerenciadorDeCliente();
						excluirCliente.excluirCliente();
					case 3:
						GerenciadorDeCliente alterarDadosCliente = new GerenciadorDeCliente();
						alterarDadosCliente.alterarDadosCliente();

						break;
					case 4:
						exibirManutencaoCadastro();
						break;
					}
					break;

				} while (opcao2 != 4 && !voltarMenuSuperior3);
				break;
			case 5:
				int opcao6;
				boolean voltarMenuSuperior4 = false;
				do {
					System.out.println("______________________________________");
					System.out.println("==== GERENCIAR VENDA ====");
					System.out.println("1. Cadastrar Venda");
					System.out.println("2. Excluir Venda");
					System.out.println("3. Voltar para o menu superior");

					opcao6 = scan.nextInt();

					switch (opcao6) {
					case 1:
						GerenciadorDeVenda cadastrarVenda = new GerenciadorDeVenda();
						cadastrarVenda.cadastrarVenda();
						
						break;
					case 2:
						GerenciadorDeVenda excluirVenda = new GerenciadorDeVenda();
						excluirVenda.excluirVenda();
					case 3:
						exibirManutencaoCadastro();

						break;
					}
					break;

				} while (opcao6 != 4 && !voltarMenuSuperior4);
				break;
			
			case 6:
				System.out.println("Voltando para o menu principal...");

				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuPrincipal.exibirMenu();
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}

		} while (opcao1 != 6);
	} catch (Exception erro) {
        System.out.println("Entrada inválida. Por favor, insira um número válido de acordo com o menu.");
        
    } finally {
    	exibirManutencaoCadastro();
        scan.close();
    }

}
}
