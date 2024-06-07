package br.edu.cesarschool.cc.poo.ac.cliente;

import br.edu.cesarschool.cc.poo.ac.utils.Registro;
import br.edu.cesarschool.cc.poo.ac.utils.ordenacao.Comparavel;

public class Cliente extends Registro implements Comparavel {
    private String cpf;
    private String nome;
    private double saldoPontos;

    public Cliente(String cpf, String nome, double saldoPontos) {
        super(); 
        this.cpf = cpf;
        this.nome = nome;
        this.saldoPontos = saldoPontos;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public double getSaldoPontos() {
        return this.saldoPontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void creditarPontos(double valor) {
        this.saldoPontos += valor;
    }

    public void debitarPontos(double valor) {
        this.saldoPontos -= valor;
    }

    @Override
    public String getIdUnico() {
        return cpf;
    }

    @Override
    public int comparar(Object o) {
        Cliente outroCliente = (Cliente) o;
        return this.nome.compareTo(outroCliente.getNome());
    }

    @Override
    public String toString() {
        return "Cliente{cpf='" + cpf + "', nome='" + nome + "', saldoPontos=" + saldoPontos + "}";
    }
}
