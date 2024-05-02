package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import view.MenuManutencaoNoCadastro;

public class GerenciadorDeCliente extends MenuManutencaoNoCadastro {
	private static List<Cliente> clientes = new ArrayList<>();

	// metodo para cadastrar clientes
	public void cadastrarCliente() {
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Digite o nome da cliente: ");
			String nome = scan.nextLine();

			System.out.println("Digite o CPF do cliente: ");
			String CPF = scan.nextLine();

			System.out.println("Digite o telefone do cliente: ");
			String telefone = scan.nextLine();

			Cliente dadoscliente = new Cliente(nome, CPF, telefone);
			clientes.add(dadoscliente);

			int tamanho = clientes.size();
			if (tamanho == 1) {

				System.out.println("Cliente cadastrado com sucesso!" + tamanho);
				exibirManutencaoCadastro();

			}

		} catch (Exception erro) {
			System.out.println("Erro ao cadastrar Cliente, tente novamente: ");
		} finally {
			cadastrarCliente();
			scan.close();
		}

	}

	// Método para alterar dados do cliente
	public void alterarDadosCliente() {
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("Digite o nome do cliente para ser alterado: ");
			String nome = scan.nextLine();

			boolean clienteEncontrado = false;
			for (Cliente dadosCliente : clientes) {
				if (dadosCliente.getNome().equalsIgnoreCase(nome)) {
					clienteEncontrado = true;
					System.out.println("Cliente encontrado: ");
					System.out.println(dadosCliente);
					System.out.println("______________________________________");
					System.out.println("O que deseja alterar?");
					System.out.println("1. Nome");
					System.out.println("2. CPF");
					System.out.println("3. Telefone");
					System.out.println("4. Sair");

					int opcao = scan.nextInt();
					scan.nextLine();

					switch (opcao) {
					case 1:
						System.out.println("Digite o novo nome do cliente: ");
						String novoNomeCliente = scan.nextLine();
						dadosCliente.setNome(novoNomeCliente);
						break;
					case 2:
						System.out.println("Digite o novo CPF do cliente: ");
						String novoCpfCLiente = scan.nextLine();
						dadosCliente.setCpf(novoCpfCLiente);
						break;
					case 3:
						System.out.println("Digite o novo telefone do cliente: ");
						String novoTelefoneCliente = scan.nextLine();
						dadosCliente.setTelefone(novoTelefoneCliente);
						break;

					case 4:
						exibirManutencaoCadastro();
						break;
					default:
						System.out.println("Opção inválida. Tente novamente.");
						break;
					}

					System.out.println("Dados do cliente foram alterados do sucesso: ");
					System.out.println(dadosCliente);

					alterarDadosCliente();

					break;
				}
			}

			if (!clienteEncontrado) {
				System.out.println("Cliente não encontrado.");
				 exibirManutencaoCadastro(); 
			}

		} catch (Exception erro) {
			System.out.println("Erro ao alterar dados do cliente, tente novamente: ");
		} finally {

			alterarDadosCliente();
			scan.close();
		}
	}

	// metodo para Listar Cliente por CPF
	public void consultarClienteCpf() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF do cliente: ");
		String CPF = scan.nextLine();

		for (Cliente dadosCliente : clientes) {
			if (dadosCliente.getCpf().equalsIgnoreCase(CPF)) {
				System.out.println("Cliente encontrado: ");
				System.out.println(dadosCliente);
				return;
			}
		}

		System.out.println("Cliente não encontrado.");
		System.out.println("Por favor, ir até o menu manutenção de cadastro");

	}

	// metodo para excluir cliente por nome
	public void excluirCliente() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a placa do veículo que deseja excluir: ");
		String nome = scan.nextLine();

		boolean clienteEncontrado = false;
		for (Cliente dadosCliente : clientes) {
			if (dadosCliente.getNome().equalsIgnoreCase(nome)) {
				clientes.remove(dadosCliente);
				System.out.println("Loja removida com sucesso.");
				exibirManutencaoCadastro();
				clienteEncontrado = true;
				break;
			}
		}

		if (!clienteEncontrado) {
			System.out.println("Cliente não encontrado para exclusão, o mesmo "
					+ "não existe em nosso sistema, tente novamente!\"");

		}
	}
}