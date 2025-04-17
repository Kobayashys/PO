public class Biblioteca {
    private String nome;
    private String endereco;
    private String emprestimo;
    private String renovacao;
    private String taxaRenovacao;
    private Livro livro;
    private Pessoa aluno;

    public Biblioteca(String nome, String endereco, Livro livro, Pessoa aluno){
        this.nome = nome;
        this.endereco = endereco;
        this.livro = livro;
        this.aluno = aluno;
    }

    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public Livro getLivro(){
        return livro;
    }

    public Pessoa getAluno(){
        return aluno;
    }

    public void setNome(String nome ){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setLivro(Livro livro){
        if(livro != null){
            this.livro = livro;
        }
    }

    public void setAluno(Pessoa aluno){
        if(aluno != null){
            this.aluno = aluno;
        }
    }

    public void emprestimo(Pessoa aluno, Livro livro){
        if(aluno != null || livro != null){
            System.out.println("Quem é o aluno responsável pelo emprestimo: ");
        }
    }


}
