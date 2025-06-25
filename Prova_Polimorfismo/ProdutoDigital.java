public class ProdutoDigital extends Produto{
    private int tamanhoArquivo;

    public ProdutoDigital(String nome, double preco, int quantidade, int tamanhoArquivo) {
        super(nome, preco, quantidade);
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public int getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(int tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    @Override
    public void calcularTotal(double preco, int quantidade){
        double p = getPreco();
        int q = getQuantidade();
        double valorTotal= p*q;        
    }
}
