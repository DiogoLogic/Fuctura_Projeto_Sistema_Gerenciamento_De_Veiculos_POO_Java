package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Venda {

    private Veiculo veiculoVendido;
    private Vendedor vendedorResponsavel;
    private Cliente clienteComprador;
    private Date dataVenda;

    public Venda(Veiculo veiculoVendido, Vendedor vendedorResponsavel, Cliente clienteComprador, Date dataVenda) {
        this.veiculoVendido = veiculoVendido;
        this.vendedorResponsavel = vendedorResponsavel;
        this.clienteComprador = clienteComprador;
        this.dataVenda = dataVenda;
    }

    // Getters e setters
    public Veiculo getVeiculoVendido() {
        return veiculoVendido;
    }

    public void setVeiculoVendido(Veiculo veiculoVendido) {
        this.veiculoVendido = veiculoVendido;
    }

    public Vendedor getVendedorResponsavel() {
        return vendedorResponsavel;
    }

    public void setVendedorResponsavel(Vendedor vendedorResponsavel) {
        this.vendedorResponsavel = vendedorResponsavel;
    }

    public Cliente getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(Cliente clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", new Locale.Builder().setLanguage("pt").setRegion("BR").build());
        String dataFormatada = dateFormat.format(dataVenda);

        return "Venda " +
                "\nveiculo Vendido: " + veiculoVendido +
                ", \nvendedor Responsavel: " + vendedorResponsavel +
                ", \ncliente Comprador: " + clienteComprador +
                ", \ndata da Venda: " + dataFormatada;
    }
}

