public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String nomeRepresentante;
    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj, String nomeRepresentante) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    @Override
    public int getLimiteEmprestimos() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Nome do Representante: " + nomeRepresentante);
        System.out.println("Tipo de Cliente: Pessoa Jurídica");
    }
}