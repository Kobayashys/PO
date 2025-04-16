import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static ArrayList<Conta> contas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Exibir saldo/extrato");
            System.out.println("3. Sacar valor");
            System.out.println("4. Depositar valor");
            System.out.println("5. Transferir valores");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    exibirExtrato();
                    break;
                case 3:
                    sacarValor();
                    break;
                case 4:
                    depositarValor();
                    break;
                case 5:
                    transferirValor();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private static void criarConta() {
        System.out.print("Nome do titular: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do titular: ");
        String cpf = scanner.nextLine();
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        contas.add(new Conta(numero, new Pessoa(nome, cpf)));
        System.out.println("Conta criada com sucesso!");
    }

    private static void exibirExtrato() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                System.out.println("Número da conta: " + conta.getNumero());
                System.out.println("Nome do titular: " + conta.getTitular().getNome());
                System.out.println("Saldo: R$ " + conta.getSaldo());
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    private static void sacarValor() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Valor a sacar: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                if (conta.sacar(valor)) {
                    System.out.println("Saque efetuado com sucesso!");
                } else {
                    System.out.println("Saque não efetuado, saldo insuficiente.");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    private static void depositarValor() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Valor a depositar: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                conta.depositar(valor);
                System.out.println("Depósito efetuado com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    private static void transferirValor() {
        System.out.print("Número da conta de origem: ");
        int origem = scanner.nextInt();
        System.out.print("Número da conta de destino: ");
        int destino = scanner.nextInt();
        System.out.print("Valor a transferir: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar buffer

        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Conta conta : contas) {
            if (conta.getNumero() == origem) {
                contaOrigem = conta;
            }
            if (conta.getNumero() == destino) {
                contaDestino = conta;
            }
        }

        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.transferir(contaDestino, valor)) {
                System.out.println("Transferência efetuada com sucesso!");
            } else {
                System.out.println("Transferência não efetuada, saldo insuficiente.");
            }
        } else {
            System.out.println("Conta origem ou destino não encontrada!");
        }
    }
}