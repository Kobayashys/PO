import java.util.ArrayList;

public class CarrinhoDeCompra {
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    public CarrinhoDeCompra(Cliente cliente, ArrayList<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Cliente cliente, ArrayList<Produto> produtos){
        if(cliente instanceof PessoaFisica){
            int limiteProduto = 3;
        }
        if (cliente instanceof PessoaJuridica){
            int limiteProduto = 10;   
        }
        produtos.add(null);        
    }

    public void removerProduto(ArrayList<Produto> produtos){
        produtos.remove(produtos);
    }
    public void calcularTotalCompra(Class Produto){}
}