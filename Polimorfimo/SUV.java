// Documentação: Classe SUV
// Esta classe estende Veiculo e adiciona atributos e comportamentos específicos
// para SUVs.
public class SUV extends Veiculo {
    private double tamanhoPortaMalas; // Tamanho do porta-malas em litros. 
    private String tipoTracao; // Tipo de tração (ex: 4x2, 4x4). 
    private String tipoCombustivel; // Tipo de combustível (ex: Gasolina, Flex, Diesel). 

    // Documentação: Construtor da classe SUV
    // Inicializa um novo objeto SUV, incluindo as informações básicas do veículo
    // e os atributos específicos de SUV.
    public SUV(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao, double tamanhoPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacaoDiaria, valorMultaPorRenovacao);
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.tipoTracao = tipoTracao;
        this.tipoCombustivel = tipoCombustivel;
    }

    // Documentação: Getters para os atributos específicos de SUV.
    public double getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    // Documentação: Setters para os atributos específicos de SUV.
    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    // Documentação: Sobrescrita do método calcularValorTotalAluguel para SUV.
    // Calcula o valor total do aluguel para um SUV.
    // SUVs têm 3 renovações sem custo. 
    // Após a cota, cada renovação extra incorre na multa específica do carro. 
    @Override
    public double calcularValorTotalAluguel(int numeroRenovacoes) {
        int renovacoesGratis = 3; // Carros SUV - 3 renovações sem custo 
        double valorTotal = getValorLocacaoDiaria(); // Valor inicial é o da diária.

        if (numeroRenovacoes > renovacoesGratis) {
            int renovacoesComMulta = numeroRenovacoes - renovacoesGratis;
            valorTotal += renovacoesComMulta * getValorMultaPorRenovacao(); // 
        }
        return valorTotal;
    }

    // Documentação: Sobrescrita do método exibirInformacoes para incluir os detalhes de SUV.
    @Override
    public void exibirInformacoes() { // Chama o método da classe pai para informações básicas.
        super.exibirInformacoes();
        System.out.println("Tamanho Porta-Malas: " + tamanhoPortaMalas + "L");
        System.out.println("Tipo Tração: " + tipoTracao);
        System.out.println("Tipo Combustível: " + tipoCombustivel);
        System.out.println("Categoria: SUV");
    }
}