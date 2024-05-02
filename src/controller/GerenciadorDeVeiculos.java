package controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import model.Veiculo;
import view.MenuManutencaoNoCadastro;

public class GerenciadorDeVeiculos extends MenuManutencaoNoCadastro {

	public static List<Veiculo> veiculos = new ArrayList<>();

	// metodo para cadastrar veiculos
	public void cadastrarVeiculo() {
		Scanner scan = new Scanner(System.in);

		try {

			System.out.println("Digite a placa do veiculo: ");
			String placa = scan.nextLine();

			System.out.println("Digite a marca do veiculo: ");
			String marca = scan.nextLine();

			System.out.println("Digite o modelo do veiculo: ");
			String modelo = scan.nextLine();

			System.out.println("Digite o ano do veiculo: ");
			String ano = scan.nextLine();

			System.out.println("Digite a categoria do veículo: ");
			String categoria = scan.nextLine();

			System.out.println("Digite a descrição do veículo: ");
			String descricao = scan.nextLine();

			System.out.println("Digite o preço do veículo: ");
			double preco = scan.nextDouble();

			Veiculo veiculo = new Veiculo(placa, marca, modelo, ano, categoria, descricao, preco);
			veiculos.add(veiculo);

			int tamanho = veiculos.size();
			if (tamanho == 1) {

				System.out.println("Veiculo cadastrado com sucesso!" + tamanho);
				exibirManutencaoCadastro();

			}

		} catch (Exception erro) {
			System.out.println("Erro ao cadastrar veículo, tente novamente: ");
		} finally {
			cadastrarVeiculo();
			scan.close();
		}
		// cadastrarVeiculo();
	}

	// Método para alterar dados do veículo
	public void alterarDadosVeiculo() {
	    Scanner scan = new Scanner(System.in);
	    try {
	        System.out.println("Digite a placa do veículo que deseja alterar: ");
	        String placa = scan.nextLine();

	        boolean veiculoEncontrado = false;
	        for (Veiculo veiculo : veiculos) {
	            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
	                veiculoEncontrado = true;
	                System.out.println("Veículo encontrado: ");
	                System.out.println(veiculo);
	                System.out.println("______________________________________");
	                System.out.println("O que deseja alterar?");
	                System.out.println("1. Placa");
	                System.out.println("2. Marca");
	                System.out.println("3. Modelo");
	                System.out.println("4. Ano");
	                System.out.println("5. Categoria");
	                System.out.println("6. Descrição");
	                System.out.println("7. Preço");
	                System.out.println("8. Sair");

	                int opcao = scan.nextInt();
	                scan.nextLine();

	                switch (opcao) {
	                    case 1:
	                        System.out.println("Digite a nova placa: ");
	                        String novaPlaca = scan.nextLine();
	                        veiculo.setPlaca(novaPlaca);
	                        break;
	                    case 2:
	                        System.out.println("Digite a nova marca: ");
	                        String novaMarca = scan.nextLine();
	                        veiculo.setMarca(novaMarca);
	                        break;
	                    case 3:
	                        System.out.println("Digite o novo modelo: ");
	                        String novoModelo = scan.nextLine();
	                        veiculo.setModelo(novoModelo);
	                        break;
	                    case 4:
	                        System.out.println("Digite o novo ano: ");
	                        String novoAno = scan.nextLine();
	                        veiculo.setAno(novoAno);
	                        break;
	                    case 5:
	                        System.out.println("Digite a nova categoria: ");
	                        String novaCategoria = scan.nextLine();
	                        veiculo.setCategoria(novaCategoria);
	                        break;
	                    case 6:
	                        System.out.println("Digite a nova descrição: ");
	                        String novaDescricao = scan.nextLine();
	                        veiculo.setDescricao(novaDescricao);
	                        break;
	                    case 7:
	                        System.out.println("Digite o novo preço: ");
	                        double novoPreco = scan.nextDouble();
	                        veiculo.setPreco(novoPreco);
	                        break;
	                    case 8:
	                        exibirManutencaoCadastro();
	                        break;
	                    default:
	                        System.out.println("Opção inválida. Tente novamente.");
	                        break;
	                }

	                System.out.println("Veículo alterado com sucesso: ");
	                System.out.println(veiculo);
	                exibirManutencaoCadastro();
	                break;
	            }
	        }

	        if (!veiculoEncontrado) {
	            System.out.println("Veículo não encontrado.");
	            exibirManutencaoCadastro(); 
	            
	        }

	    } catch (Exception erro) {
	        System.out.println("Erro ao alterar dados do veículo, tente novamente: ");
	    } finally {
	        alterarDadosVeiculo();
	        scan.close();
	    }
	}


	// metodo para consultar veiculo por placa
	public void consultarVeiculoPorPlaca() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a placa do veículo: ");
		String placa = scan.nextLine();

		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
				System.out.println("Veículo encontrado: ");
				System.out.println(veiculo);
				return;
			}
		}

		System.out.println("Veículo não encontrado.");

	}

	// metodo para excluir veiculo por placa
	public void excluirVeiculo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a placa do veículo que deseja excluir: ");
		String placa = scan.nextLine();

		boolean encontrado = false;
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
				veiculos.remove(veiculo);
				System.out.println("Veículo removido com sucesso.");
				exibirManutencaoCadastro();
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("Veículo não encontrado para exclusão, o mesmo "
					+ "não existe em nosso sistema, tente novamente!\"");

		}
	}

}
