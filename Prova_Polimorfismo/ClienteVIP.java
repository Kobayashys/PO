public class ClienteVIP extends Cliente{
    private String RG;

    public ClienteVIP(String nome, String endereco, String telefone, String rG) {
        super(nome, endereco, telefone);
        RG = rG;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String rG) {
        RG = rG;
    }
}
