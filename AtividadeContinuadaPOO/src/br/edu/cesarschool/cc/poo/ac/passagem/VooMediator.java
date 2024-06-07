package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.StringUtils;
import br.edu.cesarschool.cc.poo.ac.utils.DiaDaSemana;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VooMediator {
    private static VooMediator instancia;
    private VooDAO vooDao = new VooDAO();
    private List<String> aeroportosValidos = Arrays.asList("GRU", "CGH", "GIG", "SDU", "REC", "CWB", "POA", "BSB", "SSA", "FOR", "MAO", "SLZ", "CNF", "BEL", "JPA",
            "PNZ", "CAU", "FEN", "SET", "NAT", "PVH", "BVB", "FLN", "AJU", "PMW", "MCZ", "MCP", "VIX", "GYN", "CGB",
            "CGR", "THE", "RBR", "VCP", "RAO");

    VooMediator() {
        
    }

    public static VooMediator obterInstancia() {
        if (instancia == null) {
            instancia = new VooMediator();
        }
        return instancia;
    }

    public Voo buscar(String IdVoo) {
        return vooDao.buscar(IdVoo);
    }

    public String validarCiaNumero(String companhiaAerea, int numeroVoo) {
        if (StringUtils.isVaziaOuNula(companhiaAerea) || companhiaAerea.length() != 2) {
            return "CIA aerea errada";
        }
        if (numeroVoo <= 0 || numeroVoo < 1000 || numeroVoo > 9999) {
            return "Numero voo errado";
        }
        return null;
    }

    public String validar(Voo voo) {
        String validacaoCiaNumero = validarCiaNumero(voo.getCompanhiaAerea(), voo.getNumeroVoo());
        if (validacaoCiaNumero != null) {
            return validacaoCiaNumero;
        }
        if (StringUtils.isVaziaOuNula(voo.getAeroportoOrigem()) || !aeroportosValidos.contains(voo.getAeroportoOrigem())) {
            return "Aeroporto origem errado";
        }
        if (StringUtils.isVaziaOuNula(voo.getAeroportoDestino()) || !aeroportosValidos.contains(voo.getAeroportoDestino())) {
            return "Aeroporto destino errado";
        }
        if (voo.getAeroportoOrigem().equals(voo.getAeroportoDestino())) {
            return "Aeroporto origem igual a aeroporto destino";
        }
        if (voo.getDiasDaSemana() == null || voo.getDiasDaSemana().length == 0) {
            return "Dias da semana nao informados";
        }
        Set<DiaDaSemana> diasSet = new HashSet<>(Arrays.asList(voo.getDiasDaSemana()));
        if (diasSet.size() != voo.getDiasDaSemana().length) {
            return "Dia da semana repetido";
        }
        if (voo.getHora() == null) {
            return "Hora nao informada";
        }
        if (voo.getHora().getSecond() != 0 || voo.getHora().getNano() != 0) {
            return "Hora invalida";
        }
        return null;
    }

    public String incluir(Voo voo) {
        String validacao = validar(voo);
        if (validacao != null) {
            return validacao;
        }
        boolean incluido = vooDao.incluir(voo);
        if (!incluido) {
            return "Voo ja existente";
        }
        return null;
    }

    public String alterar(Voo voo) {
        String validacao = validar(voo);
        if (validacao != null) {
            return validacao;
        }
        boolean alterado = vooDao.alterar(voo);
        if (!alterado) {
            return "Voo inexistente";
        }
        return null;
    }

    public String excluir(String idVoo) {
        if (StringUtils.isVaziaOuNula(idVoo)) {
            return "Id voo errado";
        }
        boolean excluido = vooDao.excluir(idVoo);
        if (!excluido) {
            return "Voo inexistente";
        }
        return null;
    }
}
