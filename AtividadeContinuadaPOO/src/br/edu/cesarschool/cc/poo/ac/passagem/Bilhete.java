package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.Registro;
import br.edu.cesarschool.cc.poo.ac.cliente.Cliente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bilhete extends Registro {
    private Cliente cliente;
    private Voo voo;
    private double preco;
    private double pagamentoEmPontos;
    private LocalDateTime dataHora;

    public Bilhete(Cliente cliente, Voo voo, double preco, double pagamentoEmPontos, LocalDateTime dataHora) {
        super(); 
        this.cliente = cliente;
        this.voo = voo;
        this.preco = preco;
        this.pagamentoEmPontos = pagamentoEmPontos;
        this.dataHora = dataHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Voo getVoo() {
        return voo;
    }

    public double getPreco() {
        return preco;
    }

    public double getPagamentoEmPontos() {
        return pagamentoEmPontos;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setPagamentoEmPontos(double pagamentoEmPontos) {
        this.pagamentoEmPontos = pagamentoEmPontos;
    }

    public double obterValorPago() {
        return this.preco - this.pagamentoEmPontos;
    }

    public double obterValorPontuacao() {
        return obterValorPago() / 20;
    }

    public String gerarNumero() {
        String cpfCliente = cliente.getCpf();
        int numeroVoo = voo.getNumeroVoo();
        int ano = dataHora.getYear();
        int mes = dataHora.getMonthValue();
        int dia = dataHora.getDayOfMonth();
        String numeroConcatenado = cpfCliente + numeroVoo + ano + mes + dia;
        return numeroConcatenado;
    }

    @Override
    public String getIdUnico() {
        return gerarNumero();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Bilhete{" +
                "cliente=" + cliente.getNome() +
                ", cpfCliente='" + cliente.getCpf() + '\'' +
                ", numeroVoo='" + voo.getNumeroVoo() + '\'' +
                ", dataHora='" + dataHora.format(formatter) + '\'' +
                ", preco=" + preco +
                ", pagamentoEmPontos=" + pagamentoEmPontos +
                '}';
    }
}
