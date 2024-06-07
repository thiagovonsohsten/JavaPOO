package br.edu.cesarschool.cc.poo.ac.cliente;

import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class ClienteDAO extends SuperDAO {
    
    public ClienteDAO() {
        super();
    }

    @Override
    public Class<?> obterTipo() {
        return Cliente.class;
    }

    public Cliente buscar(String cpf) {
        return (Cliente) daoGenerico.buscar(cpf);
    }

    public boolean incluir(Cliente cliente) {
        return daoGenerico.incluir(cliente);
    }

    public boolean alterar(Cliente cliente) {
        return daoGenerico.alterar(cliente);
    }

    public boolean excluir(String cpf) {
        return daoGenerico.excluir(cpf);
    }

	public Cliente[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}