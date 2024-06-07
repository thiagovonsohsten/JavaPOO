package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class VooDAO extends SuperDAO {
    
    public VooDAO() {
        super();
    }

    @Override
    public Class<?> obterTipo() {
        return Voo.class;
    }

    public Voo buscar(String idVoo) {
        return (Voo) daoGenerico.buscar(idVoo);
    }

    public boolean incluir(Voo voo) {
        return daoGenerico.incluir(voo);
    }

    public boolean alterar(Voo voo) {
        return daoGenerico.alterar(voo);
    }

    public boolean excluir(String idVoo) {
        return daoGenerico.excluir(idVoo);
    }
}
