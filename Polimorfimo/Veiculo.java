public abstract class Veiculo {
    private String marca;
    private String modelo;
    private String placa; 
    private int ano;
    private double valorLocacaoDiaria;
    private double valorMultaPorRenovacao;
    private boolean alugado;
    public Veiculo(String marca, String modelo, String placa, int ano, double valorLocacaoDiaria, double valorMultaPorRenovacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valorLocacaoDiaria = valorLocacaoDiaria;
        this.valorMultaPorRenovacao = valorMultaPorRenovacao;
        this.alugado = false;
    }

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

    public abstract double calcularValorTotalAluguel(int numeroRenovacoes);

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