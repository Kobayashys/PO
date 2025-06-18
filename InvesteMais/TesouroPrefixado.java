public class TesouroPrefixado extends Investimento {
    private String nomeTitulo;
    private double taxaJurosAnual;
    private double percentualIR;

    public TesouroPrefixado(Cliente cliente, double saldo, String nomeTitulo, double taxaJurosAnual, double percentualIR) {
        super(cliente, saldo);
        if(!(cliente instanceof PessoaFisica)) {
            throw new IllegalArgumentException("O cliente deve ser uma instância de PessoaFisica.");
        }
        this.nomeTitulo = nomeTitulo;
        this.taxaJurosAnual = taxaJurosAnual;
        this.percentualIR = percentualIR;
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getPercentualIR() {
        return percentualIR;
    }

    public void setPercentualIR(double percentualIR) {
        this.percentualIR = percentualIR;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldo = getSaldo();
        double taxaJurosMensal = taxaJurosAnual / 12;
        double saldoBruto = saldo * Math.pow((1 + taxaJurosMensal), numeroMeses);
        double rendimento = saldoBruto - saldo;
        double imposto = rendimento * percentualIR;
        return saldoBruto - imposto;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimento = this.getSaldo() * (this.taxaJurosAnual / 12.0);
        this.setSaldo(this.getSaldo() + rendimento);
    }
}