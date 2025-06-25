public class Assinatura extends Produto{
    private int diasContratados;

    public Assinatura(String nome, double preco, int quantidade, int diasContratados) {
        super(nome, preco, 1);
        this.diasContratados = diasContratados;
    }

    public int getDiasContratados() {
        return diasContratados;
    }

    public void setDiasContratados(int diasContratados) {
        this.diasContratados = diasContratados;
    }

    @Override
    public void calcularTotal(double preco, int quantidade) {
        double p = getPreco();
        double valorTotal = p * diasContratados/30;
    }
}
