package view;

import java.util.Scanner;

import controller.GerenciadorDeCliente;
import controller.GerenciadorDeLoja;
import controller.GerenciadorDeVeiculos;
import controller.GerenciadorDeVenda;
import controller.GerenciadorDeVendedor;

public class MenuFrenteDeLoja {

	public void exibirFrenteDeLoja() {
		Scanner scan = new Scanner(System.in);
		int opcao;
		try {
			do {
				System.out.println("______________________________________");
				System.out.println("==== FRENTE DE LOJA ====");
				System.out.println("1. Gerenciar Veículo");
				System.out.println("2. Gerenciar Loja");
				System.out.println("3. Gerenciar Vendedor");
				System.out.println("4. Gerenciar Cliente");
				System.out.println("5. Gerenciar Venda");
				System.out.println("6. Voltar para o menu superior");
				System.out.print("Escolha uma opção: ");

				opcao = scan.nextInt();

				switch (opcao) {
				case 1:

					int opcao1;
					boolean voltarMenuSuperior = false;

					do {
						System.out.println("______________________________________");
						System.out.println("==== GERENCIAR VEÍCULO ====");
						System.out.println("1. Consultar Veículo por Placa");
						System.out.println("2. Voltar para o menu superior");
						System.out.println("3. Sair");
						System.out.print("Escolha uma opção: ");

						opcao1 = scan.nextInt();

						switch (opcao1) {
						case 1:
							GerenciadorDeVeiculos consultarPlaca = new GerenciadorDeVeiculos();
							consultarPlaca.consultarVeiculoPorPlaca();
							break;
						case 2:
							exibirFrenteDeLoja();
							break;
						case 3:
							MenuPrincipal voltarMenuPrincipal = new MenuPrincipal();
							voltarMenuPrincipal.exibirMenu();
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (opcao1 != 3 && !voltarMenuSuperior);
					break;

				case 2:

					int opcao2;
					boolean voltarMenuSuperior1 = false;

					do {
						System.out.println("______________________________________");
						System.out.println("==== GERENCIAR LOJA ====");
						System.out.println("1. Listar todas as Lojas");
						System.out.println("2. Voltar para o menu superior");
						System.out.println("3. Sair");
						System.out.print("Escolha uma opção: ");

						opcao2 = scan.nextInt();

						switch (opcao2) {
						case 1:
							GerenciadorDeLoja listarLojas = new GerenciadorDeLoja();
							listarLojas.listarLoja();
							break;
						case 2:
							exibirFrenteDeLoja();
							break;
						case 3:
							MenuPrincipal voltarMenuPrincipal = new MenuPrincipal();
							voltarMenuPrincipal.exibirMenu();
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (opcao2 != 3 && !voltarMenuSuperior1);
					break;
				case 3:

					int opcao3;
					boolean voltarMenuSuperior2 = false;

					do {
						System.out.println("______________________________________");
						System.out.println("==== GERENCIAR VENDEDOR ====");
						System.out.println("1. Consultar Vededor por nome");
						System.out.println("2. Voltar para o menu superior");
						System.out.println("3. Sair");
						System.out.print("Escolha uma opção: ");

						opcao3 = scan.nextInt();

						switch (opcao3) {
						case 1:
							GerenciadorDeVendedor listaVendedor = new GerenciadorDeVendedor();
							listaVendedor.listarVendedor();
							break;
						case 2:
							exibirFrenteDeLoja();
							break;
						case 3:
							MenuPrincipal voltarMenuPrincipal = new MenuPrincipal();
							voltarMenuPrincipal.exibirMenu();
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (opcao3 != 3 && !voltarMenuSuperior2);
					break;
				case 4:
					int opcao4;
					boolean voltarMenuSuperior3 = false;

					do {
						System.out.println("______________________________________");
						System.out.println("==== GERENCIAR CLIENTE ====");
						System.out.println("1. Cadastrar Cliente");
						System.out.println("2. Consultar Cliente por CPF");
						System.out.println("3. Voltar para o menu superior");
						System.out.println("4. Sair");
						System.out.print("Escolha uma opção: ");

						opcao4 = scan.nextInt();

						switch (opcao4) {
						case 1:
							GerenciadorDeCliente cadastroCliente = new GerenciadorDeCliente();
							cadastroCliente.cadastrarCliente();
							break;
						case 2:
							GerenciadorDeCliente consultarCliente = new GerenciadorDeCliente();
							consultarCliente.consultarClienteCpf();
						case 3:
							exibirFrenteDeLoja();
							break;
						case 4:
							MenuPrincipal voltarMenuPrincipal = new MenuPrincipal();
							voltarMenuPrincipal.exibirMenu();
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (opcao4 != 3 && !voltarMenuSuperior3);
					break;
				case 5:
					int opcao5;
					boolean voltarMenuSuperior4 = false;

					do {
						System.out.println("______________________________________");
						System.out.println("==== GERENCIAR VENDA ====");
						System.out.println("1. Cadastrar Venda");
						System.out.println("2. Voltar para o menu superior");
						System.out.println("3. Sair");
						System.out.print("Escolha uma opção: ");

						opcao5 = scan.nextInt();

						switch (opcao5) {
						case 1:
							GerenciadorDeVenda cadastrarVenda = new GerenciadorDeVenda();
							cadastrarVenda.cadastrarVenda();
							break;
						case 2:
							exibirFrenteDeLoja();
						case 3:
							MenuPrincipal voltarMenuPrincipal = new MenuPrincipal();
							voltarMenuPrincipal.exibirMenu();
							break;
						default:
							System.out.println("Opção inválida. Tente novamente.");
							break;
						}
					} while (opcao5 != 3 && !voltarMenuSuperior4);
					break;
				case 6:
					System.out.println("Voltando para o menu principal...");
					MenuPrincipal voltarMenuPrincipal = new MenuPrincipal();
					voltarMenuPrincipal.exibirMenu();
				default:
					System.out.println("Opção inválida. Tente novamente.");
					break;
				}
			} while (opcao != 6);
		} catch (Exception erro) {

			System.out.println(
					"Entrada inválida. Por favor, insira um número válido de acordo com o menu.");
		} finally {
			exibirFrenteDeLoja();
			scan.close();

		}

	}
}
