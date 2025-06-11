// Documentação: Classe PessoaJuridica
// Esta classe estende Cliente e adiciona atributos e comportamentos específicos
// para pessoas jurídicas (empresas).
public class PessoaJuridica extends Cliente {
    private String cnpj; // O CNPJ (Cadastro Nacional da Pessoa Jurídica) da empresa. 
    private String nomeRepresentante; // O nome do representante da empresa. 

    // Documentação: Construtor da classe PessoaJuridica
    // Inicializa um novo objeto PessoaJuridica, incluindo as informações básicas do cliente
    // e os atributos específicos de CNPJ e nome do representante.
    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj, String nomeRepresentante) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
    }

    // Documentação: Getters para os atributos específicos de Pessoa Jurídica.
    public String getCnpj() {
        return cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    // Documentação: Setters para os atributos específicos de Pessoa Jurídica.
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    // Documentação: Sobrescrita do método getLimiteEmprestimos para Pessoa Jurídica.
    // Empresas podem ter vários empréstimos ao mesmo tempo. 
    // Retornamos um valor alto para indicar que não há um limite rígido.
    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE; // Empresas podem ter vários empréstimos ao mesmo tempo. 
    }

    // Documentação: Sobrescrita do método exibirInformacoes para incluir CNPJ e Nome do Representante.
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes(); // Chama o método da classe pai para informações básicas.
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Nome do Representante: " + nomeRepresentante);
        System.out.println("Tipo de Cliente: Pessoa Jurídica");
    }
}