public class FundoInvestimento extends Investimento {
    private String nomeFundo;
    private String cnpjGestora;
    private double taxaAdministracaoAnual;

    public FundoInvestimento(Cliente cliente, double saldo, String nomeFundo, String cnpjGestora, double taxaAdministracaoAnual) {
        super(cliente, saldo);
        this.nomeFundo = nomeFundo;
        this.cnpjGestora = cnpjGestora;
        this.taxaAdministracaoAnual = taxaAdministracaoAnual;
    }

    public String getNomeFundo() {
        return nomeFundo;
    }

    public void setNomeFundo(String nomeFundo) {
        this.nomeFundo = nomeFundo;
    }

    public String getCnpjGestora() {
        return cnpjGestora;
    }

    public void setCnpjGestora(String cnpjGestora) {
        this.cnpjGestora = cnpjGestora;
    }

    public double getTaxaAdministracaoAnual() {
        return taxaAdministracaoAnual;
    }

    public void setTaxaAdministracaoAnual(double taxaAdministracaoAnual) {
        this.taxaAdministracaoAnual = taxaAdministracaoAnual;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldoProjetado = getSaldo();
        double taxaAdministracaoMensal = taxaAdministracaoAnual / 12.0;

        for (int i = 0; i < numeroMeses; i++) {
            saldoProjetado *= 1.01;
            double taxaAdmDoMes = saldoProjetado * taxaAdministracaoMensal;
            saldoProjetado -= taxaAdmDoMes;
        }

        return saldoProjetado;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimentoBruto = this.getSaldo() * 0.01;
        double taxaAdmDevida = this.getSaldo() * (this.taxaAdministracaoAnual / 12.0);
        double novoSaldo = this.getSaldo() + rendimentoBruto - taxaAdmDevida;
        if (novoSaldo < 0) {
            novoSaldo = 0;
        }
        this.setSaldo(novoSaldo);
    }
}