package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.SuperDAO;

public class BilheteVipDAO extends SuperDAO {
    
    public BilheteVipDAO() {
        super();
    }

    @Override
    public Class<?> obterTipo() {
        return BilheteVip.class;
    }

    public BilheteVip buscar(String numeroBilhete) {
        return (BilheteVip) daoGenerico.buscar(numeroBilhete);
    }

    public boolean incluir(BilheteVip bilheteVip) {
        return daoGenerico.incluir(bilheteVip);
    }

    public boolean alterar(BilheteVip bilheteVip) {
        return daoGenerico.alterar(bilheteVip);
    }

    public boolean excluir(String numeroBilhete) {
        return daoGenerico.excluir(numeroBilhete);
    }
}
