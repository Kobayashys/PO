public class Conta {
    private String titular;
    private double saldo;
    private String numeroConta;

    public Conta(String titular, double saldoInicial, String numeroConta) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.numeroConta = numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        } else {
            System.out.println("Transferência não realizada.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}