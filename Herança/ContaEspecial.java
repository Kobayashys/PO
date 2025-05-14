public class ContaEspecial extends Conta {
    private double taxaJuros;

    public ContaEspecial(String titular, double saldo, String numeroConta, double taxaJuros) {
        super(titular, saldo, numeroConta);
        this.taxaJuros = taxaJuros;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldo() * (taxaJuros / 100);
        depositar(rendimento);
    }

    public void emprestimo(double valor, int meses, int diasAtraso) {
        if (valor > 0 && meses > 0) {
            double valorComJurosMensais = valor * Math.pow(1.05, meses);
            double valorPorMes = valorComJurosMensais / meses;

            if (diasAtraso > 0) {
                double multaAtraso = valorComJurosMensais * (0.01 * diasAtraso);
                valorComJurosMensais += multaAtraso;
                System.out.println("Atraso de " + diasAtraso + " dias. Multa de R$" + multaAtraso + " aplicada.");
            }

            depositar(valor);
            System.out.println("Empréstimo de R$" + valor + " realizado com sucesso.");
            System.out.println("Valor total a ser pago após " + meses + " meses: R$" + valorComJurosMensais);
            System.out.println("Valor a ser pago por mês: R$" + valorPorMes);
        } else {
            System.out.println("Valor ou número de meses inválido para empréstimo.");
        }
    }
}
