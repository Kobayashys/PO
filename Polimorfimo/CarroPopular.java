public class CarroPopular extends Veiculo {
    private boolean arCondicionado; 

    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacaoDiaria, valorMultaPorRenovacao);
        this.arCondicionado = arCondicionado;
    }

    public boolean possuiArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularValorTotalAluguel(int numeroRenovacoes) {
        int renovacoesGratis = 1; // Carros Populares - 1 renovação sem custo 
        double valorTotal = getValorLocacaoDiaria(); // Valor inicial é o da diária.

        if (numeroRenovacoes > renovacoesGratis) {
            int renovacoesComMulta = numeroRenovacoes - renovacoesGratis;
            valorTotal += renovacoesComMulta * getValorMultaPorRenovacao(); // 
        }
        return valorTotal;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        
        System.out.println("Ar Condicionado: " + (arCondicionado ? "Sim" : "Não"));
        System.out.println("Categoria: Popular");
    }
}