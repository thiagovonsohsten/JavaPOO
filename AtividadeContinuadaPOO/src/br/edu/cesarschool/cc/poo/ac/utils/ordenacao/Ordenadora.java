package br.edu.cesarschool.cc.poo.ac.utils.ordenacao;

public class Ordenadora {

    public static void ordenar(Object[] lista, Comparador comp) {
        int n = lista.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comp.comparar(lista[j], lista[j + 1]) > 0) {
                    Object temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

    public static void ordenar(Comparavel[] lista) {
        ordenar(lista, new Comparador() {
            public int comparar(Object o1, Object o2) {
                return ((Comparavel) o1).comparar(o2);
            }
        });
    }
}
