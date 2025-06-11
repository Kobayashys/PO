// Documentação: Classe PessoaFisica
// Esta classe estende Cliente e adiciona atributos e comportamentos específicos
// para pessoas físicas.
public class PessoaFisica extends Cliente {
    private String cpf; // O CPF (Cadastro de Pessoas Físicas) do cliente. 

    // Documentação: Construtor da classe PessoaFisica
    // Inicializa um novo objeto PessoaFisica, incluindo as informações básicas do cliente
    // e o atributo específico de CPF.
    public PessoaFisica(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
    }

    // Documentação: Getter para o atributo cpf.
    public String getCpf() {
        return cpf;
    }

    // Documentação: Setter para o atributo cpf.
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Documentação: Sobrescrita do método getLimiteEmprestimos para Pessoa Física.
    // Pessoas físicas só podem ter um empréstimo por vez. 
    @Override
    public int getLimiteEmprestimos() {
        return 1; // Pessoas físicas só podem possuir um empréstimo por vez. 
    }

    // Documentação: Sobrescrita do método exibirInformacoes para incluir o CPF.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); // Chama o método da classe pai para informações básicas.
        System.out.println("CPF: " + cpf);
        System.out.println("Tipo de Cliente: Pessoa Física");
    }
}