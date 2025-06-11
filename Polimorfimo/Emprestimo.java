import java.time.LocalDate; 

public class Emprestimo {
    private Cliente cliente; 
    private Veiculo veiculo; 
    private LocalDate dataInicio; 
    private int numeroRenovacoes; 

    public Emprestimo(Cliente cliente, Veiculo veiculo, LocalDate dataInicio) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.numeroRenovacoes = 0; 
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public int getNumeroRenovacoes() {
        return numeroRenovacoes;
    }

    public void renovar() {
        this.numeroRenovacoes++;
    }

    public void exibirInformacoes() {
        System.out.println("\n--- Detalhes do Empréstimo ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getMarca() + " " + veiculo.getModelo() + " (" + veiculo.getPlaca() + ")");
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Número de Renovações: " + numeroRenovacoes);
        System.out.println("------------------------------");
    }
}