public class Principal {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("Joao", 1000.0,500.0 );
        ContaEspecial contaEspecial = new ContaEspecial("Maria", 2000.0, "12345", 5.0);

        System.out.println("Titular da conta corrente: " + contaCorrente.getTitular());
        System.out.println("Saldo da conta corrente: R$" + contaCorrente.getSaldo());
        System.out.println("Limite da conta corrente: R$" + contaCorrente.getLimite());

        System.out.println("\nTitular da conta especial: " + contaEspecial.getTitular());
        System.out.println("Saldo da conta especial: R$" + contaEspecial.getSaldo());
        System.out.println("Número da conta especial: " + contaEspecial.getNumeroConta());
        System.out.println("Taxa de juros da conta especial: " + contaEspecial.getTaxaJuros() + "%");

        // Testando operações
        contaCorrente.depositar(200.0);
        System.out.println("\nApós depósito, saldo da conta corrente: R$" + contaCorrente.getSaldo());

        if (contaCorrente.sacar(300.0)) {
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saque não realizado.");
        }
        System.out.println("Saldo após saque: R$" + contaCorrente.getSaldo());

        // Testando transferência
        if (contaCorrente.transferir(contaEspecial, 500.0)) {
            System.out.println("\nTransferência realizada com sucesso.");
            System.out.println("Novo saldo da conta corrente: R$" + contaCorrente.getSaldo());
            System.out.println("Novo saldo da conta especial: R$" + contaEspecial.getSaldo());
        } else {
            System.out.println("\nTransferência não realizada.");
        }

        // Testando rendimento e empréstimo
        contaEspecial.aplicarRendimento();
        System.out.println("\nApós aplicar rendimento, saldo da conta especial: R$" + contaEspecial.getSaldo());

        contaEspecial.emprestimo(5000.0, 10, 15);
    }
}
