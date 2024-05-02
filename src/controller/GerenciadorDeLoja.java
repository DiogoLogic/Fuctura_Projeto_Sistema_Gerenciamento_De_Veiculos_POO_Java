package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Loja;
import view.MenuManutencaoNoCadastro;

public class GerenciadorDeLoja extends MenuManutencaoNoCadastro {
	private static List<Loja> lojas = new ArrayList<>();

	// metodo para cadastrar veiculos
	public void cadastrarLoja() {
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Digite o nome da loja: ");
			String nome = scan.nextLine();

			System.out.println("Digite o endereço da loja: ");
			String endereco = scan.nextLine();

			System.out.println("Digite o telefone da loja: ");
			String telefone = scan.nextLine();

			Loja loja = new Loja(nome, endereco, telefone);
			lojas.add(loja);

			int tamanho = lojas.size();
			if (tamanho == 1) {

				System.out.println("Loja cadastrada com sucesso!" + tamanho);
				exibirManutencaoCadastro();

			}

		} catch (Exception erro) {
			System.out.println("Erro ao cadastrar da loja, tente novamente: ");
		} finally {
			cadastrarLoja();
			scan.close();
		}

	}

	// Método para alterar dados da loja
	public void alterarDadosLoja() {
	    Scanner scan = new Scanner(System.in);
	    try {
	        System.out.println("Digite o nome da loja: ");
	        String nome = scan.nextLine();

	        boolean lojaEncontrada = false;
	        for (Loja loja : lojas) {
	            if (loja.getNome().equalsIgnoreCase(nome)) {
	                lojaEncontrada = true;
	                System.out.println("Loja encontrada: ");
	                System.out.println(loja);
	                System.out.println("______________________________________");
	                System.out.println("O que deseja alterar?");
	                System.out.println("1. Nome");
	                System.out.println("2. Endereço");
	                System.out.println("3. Telefone");
	                System.out.println("4. Sair");

	                int opcao = scan.nextInt();
	                scan.nextLine();

	                switch (opcao) {
	                    case 1:
	                        System.out.println("Digite o novo nome da loja: ");
	                        String novaLoja = scan.nextLine();
	                        loja.setNome(novaLoja);
	                        break;
	                    case 2:
	                        System.out.println("Digite o novo endereço da loja: ");
	                        String novoEndereco = scan.nextLine();
	                        loja.setEndereco(novoEndereco);
	                        break;
	                    case 3:
	                        System.out.println("Digite o novo telefone da loja: ");
	                        String novoTelefone = scan.nextLine();
	                        loja.setTelefone(novoTelefone);
	                        break;

	                    case 4:
	                        exibirManutencaoCadastro();
	                        break;
	                    default:
	                        System.out.println("Opção inválida. Tente novamente.");
	                        break;
	                }

	                System.out.println("Loja alterada com sucesso: ");
	                System.out.println(loja);
	                exibirManutencaoCadastro();
	                break;
	            }
	        }

	        if (!lojaEncontrada) {
	            System.out.println("Loja não encontrada, tente novamente.");
	            exibirManutencaoCadastro(); 
	        }

	    } catch (Exception erro) {
	        System.out.println("Erro ao alterar dados da Loja, tente novamente: ");
	    } finally {
	        scan.close();
	    }
	}


	// metodo para Listar loja
	public void listarLoja() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome da Loja: ");
		String nome = scan.nextLine();

		for (Loja loja : lojas) {
			if (loja.getNome().equalsIgnoreCase(nome)) {
				System.out.println("Veículo encontrado: ");
				System.out.println(loja);
				return;
			}
		}

		System.out.println("Loja não encontrada.");
	

	}

	// metodo para excluir veiculo por placa
	public void excluirLoja() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a placa do veículo que deseja excluir: ");
		String nome = scan.nextLine();

		boolean encontrado = false;
		for (Loja loja : lojas) {
			if (loja.getNome().equalsIgnoreCase(nome)) {
				lojas.remove(loja);
				System.out.println("Loja removida com sucesso.");
				exibirManutencaoCadastro();
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println(
					"Loja não encontrada para exclusão, a mesma " + "não existe em nosso sistema, tente novamente!\"");

		}
	}

}
