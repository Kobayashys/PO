import java.util.ArrayList;

public class CarteiraDeInvestimentos {
    private Cliente cliente;
    private ArrayList<Investimento> investimentos;

    public CarteiraDeInvestimentos(Cliente cliente) {
        this.cliente = cliente;
        this.investimentos = new ArrayList<>();
    }

    public void adicionarInvestimento(Investimento investimento) {
    if (investimento.getCliente().equals(this.cliente)) {
        this.investimentos.add(investimento);
    }
}

    public double calcularValorTotalInvestido(){
        double total = 0.0;
        for (Investimento investimento : this.investimentos) {
            total += investimento.getSaldo();
        }
        return total;
    }

}
