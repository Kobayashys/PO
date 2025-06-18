public class Principal {
    public static void main(String[] args) {
        Cliente pf = new PessoaFisica("João Silva", "123.456.789-00", "email@exemplo.com");
        Cliente pj = new PessoaJuridica("Empresa XYZ", "12.345.678/0001-99", "empresa@exemplo.com");

        CarteiraInvestimentos carteiraPF = new CarteiraInvestimentos(pf);
        CarteiraInvestimentos carteiraPJ = new CarteiraInvestimentos(pj);

        TesouroPrefixado tesouro = new TesouroPrefixado(1000.0, 0.1);
        Debenture debenture = new Debenture(5000.0, 0.12);

        try {
            carteiraPF.adicionarInvestimento(tesouro);
            carteiraPJ.adicionarInvestimento(debenture);

            carteiraPF.adicionarInvestimento(debenture);
        } catch (IllegalArgumentException e) {
            System.out.println("Restrição de tipo de cliente: " + e.getMessage());
        }

        try {
            carteiraPJ.adicionarInvestimento(tesouro);
        } catch (IllegalArgumentException e) {
            System.out.println("Restrição de tipo de cliente: " + e.getMessage());
        }

        carteiraPF.aplicarEmInvestimento(tesouro, 1000.0);
        carteiraPJ.aplicarEmInvestimento(debenture, 5000.0);

        for (int mes = 1; mes <= 6; mes++) {
            System.out.println("\n--- Mês " + mes + " ---");
            carteiraPF.simularMes();
            carteiraPJ.simularMes();

            System.out.println("Saldo Tesouro (PF): " + tesouro.getSaldo());
            System.out.println("Saldo Debenture (PJ): " + debenture.getSaldo());

            System.out.println("Total investido PF: " + carteiraPF.calcularValorTotalInvestido());
            System.out.println("Total investido PJ: " + carteiraPJ.calcularValorTotalInvestido());
        }

        carteiraPF.resgatarDeInvestimento(tesouro, 500.0);
        carteiraPJ.resgatarDeInvestimento(debenture, 1000.0);

        System.out.println("\nApós resgates:");
        System.out.println("Saldo Tesouro (PF): " + tesouro.getSaldo());
        System.out.println("Saldo Debenture (PJ): " + debenture.getSaldo());
        System.out.println("Total investido PF: " + carteiraPF.calcularValorTotalInvestido());
        System.out.println("Total investido PJ: " + carteiraPJ.calcularValorTotalInvestido());

        try {
            carteiraPF.resgatarDeInvestimento(tesouro, 10000.0); // deve lançar exceção
        } catch (IllegalArgumentException e) {
            System.out.println("Validação de resgate: " + e.getMessage());
        }
    }
}
