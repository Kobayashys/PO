public class SUV extends Veiculo {
    private double tamanhoPortaMalas;
    private String tipoTracao; 
    private String tipoCombustivel;
    public SUV(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao, double tamanhoPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacaoDiaria, valorMultaPorRenovacao);
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.tipoTracao = tipoTracao;
        this.tipoCombustivel = tipoCombustivel;
    }

    public double getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public double calcularValorTotalAluguel(int numeroRenovacoes) {
        int renovacoesGratis = 3;
        double valorTotal = getValorLocacaoDiaria();

        if (numeroRenovacoes > renovacoesGratis) {
            int renovacoesComMulta = numeroRenovacoes - renovacoesGratis;
            valorTotal += renovacoesComMulta * getValorMultaPorRenovacao();  
        }
        return valorTotal;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tamanho Porta-Malas: " + tamanhoPortaMalas + "L");
        System.out.println("Tipo Tração: " + tipoTracao);
        System.out.println("Tipo Combustível: " + tipoCombustivel);
        System.out.println("Categoria: SUV");
    }
}