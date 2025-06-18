public abstract class Investimento {
    private Cliente cliente;
    private double saldo;

    public Investimento(Cliente cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void aplicar(double valor) {
        if (valor > 0) {
            this.saldo+= valor;
        }
    }

    public boolean resgatar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public double getSaldoAtual() {
        return this.saldo;
    }

    public abstract double calcularSaldoProjetado(int numeroMeses);

    public abstract void simularPassagemDeMes();
}
