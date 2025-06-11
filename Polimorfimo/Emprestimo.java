import java.time.LocalDate; // Importa a classe LocalDate para trabalhar com datas.

// Documentação: Classe Emprestimo
// Representa uma única locação de veículo, associando um cliente a um veículo alugado.
public class Emprestimo {
    private Cliente cliente; // O cliente que realizou o empréstimo.
    private Veiculo veiculo; // O veículo que foi alugado.
    private LocalDate dataInicio; // A data de início do empréstimo.
    private int numeroRenovacoes; // O número de vezes que o empréstimo foi renovado.

    // Documentação: Construtor da classe Emprestimo
    // Inicializa um novo objeto Emprestimo.
    public Emprestimo(Cliente cliente, Veiculo veiculo, LocalDate dataInicio) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataInicio = dataInicio;
        this.numeroRenovacoes = 0; // Inicializa o número de renovações como zero.
    }

    // Documentação: Getters para acessar os atributos do empréstimo.
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

    // Documentação: Método para incrementar o número de renovações.
    public void renovar() {
        this.numeroRenovacoes++;
    }

    // Documentação: Método para exibir informações detalhadas do empréstimo.
    public void exibirInformacoes() {
        System.out.println("\n--- Detalhes do Empréstimo ---");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Veículo: " + veiculo.getMarca() + " " + veiculo.getModelo() + " (" + veiculo.getPlaca() + ")");
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Número de Renovações: " + numeroRenovacoes);
        System.out.println("------------------------------");
    }
}