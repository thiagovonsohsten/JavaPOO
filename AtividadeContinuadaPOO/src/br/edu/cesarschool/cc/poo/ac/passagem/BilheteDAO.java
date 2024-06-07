package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class BilheteDAO extends SuperDAO {
    
    public BilheteDAO() {
        super();
    }

    @Override
    public Class<?> obterTipo() {
        return Bilhete.class;
    }

    public Bilhete buscar(String numeroBilhete) {
        return (Bilhete) daoGenerico.buscar(numeroBilhete);
    }

    public boolean incluir(Bilhete bilhete) {
        return daoGenerico.incluir(bilhete);
    }

    public boolean alterar(Bilhete bilhete) {
        return daoGenerico.alterar(bilhete);
    }

    public boolean excluir(String numeroBilhete) {
        return daoGenerico.excluir(numeroBilhete);
    }

	public Bilhete[] buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
