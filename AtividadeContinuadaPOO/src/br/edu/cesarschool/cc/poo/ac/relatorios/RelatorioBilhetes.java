package br.edu.cesarschool.cc.poo.ac.relatorios;

import java.time.format.DateTimeFormatter;

import br.edu.cesarschool.cc.poo.ac.passagem.Bilhete;
import br.edu.cesarschool.cc.poo.ac.passagem.BilheteMediator;

public class RelatorioBilhetes {

    public static void gerarRelatorioBilhetesPorPreco() {
        BilheteMediator bilheteMediator = BilheteMediator.obterInstancia();
        Bilhete[] bilhetes = bilheteMediator.obterBilhetesPorPreco();

        System.out.println("PRECO, AEROPORTO_ORIGEM, AEROPORTO_DESTINO, DATA_HORA");
        for (Bilhete bilhete : bilhetes) {
            System.out.println(bilhete.toString());
        }
    }

    public static void gerarRelatorioBilhetesPorDH(double precoMin) {
        BilheteMediator bilheteMediator = BilheteMediator.obterInstancia();
        Bilhete[] bilhetes = bilheteMediator.obterBilhetesPorDataHora(precoMin);

        System.out.println("DATA_HORA, AEROPORTO_ORIGEM, AEROPORTO_DESTINO");
        for (Bilhete bilhete : bilhetes) {
            System.out.printf("%s, %s, %s%n",
                bilhete.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
                bilhete.getVoo().getAeroportoOrigem(),
                bilhete.getVoo().getAeroportoDestino()
            );
        }
    }
}
