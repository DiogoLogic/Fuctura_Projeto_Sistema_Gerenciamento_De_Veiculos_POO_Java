package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Vendedor;
import view.MenuManutencaoNoCadastro;
	
	public class GerenciadorDeVendedor extends MenuManutencaoNoCadastro{
		private static List<Vendedor> vendedor = new ArrayList<>();

		// metodo para cadastrar veiculos
		public void cadastrarVendedor() {
			Scanner scan = new Scanner(System.in);

			try {

				System.out.println("Digite o nome do vendor: ");
				String nome = scan.nextLine();

				System.out.println("Digite o CPF do vendedor: ");
				String cpf = scan.nextLine();

				System.out.println("Digite o telefone do vendedor ");
				String telefone = scan.nextLine();

				Vendedor dadosVendedor = new Vendedor(nome, cpf, telefone);
				vendedor.add(dadosVendedor);

				int tamanho = vendedor.size();
				if (tamanho == 1) {

					System.out.println("Vendedor cadastrado com sucesso!" + tamanho);
					exibirManutencaoCadastro();

				}

			} catch (Exception erro) {
				System.out.println("Erro ao cadastrar vendedor, tente novamente: ");
			} finally {
				cadastrarVendedor();
				scan.close();
			}
			
		}

		// Método para alterar dados do vendedor
		public void alterarDadosVendedor() {
		    Scanner scan = new Scanner(System.in);
		    try {
		        System.out.println("Digite o nome do vendedor: ");
		        String nome = scan.nextLine();

		        boolean vendedorEncontrado = false;
		        for (Vendedor vendedor : vendedor) {
		            if (vendedor.getNome().equalsIgnoreCase(nome)) {
		                vendedorEncontrado = true;
		                System.out.println("Vendedor encontrado: ");
		                System.out.println(vendedor);
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
		                        System.out.println("Digite o novo nome do vendedor ");
		                        String novoVendedor = scan.nextLine();
		                        vendedor.setNome(novoVendedor);
		                        break;
		                    case 2:
		                        System.out.println("Digite o novo CPF do vendedor: ");
		                        String novoCpf = scan.nextLine();
		                        vendedor.setCpf(novoCpf);
		                        break;
		                    case 3:
		                        System.out.println("Digite o novo telefone do vendedor: ");
		                        String novoTelefone = scan.nextLine();
		                        vendedor.setTelefone(novoTelefone);
		                        break;
		                        
		                    case 4:
		                    	exibirManutencaoCadastro();
		                        break;
		                    default:
		                        System.out.println("Opção inválida. Tente novamente.");
		                        break;
		                }

		                System.out.println("Loja alterada com sucesso: ");
		                System.out.println(vendedor);
		                exibirManutencaoCadastro();
		                break; 
		            }
		        }

		        if (!vendedorEncontrado) {
		            System.out.println("Vendedor não encontrado.");
		            exibirManutencaoCadastro(); 
		        }

		    } catch (Exception erro) {
		        System.out.println("Erro ao alterar dados do vendedor, tente novamente: ");
		    } finally {
		    	alterarDadosVendedor();
		        scan.close();
		    }
		}

		

		// metodo para Listar loja
		public void listarVendedor() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o nome do vendedor: ");
			String nome = scan.nextLine();

			for (Vendedor vendedor : vendedor) {
				if (vendedor.getNome().equalsIgnoreCase(nome)) {
					System.out.println("Veículo encontrado: ");
					System.out.println(vendedor);
					return;
				}
			}

			System.out.println("Vendedor não encontrado.");
			System.out.println("Por favor, ir até o menu manutenção de cadastro");

		}

		// metodo para excluir veiculo por placa
		public void excluirVendedor() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Digite o nome do vendedor que deseja excluir: ");
			String nome = scan.nextLine();

			boolean encontrado = false;
			for (Vendedor vendedorDados : vendedor) {
				if (vendedorDados.getNome().equalsIgnoreCase(nome)) {
					vendedor.remove(vendedorDados);
					System.out.println("Vendedor removido com sucesso.");
					exibirManutencaoCadastro();
					encontrado = true;
					break;
				}
			}

			if (!encontrado) {
				System.out.println("Vendedor não encontrado para exclusão, o mesmo "
						+ "não existe em nosso sistema, tente novamente!\"");

			}
		}

	}
