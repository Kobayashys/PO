// Documentação: Classe abstrata Cliente
// Esta classe serve como base para todos os tipos de clientes na locadora.
// Ela contém atributos comuns a todos os clientes e define o comportamento básico.
public abstract class Cliente {
    private String nome; // O nome do cliente. 
    private String telefone; // O telefone de contato do cliente. 
    private String endereco; // O endereço do cliente. 

    // Documentação: Construtor da classe Cliente
    // Inicializa um novo objeto Cliente com os dados fornecidos.
    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Documentação: Getters para acessar os atributos do cliente.
    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    // Documentação: Setters para modificar os atributos do cliente.
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Documentação: Método abstrato para obter o limite de empréstimos que um cliente pode ter.
    // Este método será implementado (sobrescrito) por cada subclasse de Cliente,
    // considerando as regras específicas de Pessoa Física e Pessoa Jurídica. 
    public abstract int getLimiteEmprestimos();

    // Documentação: Método para exibir informações básicas do cliente.
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Telefone: " + telefone);
        System.out.println("Endereço: " + endereco);
    }
}