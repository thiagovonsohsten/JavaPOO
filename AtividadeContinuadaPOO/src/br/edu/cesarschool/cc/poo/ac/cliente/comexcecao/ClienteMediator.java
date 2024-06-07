package br.edu.cesarschool.cc.poo.ac.cliente.comexcecao;

import br.edu.cesarschool.cc.poo.ac.cliente.Cliente;
import br.edu.cesarschool.cc.poo.ac.utils.StringUtils;
import br.edu.cesarschool.cc.poo.ac.utils.ValidadorCPF;
import br.edu.cesarschool.cc.poo.ac.utils.ordenacao.Ordenadora;

public class ClienteMediator {
    private static ClienteMediator instancia;
    private ClienteDAO clienteDao = new ClienteDAO();

    private ClienteMediator() {
    }

    public static synchronized ClienteMediator obterInstancia() {
        if (instancia == null) {
            instancia = new ClienteMediator();
        }
        return instancia;
    }

    public void validar(Cliente cliente) throws ExcecaoValidacao {
        ExcecaoValidacao excecaoValidacao = new ExcecaoValidacao();
        
        if (!ValidadorCPF.isCpfValido(cliente.getCpf())) {
            excecaoValidacao.adicionarMensagem("CPF errado");
        }
        if (StringUtils.isVaziaOuNula(cliente.getNome()) || cliente.getNome().length() < 2) {
            excecaoValidacao.adicionarMensagem("Nome errado");
        }
        if (cliente.getSaldoPontos() < 0) {
            excecaoValidacao.adicionarMensagem("Saldo errado");
        }

        if (!excecaoValidacao.getMensagens().isEmpty()) {
            throw excecaoValidacao;
        }
    }

    public Cliente buscar(String cpf) throws ExcecaoRegistroInexistente {
        return clienteDao.buscar(cpf);
    }

    public void incluir(Cliente cliente) throws ExcecaoRegistroJaExistente, ExcecaoValidacao {
        validar(cliente);
        clienteDao.incluir(cliente);
    }

    public void alterar(Cliente cliente) throws ExcecaoRegistroInexistente, ExcecaoValidacao {
        validar(cliente);
        clienteDao.alterar(cliente);
    }

    public void excluir(String cpf) throws ExcecaoRegistroInexistente, ExcecaoValidacao {
        if (!ValidadorCPF.isCpfValido(cpf)) {
            ExcecaoValidacao excecaoValidacao = new ExcecaoValidacao();
            excecaoValidacao.adicionarMensagem("CPF errado");
            throw excecaoValidacao;
        }
        clienteDao.excluir(cpf);
    }

    public Cliente[] obterClientesPorNome() {
        Cliente[] clientes = clienteDao.buscarTodos();
        Ordenadora.ordenar(clientes);
        return clientes;
    }
}
