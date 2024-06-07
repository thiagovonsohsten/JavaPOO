package br.edu.cesarschool.cc.poo.ac.utils;


public class ValidadorCPF {

    
    private ValidadorCPF() {
    }

    
    public static boolean isCpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        int[] pesos = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            int numero = (cpf.charAt(i) - '0');
            soma += numero * pesos[i];
        }

        int resultado = 11 - (soma % 11);
        int digito1 = (resultado == 10 || resultado == 11) ? 0 : resultado;

        pesos = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        soma = 0;
        for (int i = 0; i < 10; i++) {
            int numero = (cpf.charAt(i) - '0');
            soma += numero * pesos[i];
        }

        resultado = 11 - (soma % 11);
        int digito2 = (resultado == 10 || resultado == 11) ? 0 : resultado;

        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }
}
