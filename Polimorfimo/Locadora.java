import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Classe Locadora: gerencia veículos, clientes e empréstimos.
public class Locadora {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Veiculo> veiculosDisponiveis;
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimosRealizados;

    // Construtor
    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.veiculosDisponiveis = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.emprestimosRealizados = new ArrayList<>();
    }

    // Adiciona um novo veículo
    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculosDisponiveis.add(veiculo);
        System.out.println("Veículo " + veiculo.getMarca() + " " + veiculo.getModelo() + " cadastrado com sucesso!");
    }

    // Adiciona um novo cliente
    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
    }

    // Realiza um empréstimo
    public void realizarEmprestimo(String cpfCnpjCliente, String placaVeiculo) {
        Cliente clienteSelecionado = buscarCliente(cpfCnpjCliente);
        Veiculo veiculoSelecionado = buscarVeiculo(placaVeiculo);

        if (clienteSelecionado == null) {
            System.out.println("Erro: Cliente não encontrado.");
            return;
        }

        if (veiculoSelecionado == null) {
            System.out.println("Erro: Veículo não encontrado.");
            return;
        }

        if (veiculoSelecionado.isAlugado()) {
            System.out.println("Erro: O veículo " + veiculoSelecionado.getModelo() + " (" + veiculoSelecionado.getPlaca() + ") já está alugado.");
            return;
        }

        int emprestimosAtivosCliente = 0;
        for (Emprestimo emp : emprestimosRealizados) {
            if (emp.getCliente().equals(clienteSelecionado) && emp.getVeiculo().isAlugado()) {
                emprestimosAtivosCliente++;
            }
        }

        if (emprestimosAtivosCliente >= clienteSelecionado.getLimiteEmprestimos()) {
            System.out.println("Erro: Cliente " + clienteSelecionado.getNome() + " já atingiu o limite de empréstimos (" + clienteSelecionado.getLimiteEmprestimos() + ").");
            return;
        }

        Emprestimo novoEmprestimo = new Emprestimo(clienteSelecionado, veiculoSelecionado, LocalDate.now());
        emprestimosRealizados.add(novoEmprestimo);
        veiculoSelecionado.setAlugado(true);
        System.out.println("Empréstimo realizado com sucesso!");
        novoEmprestimo.exibirInformacoes();
    }

    // Finaliza um empréstimo
    public void finalizarEmprestimo(String placaVeiculo) {
        Emprestimo emprestimoParaFinalizar = null;
        Iterator<Emprestimo> iterator = emprestimosRealizados.iterator();

        while (iterator.hasNext()) {
            Emprestimo emp = iterator.next();
            if (emp.getVeiculo().getPlaca().equalsIgnoreCase(placaVeiculo) && emp.getVeiculo().isAlugado()) {
                emprestimoParaFinalizar = emp;
                break;
            }
        }

        if (emprestimoParaFinalizar == null) {
            System.out.println("Erro: Não foi encontrado um empréstimo ativo para o veículo com a placa " + placaVeiculo + ".");
            return;
        }

        emprestimoParaFinalizar.getVeiculo().setAlugado(false);

        double valorTotal = emprestimoParaFinalizar.getVeiculo().calcularValorTotalAluguel(emprestimoParaFinalizar.getNumeroRenovacoes());

        System.out.println("\n--- Empréstimo Finalizado ---");
        emprestimoParaFinalizar.exibirInformacoes();
        System.out.println("Valor Total do Aluguel: R$" + String.format("%.2f", valorTotal));
        System.out.println("-----------------------------");

        // Se desejar remover o empréstimo da lista de ativos, descomente a linha abaixo:
        // iterator.remove();
    }

    // Renova um empréstimo
    public void renovarEmprestimo(String placaVeiculo) {
        Emprestimo emprestimoParaRenovar = null;
        for (Emprestimo emp : emprestimosRealizados) {
            if (emp.getVeiculo().getPlaca().equalsIgnoreCase(placaVeiculo) && emp.getVeiculo().isAlugado()) {
                emprestimoParaRenovar = emp;
                break;
            }
        }

        if (emprestimoParaRenovar == null) {
            System.out.println("Erro: Não foi encontrado um empréstimo ativo para o veículo com a placa " + placaVeiculo + ".");
            return;
        }

        emprestimoParaRenovar.renovar();
        System.out.println("Empréstimo do veículo " + placaVeiculo + " renovado com sucesso!");
        System.out.println("Número de renovações atuais: " + emprestimoParaRenovar.getNumeroRenovacoes());
    }

    // Busca cliente por CPF ou CNPJ
    private Cliente buscarCliente(String cpfCnpj) {
        for (Cliente c : clientes) {
            if (c instanceof PessoaFisica && ((PessoaFisica) c).getCpf().equalsIgnoreCase(cpfCnpj)) {
                return c;
            } else if (c instanceof PessoaJuridica && ((PessoaJuridica) c).getCnpj().equalsIgnoreCase(cpfCnpj)) {
                return c;
            }
        }
        return null;
    }

    // Busca veículo por placa
    private Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : veiculosDisponiveis) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    // Lista veículos cadastrados
    public void listarVeiculos() {
        if (veiculosDisponiveis.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado na locadora.");
            return;
        }
        System.out.println("\n--- Veículos Cadastrados ---");
        for (Veiculo v : veiculosDisponiveis) {
            v.exibirInformacoes();
            System.out.println("----------------------------");
        }
    }

    // Lista clientes cadastrados
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado na locadora.");
            return;
        }
        System.out.println("\n--- Clientes Cadastrados ---");
        for (Cliente c : clientes) {
            c.exibirInformacoes();
            System.out.println("----------------------------");
        }
    }

    // Lista empréstimos realizados
    public void listarEmprestimos() {
        if (emprestimosRealizados.isEmpty()) {
            System.out.println("Nenhum empréstimo realizado ainda.");
            return;
        }
        System.out.println("\n--- Empréstimos Realizados ---");
        for (Emprestimo e : emprestimosRealizados) {
            e.exibirInformacoes();
        }
        System.out.println("------------------------------");
    }
}