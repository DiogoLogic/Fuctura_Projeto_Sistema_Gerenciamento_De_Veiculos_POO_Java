package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Veiculo;
import model.Venda;
import model.Vendedor;
import view.MenuManutencaoNoCadastro;

public class GerenciadorDeVenda extends MenuManutencaoNoCadastro {

    private static List<Venda> vendas = new ArrayList<>();

    // método para cadastrar venda
    public void cadastrarVenda() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Digite a placa do veículo vendido: ");
            String placa = scan.nextLine();

            System.out.println("Digite o nome do vendedor responsável: ");
            String nomeVendedor = scan.nextLine();

            System.out.println("Digite o CPF do vendedor responsável: ");
            String cpfVendedor = scan.nextLine();

            System.out.println("Digite o telefone do vendedor responsável: ");
            String telefoneVendedor = scan.nextLine();

            System.out.println("Digite o nome do cliente comprador: ");
            String nomeCliente = scan.nextLine();

            System.out.println("Digite o CPF do cliente comprador: ");
            String cpfCliente = scan.nextLine();
            
            System.out.println("Digite o telefone do cliente comprador: ");
            String telefoneCliente = scan.nextLine();

            System.out.println("Digite a data da venda (dd/mm/aaaa): ");
            String dataString = scan.nextLine();
            Date dataVenda = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);

            Veiculo veiculoVendido = new Veiculo(placa, "", "", "", "", "", 0.0); 
            Vendedor vendedorResponsavel = new Vendedor(nomeVendedor, cpfVendedor, telefoneVendedor);
            Cliente clienteComprador = new Cliente(nomeCliente, cpfCliente, telefoneCliente); 
            Venda venda = new Venda(veiculoVendido, vendedorResponsavel, clienteComprador, dataVenda);

            vendas.add(venda);

            System.out.println("Venda cadastrada com sucesso!");
            listarVendas();
            cadastrarVenda();

        } catch (Exception erro) {
            System.out.println("Erro ao cadastrar venda, tente novamente: ");
        } finally {
        	cadastrarVenda();
            scan.close();
        }
    }

    // método para alterar dados da venda
    public void alterarDadosVenda() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Digite a placa do veículo vendido da venda que deseja alterar: ");
            String placa = scan.nextLine();

            boolean vendaEncontrada = false;
            for (Venda venda : vendas) {
                if (venda.getVeiculoVendido().getPlaca().equalsIgnoreCase(placa)) {
                    vendaEncontrada = true;
                    System.out.println("Venda encontrada: ");
                    System.out.println(venda);
                    System.out.println("______________________________________");
                    System.out.println("O que deseja alterar?");
                    System.out.println("1. Veículo vendido");
                    System.out.println("2. Vendedor responsável");
                    System.out.println("3. Cliente comprador");
                    System.out.println("4. Data da venda");
                    System.out.println("5. Sair");

                    int opcao = scan.nextInt();
                    scan.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite a nova placa do veículo vendido: ");
                            String novaPlaca = scan.nextLine();
                            venda.getVeiculoVendido().setPlaca(novaPlaca);
                            break;
                        case 2:
                            System.out.println("Digite o novo nome do vendedor responsável: ");
                            String novoNomeVendedor = scan.nextLine();
                            venda.getVendedorResponsavel().setNome(novoNomeVendedor);
                            break;
                        case 3:
                            System.out.println("Digite o novo nome do cliente comprador: ");
                            String novoNomeCliente = scan.nextLine();
                            venda.getClienteComprador().setNome(novoNomeCliente);
                            break;
                        case 4:
                            System.out.println("Digite a nova data da venda (dd/mm/aaaa): ");
                            String novaDataString = scan.nextLine();
                            Date novaDataVenda = new SimpleDateFormat("dd/MM/yyyy").parse(novaDataString);
                            venda.setDataVenda(novaDataVenda);
                            break;
                        case 5:
                            exibirManutencaoCadastro();
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                            break;
                    }

                    System.out.println("Venda alterada com sucesso: ");
                    System.out.println(venda);
                    exibirManutencaoCadastro();
                    break;
                }
            }

            if (!vendaEncontrada) {
                System.out.println("Venda não encontrada.");
                exibirManutencaoCadastro(); 
            }

        } catch (Exception erro) {
            System.out.println("Erro ao alterar dados da venda, tente novamente: ");
        } finally {
            scan.close();
        }
    }

    // método para listar vendas
    public void listarVendas() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a placa do veículo vendido da venda que deseja listar: ");
        String placa = scan.nextLine();

        for (Venda venda : vendas) {
            if (venda.getVeiculoVendido().getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Venda de veiculo encontrada: ");
                System.out.println(venda);
                return;
            }
        }

        System.out.println("Venda não encontrada.");
        System.out.println("Por favor, ir até o menu manutenção de cadastro");
    }

    // método para excluir venda
    public void excluirVenda() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a placa do veículo vendido da venda que deseja excluir: ");
        String placa = scan.nextLine();

        boolean encontrada = false;
        for (Venda venda : vendas) {
            if (venda.getVeiculoVendido().getPlaca().equalsIgnoreCase(placa)) {
                vendas.remove(venda);
                System.out.println("Venda removida com sucesso.");
                exibirManutencaoCadastro();
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Venda não encontrada para exclusão.");
        }
    }

}
