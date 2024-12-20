package br.edu.cesarschool.cc.poo.ac.utils;

public abstract class SuperDAO {
    protected DAOGenerico daoGenerico;

    protected SuperDAO() {
        this.daoGenerico = new DAOGenerico(obterTipo());
    }

    public abstract Class<?> obterTipo();
}
