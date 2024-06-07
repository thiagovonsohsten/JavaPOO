package br.edu.cesarschool.cc.poo.ac.cliente;

import java.util.Scanner;

public class TelaCliente {
    private final ClienteMediator clienteMediator;

    public TelaCliente() {
        this.clienteMediator = ClienteMediator.obterInstancia();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal - Gestão de Clientes");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (opcao) {
                case 1:
                    incluirCliente(scanner);
                    break;
                case 2:
                    alterarCliente(scanner);
                    break;
                case 3:
                    excluirCliente(scanner);
                    break;
                case 4:
                    buscarCliente(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

    private void incluirCliente(Scanner scanner) {
        System.out.println("Incluir novo cliente:");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Saldo de Pontos: ");
        double saldoPontos = scanner.nextDouble();

        Cliente cliente = new Cliente(cpf, nome, saldoPontos);
        String resultado = clienteMediator.incluir(cliente);

        if (resultado == null) {
            System.out.println("Cliente incluído com sucesso.");
        } else {
            System.out.println(resultado);
        }
    }

    private void alterarCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente a ser alterado: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteMediator.buscar(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo saldo de pontos: ");
            double saldoPontos = scanner.nextDouble();

            Cliente clienteAlterado = new Cliente(cpf, nome, saldoPontos);
            String resultado = clienteMediator.alterar(clienteAlterado);

            if (resultado == null) {
                System.out.println("Cliente alterado com sucesso.");
            } else {
                System.out.println(resultado);
            }
        }
    }

    private void excluirCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente a ser excluído: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteMediator.buscar(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            String resultado = clienteMediator.excluir(cpf);
            if (resultado == null) {
                System.out.println("Cliente excluído com sucesso.");
            } else {
                System.out.println(resultado);
            }
        }
    }

    private void buscarCliente(Scanner scanner) {
        System.out.print("Digite o CPF do cliente a ser buscado: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteMediator.buscar(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println("Cliente encontrado: ");
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Saldo de Pontos: " + cliente.getSaldoPontos());
        }
    }

    public static void main(String[] args) {
        TelaCliente telaCliente = new TelaCliente();
        telaCliente.exibirMenu();
    }
}