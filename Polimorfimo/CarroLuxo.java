public class CarroLuxo extends Veiculo {
    private int quantidadeAirbags;  
    private double tamanhoPortaMalas; 
    private boolean gpsIntegrado; 

    public CarroLuxo(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao, int quantidadeAirbags, double tamanhoPortaMalas, boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacaoDiaria, valorMultaPorRenovacao);
        this.quantidadeAirbags = quantidadeAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gpsIntegrado = gpsIntegrado;
    }

    public int getQuantidadeAirbags() {
        return quantidadeAirbags;
    }

    public double getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public boolean possuiGpsIntegrado() {
        return gpsIntegrado;
    }

    public void setQuantidadeAirbags(int quantidadeAirbags) {
        this.quantidadeAirbags = quantidadeAirbags;
    }

    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public void setGpsIntegrado(boolean gpsIntegrado) {
        this.gpsIntegrado = gpsIntegrado;
    }

    @Override
    public double calcularValorTotalAluguel(int numeroRenovacoes) {
        int renovacoesGratis = 5;
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
        System.out.println("Quantidade Airbags: " + quantidadeAirbags);
        System.out.println("Tamanho Porta-Malas: " + tamanhoPortaMalas + "L");
        System.out.println("GPS Integrado: " + (gpsIntegrado ? "Sim" : "Não"));
        System.out.println("Categoria: Luxo");
    }
}