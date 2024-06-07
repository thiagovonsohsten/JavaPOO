package br.edu.cesarschool.cc.poo.ac.negocio.comparadores;

import br.edu.cesarschool.cc.poo.ac.utils.ordenacao.Comparador;
import br.edu.cesarschool.cc.poo.ac.passagem.Bilhete;
import java.time.LocalDateTime;

public class ComparadorBilheteDataHora implements Comparador {

    @Override
    public int comparar(Object o1, Object o2) {
        Bilhete b1 = (Bilhete) o1;
        Bilhete b2 = (Bilhete) o2;
        return b2.getDataHora().compareTo(b1.getDataHora()); // Descending order
    }
}
