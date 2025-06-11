// Documentação: Classe abstrata Veiculo
// Esta classe serve como base para todos os tipos de veículos na locadora.
// Ela contém atributos comuns a todos os veículos e define o comportamento básico.
public abstract class Veiculo {
    private String marca; // A marca do veículo. 
    private String modelo; // O modelo do veículo. 
    private String placa; // A placa de identificação do veículo. 
    private int ano; // O ano de fabricação do veículo. 
    private double valorLocacaoDiaria; // O valor da locação diária do veículo. 
    private double valorMultaPorRenovacao; // O valor da multa por renovação excedente. 
    private boolean alugado; // Indica se o veículo está atualmente alugado.

    // Documentação: Construtor da classe Veiculo
    // Inicializa um novo objeto Veiculo com os dados fornecidos.
    public Veiculo(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.valorMultaPorRenovacao = valorMultaPorRenovacao;
        this.alugado = false; // Por padrão, um veículo é cadastrado como não alugado.
    }

    // Documentação: Getters para acessar os atributos do veículo.
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getAno() {
        return ano;
    }

    public double getValorLocacaoDiaria() {
        return valorLocacaoDiaria;
    }

    public double getValorMultaPorRenovacao() {
        return valorMultaPorRenovacao;
    }

    public boolean isAlugado() {
        return alugado;
    }

    // Documentação: Setters para modificar os atributos do veículo.
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setValorLocacaoDiaria(double valorLocacaoDiaria) {
        this.valorLocacaoDiaria = valorLocacaoDiaria;
    }

    public void setValorMultaPorRenovacao(double valorMultaPorRenovacao) {
        this.valorMultaPorRenovacao = valorMultaPorRenovacao;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    // Documentação: Método abstrato para calcular o valor total do aluguel.
    // Este método será implementado (sobrescrito) por cada subclasse de Veiculo,
    // considerando as regras específicas de renovação e multa. 
    public abstract double calcularValorTotalAluguel(int numeroRenovacoes);

    // Documentação: Método para exibir informações básicas do veículo.
    // Este método é útil para apresentar os detalhes do carro.
    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Placa: " + placa);
        System.out.println("Ano: " + ano);
        System.out.println("Valor Diária: R$" + String.format("%.2f", valorLocacaoDiaria));
        System.out.println("Valor Multa por Renovação: R$" + String.format("%.2f", valorMultaPorRenovacao));
        System.out.println("Status: " + (alugado ? "Alugado" : "Disponível"));
    }
}