public class AcaoBolsa extends Investimento {
    private String codigoAcao;
    private String nomeEmpresa;
    private double taxaCorretagemFixaMensal;

    public AcaoBolsa(Cliente cliente, double saldo, String codigoAcao, String nomeEmpresa, double taxaCorretagemFixaMensal) {
        super(cliente, saldo);
        this.codigoAcao = codigoAcao;
        this.nomeEmpresa = nomeEmpresa;
        this.taxaCorretagemFixaMensal = taxaCorretagemFixaMensal;
    }
    
    public String getCodigoAcao() {
        return codigoAcao;
    }

    public void setCodigoAcao(String codigoAcao) {
        this.codigoAcao = codigoAcao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public double getTaxaCorretagemFixaMensal() {
        return taxaCorretagemFixaMensal;
    }

    public void setTaxaCorretagemFixaMensal(double taxaCorretagemFixaMensal) {
        this.taxaCorretagemFixaMensal = taxaCorretagemFixaMensal;
    }

    @Override
    public double calcularSaldoProjetado(int numeroMeses) {
        double saldo = getSaldo();
        double saldoBrutoProjetado = saldo * Math.pow(1 + 0.008, numeroMeses);
        double totalTaxas = taxaCorretagemFixaMensal * numeroMeses;
        double saldoFinal = saldoBrutoProjetado - totalTaxas;
        return Math.max(0, saldoFinal);
    }
    
    @Override
    public void simularPassagemDeMes() {
        double saldo = this.getSaldo();
        saldo = saldo * (1 + 0.008);
        saldo -= taxaCorretagemFixaMensal;
        this.setSaldo(Math.max(0, saldo));
    }
}
