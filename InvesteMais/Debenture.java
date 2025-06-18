public class Debenture extends Investimento {
    private String nomeEmpressaEmissora;
    private double taxaJurosAnualDenbure;
    private double percentualTributacaoPJ;

    public Debenture(Cliente cliente, double saldo, String nomeEmpressaEmissora, double taxaJurosAnualDenbure, double percentualTributacaoPJ) {
        super(cliente, saldo);
        if(!(cliente instanceof PessoaJuridica)) {
            throw new IllegalArgumentException("Debêntures só podem ser adquiridas por pessoas jurídicas.");
        }
        this.nomeEmpressaEmissora = nomeEmpressaEmissora;
        this.taxaJurosAnualDenbure = taxaJurosAnualDenbure;
        this.percentualTributacaoPJ = percentualTributacaoPJ;
    }

    public String getNomeEmpressaEmissora() {
        return nomeEmpressaEmissora;
    }

    public void setNomeEmpressaEmissora(String nomeEmpressaEmissora) {
        this.nomeEmpressaEmissora = nomeEmpressaEmissora;
    }

    public double getTaxaJurosAnualDenbure() {
        return taxaJurosAnualDenbure;
    }

    public void setTaxaJurosAnualDenbure(double taxaJurosAnualDenbure) {
        this.taxaJurosAnualDenbure = taxaJurosAnualDenbure;
    }

    public double getPercentualTributacaoPJ() {
        return percentualTributacaoPJ;
    }

    public void setPercentualTributacaoPJ(double percentualTributacaoPJ) {
        this.percentualTributacaoPJ = percentualTributacaoPJ;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldo = getSaldo();
        double taxaJurosMensal = taxaJurosAnualDenbure / 12;
        double saldoBruto = saldo * Math.pow((1 + taxaJurosMensal), numeroMeses);
        double rendimento = saldoBruto - saldo;
        double imposto = rendimento * percentualTributacaoPJ;
        return saldoBruto - imposto;
    }

    @Override
    public void simularPassagemDeMes() {
        double rendimento = this.getSaldo() * (this.taxaJurosAnualDenbure / 12.0);
        this.setSaldo(this.getSaldo() + rendimento);
    }
}
