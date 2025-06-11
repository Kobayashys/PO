// Documentação: Classe CarroPopular
// Esta classe estende Veiculo e adiciona atributos e comportamentos específicos
// para carros populares.
public class CarroPopular extends Veiculo {
    private boolean arCondicionado; // Indica se o carro popular possui ar-condicionado. 

    // Documentação: Construtor da classe CarroPopular
    // Inicializa um novo objeto CarroPopular, incluindo as informações básicas do veículo
    // e o atributo específico de ar-condicionado.
    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacaoDiaria, valorMultaPorRenovacao);
        this.arCondicionado = arCondicionado;
    }

    // Documentação: Getter para o atributo arCondicionado.
    public boolean possuiArCondicionado() {
        return arCondicionado;
    }

    // Documentação: Setter para o atributo arCondicionado.
    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    // Documentação: Sobrescrita do método calcularValorTotalAluguel para Carro Popular.
    // Calcula o valor total do aluguel para um carro popular.
    // Carros populares têm 1 renovação sem custo. 
    // Após a cota, cada renovação extra incorre na multa específica do carro. 
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

    // Documentação: Sobrescrita do método exibirInformacoes para incluir o ar-condicionado.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        
        System.out.println("Ar Condicionado: " + (arCondicionado ? "Sim" : "Não"));
        System.out.println("Categoria: Popular");
    }
}