public class ProdutoFisico extends Produto{
    private double peso;
    private double valorEntrega;

    public ProdutoFisico(String nome, double preco, int quantidade, double peso) {
        super(nome, preco, quantidade);
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double calcularFrete(double peso){
        if(peso < 2){
            valorEntrega = 5; 
        }
        if(peso > 2 && peso <5){
            valorEntrega = 10;
        }
        if(peso > 5){
            valorEntrega = 2.5*peso;
        }
        return valorEntrega;
    }

    @Override
    public void calcularTotal(double preco, int quantidade) {
        double p = getPreco();
        int q = getQuantidade();
        double valorTotal = (p * q) + valorEntrega;
    }
}
