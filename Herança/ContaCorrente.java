public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String titular, double saldo, double limite) {
        super(titular, saldo, "CC");
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor <= getSaldo() + limite) { // Permite saque dentro do saldo disponível e do limite
            setSaldo(getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficiente, incluindo o limite.");
        return false;
    }
}