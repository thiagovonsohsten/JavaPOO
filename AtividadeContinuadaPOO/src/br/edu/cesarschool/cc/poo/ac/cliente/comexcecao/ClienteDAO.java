package br.edu.cesarschool.cc.poo.ac.cliente.comexcecao;

import br.edu.cesarschool.cc.poo.ac.cliente.Cliente;
import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class ClienteDAO extends SuperDAO {
    
    public ClienteDAO() {
        super();
    }

    @Override
    public Class<?> obterTipo() {
        return Cliente.class;
    }

    public Cliente buscar(String cpf) throws ExcecaoRegistroInexistente {
        Cliente cliente = (Cliente) daoGenerico.buscar(cpf);
        if (cliente == null) {
            throw new ExcecaoRegistroInexistente("Cliente não encontrado para o CPF: " + cpf);
        }
        return cliente;
    }

    public void incluir(Cliente cliente) throws ExcecaoRegistroJaExistente {
        boolean incluido = daoGenerico.incluir(cliente);
        if (!incluido) {
            throw new ExcecaoRegistroJaExistente("Cliente já existente para o CPF: " + cliente.getCpf());
        }
    }

    public void alterar(Cliente cliente) throws ExcecaoRegistroInexistente {
        boolean alterado = daoGenerico.alterar(cliente);
        if (!alterado) {
            throw new ExcecaoRegistroInexistente("Cliente não encontrado para o CPF: " + cliente.getCpf());
        }
    }

    public void excluir(String cpf) throws ExcecaoRegistroInexistente {
        boolean excluido = daoGenerico.excluir(cpf);
        if (!excluido) {
            throw new ExcecaoRegistroInexistente("Cliente não encontrado para o CPF: " + cpf);
        }
    }

    public Cliente[] buscarTodos() {
        return (Cliente[]) daoGenerico.buscarTodos();
    }
}
