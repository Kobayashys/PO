// Documentação: Classe CarroLuxo
// Esta classe estende Veiculo e adiciona atributos e comportamentos específicos
// para carros de luxo.
public class CarroLuxo extends Veiculo {
    private int quantidadeAirbags; // Quantidade de airbags no carro. 
    private double tamanhoPortaMalas; // Tamanho do porta-malas em litros. 
    private boolean gpsIntegrado; // Indica se o carro de luxo possui GPS integrado. 

    // Documentação: Construtor da classe CarroLuxo
    // Inicializa um novo objeto CarroLuxo, incluindo as informações básicas do veículo
    // e os atributos específicos de luxo.
    public CarroLuxo(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao, int quantidadeAirbags, double tamanhoPortaMalas, boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacaoDiaria, valorMultaPorRenovacao);
        this.quantidadeAirbags = quantidadeAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gpsIntegrado = gpsIntegrado;
    }

    // Documentação: Getters para os atributos específicos de CarroLuxo.
    public int getQuantidadeAirbags() {
        return quantidadeAirbags;
    }

    public double getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public boolean possuiGpsIntegrado() {
        return gpsIntegrado;
    }

    // Documentação: Setters para os atributos específicos de CarroLuxo.
    public void setQuantidadeAirbags(int quantidadeAirbags) {
        this.quantidadeAirbags = quantidadeAirbags;
    }

    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public void setGpsIntegrado(boolean gpsIntegrado) {
        this.gpsIntegrado = gpsIntegrado;
    }

    // Documentação: Sobrescrita do método calcularValorTotalAluguel para Carro de Luxo.
    // Calcula o valor total do aluguel para um carro de luxo.
    // Carros de Luxo têm 5 renovações sem custo. 
    // Após a cota, cada renovação extra incorre na multa específica do carro. 
    @Override
    public double calcularValorTotalAluguel(int numeroRenovacoes) {
        int renovacoesGratis = 5; // Carros de Luxo - 5 renovações sem custo 
        double valorTotal = getValorLocacaoDiaria(); // Valor inicial é o da diária.

        if (numeroRenovacoes > renovacoesGratis) {
            int renovacoesComMulta = numeroRenovacoes - renovacoesGratis;
            valorTotal += renovacoesComMulta * getValorMultaPorRenovacao(); // 
        }
        return valorTotal;
    }

    // Documentação: Sobrescrita do método exibirInformacoes para incluir os detalhes de CarroLuxo.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Quantidade Airbags: " + quantidadeAirbags);
        System.out.println("Tamanho Porta-Malas: " + tamanhoPortaMalas + "L");
        System.out.println("GPS Integrado: " + (gpsIntegrado ? "Sim" : "Não"));
        System.out.println("Categoria: Luxo");
    }
}