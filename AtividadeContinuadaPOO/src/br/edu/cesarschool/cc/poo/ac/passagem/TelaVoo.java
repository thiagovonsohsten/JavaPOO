package br.edu.cesarschool.cc.poo.ac.passagem;

import br.edu.cesarschool.cc.poo.ac.utils.DiaDaSemana;
import java.time.LocalTime;
import java.util.Scanner;

public class TelaVoo {
    private final VooMediator vooMediator;

    public TelaVoo() {
        this.vooMediator = new VooMediator();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal - Gestão de Voos");
            System.out.println("1. Incluir Voo");
            System.out.println("2. Alterar Voo");
            System.out.println("3. Excluir Voo");
            System.out.println("4. Buscar Voo");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    incluirVoo(scanner);
                    break;
                case 2:
                    alterarVoo(scanner);
                    break;
                case 3:
                    excluirVoo(scanner);
                    break;
                case 4:
                    buscarVoo(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private void incluirVoo(Scanner scanner) {
        System.out.println("Incluir novo voo:");
        System.out.print("Número do Voo: ");
        String numero = scanner.nextLine();
        System.out.print("Origem: ");
        String origem = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Horário (HH:MM): ");
        String horaStr = scanner.nextLine();
        LocalTime hora = LocalTime.parse(horaStr);

        System.out.println("Dias da semana (1-Segunda, 2-Terça, ..., 7-Domingo, separados por vírgula): ");
        String[] diasStr = scanner.nextLine().split(",");
        DiaDaSemana[] diasDaSemana = new DiaDaSemana[diasStr.length];
        for (int i = 0; i < diasStr.length; i++) {
            diasDaSemana[i] = DiaDaSemana.getDiaDaSemana(Integer.parseInt(diasStr[i].trim()));
        }

        Voo voo = new Voo(origem, destino, numero, diasDaSemana, hora);
        String resultado = vooMediator.incluir(voo);

        if (resultado == null) {
            System.out.println("Voo incluído com sucesso.");
        } else {
            System.out.println(resultado);
        }
    }

    private void alterarVoo(Scanner scanner) {
        System.out.print("Digite o número do voo a ser alterado: ");
        String numero = scanner.nextLine();

        Voo voo = vooMediator.buscar(numero);
        if (voo == null) {
            System.out.println("Voo não encontrado.");
        } else {
            System.out.print("Nova origem: ");
            String origem = scanner.nextLine();
            System.out.print("Novo destino: ");
            String destino = scanner.nextLine();
            System.out.print("Novo horário (HH:MM): ");
            String horaStr = scanner.nextLine();
            LocalTime hora = LocalTime.parse(horaStr);

            System.out.println("Novos dias da semana (1-Segunda, 2-Terça, ..., 7-Domingo, separados por vírgula): ");
            String[] diasStr = scanner.nextLine().split(",");
            DiaDaSemana[] diasDaSemana = new DiaDaSemana[diasStr.length];
            for (int i = 0; i < diasStr.length; i++) {
                diasDaSemana[i] = DiaDaSemana.getDiaDaSemana(Integer.parseInt(diasStr[i].trim()));
            }

            Voo vooAlterado = new Voo(origem, destino, voo.getCompanhiaAerea(), voo.getNumeroVoo(), diasDaSemana, hora);
            String resultado = vooMediator.alterar(vooAlterado);

            if (resultado == null) {
                System.out.println("Voo alterado com sucesso.");
            } else {
                System.out.println(resultado);
            }
        }
    }

    private void excluirVoo(Scanner scanner) {
        System.out.print("Digite o número do voo a ser excluído: ");
        String numero = scanner.nextLine();

        Voo voo = vooMediator.buscar(numero);
        if (voo == null) {
            System.out.println("Voo não encontrado.");
        } else {
            String resultado = vooMediator.excluir(numero);
            if (resultado == null) {
                System.out.println("Voo excluído com sucesso.");
            } else {
                System.out.println(resultado);
            }
        }
    }

    private void buscarVoo(Scanner scanner) {
        System.out.print("Digite o número do voo a ser buscado: ");
        String numero = scanner.nextLine();

        Voo voo = vooMediator.buscar(numero);
        if (voo == null) {
            System.out.println("Voo não encontrado.");
        } else {
            System.out.println("Voo encontrado: ");
            System.out.println("Número: " + voo.getNumeroVoo());
            System.out.println("Origem: " + voo.getAeroportoOrigem());
            System.out.println("Destino: " + voo.getAeroportoDestino());
            System.out.println("Horário: " + voo.getHora().toString());
            System.out.print("Dias da semana: ");
            for (DiaDaSemana dia : voo.getDiasDaSemana()) {
                System.out.print(dia.getNome() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TelaVoo telaVoo = new TelaVoo();
        telaVoo.exibirMenu();
    }
}
