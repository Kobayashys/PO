public class Livro {
    private String titulo;
    private String autor; 
    private String editora;
    private String edicao;

    public Livro( String titulo, String autor, String editora, String edicao){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public String getEditora(){
        return editora;
    }

    public String getEdicao(){
        return edicao;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setEditora(String editora){
        this.editora = editora;
    }

    public void setEdicao(String edicao){
        this.edicao = edicao;
    }
}
