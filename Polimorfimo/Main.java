import java.util.Scanner; 

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora minhaLocadora = new Locadora("Locadora Exemplo", "Rua Principal, 123", "1234-5678");
        int opcao; 

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo(scanner, minhaLocadora);
                    break;
                case 2:
                    cadastrarCliente(scanner, minhaLocadora);
                    break;
                case 3:
                    realizarEmprestimo(scanner, minhaLocadora);
                    break;
                case 4:
                    finalizarEmprestimo(scanner, minhaLocadora);
                    break;
                case 5:
                    minhaLocadora.listarVeiculos();
                    break;
                case 6:
                    minhaLocadora.listarClientes();
                    break;
                case 7:
                    minhaLocadora.listarEmprestimos();
                    break;
                case 8:
                    renovarEmprestimo(scanner, minhaLocadora);
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento da Locadora ---");
        System.out.println("1. Cadastrar Novo Veículo");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Realizar Empréstimo");
        System.out.println("4. Finalizar Empréstimo");
        System.out.println("5. Listar Veículos");
        System.out.println("6. Listar Clientes");
        System.out.println("7. Listar Empréstimos");
        System.out.println("8. Renovar Empréstimo");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarVeiculo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Cadastro de Veículo ---");
        System.out.print("Marca: ");
        String marca = scanner.nextLine(); 
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine(); 
        System.out.print("Placa: ");
        String placa = scanner.nextLine(); 
        System.out.print("Ano: ");
        int ano = scanner.nextInt(); 
        System.out.print("Valor da Locação Diária: ");
        double valorLocacaoDiaria = scanner.nextDouble(); 
        System.out.print("Valor da Multa por Renovação Excedente: "); 
        double valorMulta = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escolha a categoria do carro: ");
        System.out.println("1. Popular");
        System.out.println("2. SUV");
        System.out.println("3. Luxo");
        System.out.print("Opção: ");
        int categoria = scanner.nextInt();
        scanner.nextLine();

        Veiculo novoVeiculo = null;
        switch (categoria) {
            case 1:
                System.out.print("Possui Ar-Condicionado? (sim/nao): "); 
                boolean arCondicionado = scanner.nextLine().equalsIgnoreCase("sim");
                novoVeiculo = new CarroPopular(marca, modelo, placa, ano, valorLocacaoDiaria, valorMulta, arCondicionado);
                break;
            case 2:
                System.out.print("Tamanho do Porta-Malas (litros): "); 
                double tamanhoPortaMalasSUV = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Tipo de Tração: "); 
                String tipoTracao = scanner.nextLine();
                System.out.print("Tipo de Combustível: "); 
                String tipoCombustivel = scanner.nextLine();
                novoVeiculo = new SUV(marca, modelo, placa, ano, valorLocacaoDiaria, valorMulta, tamanhoPortaMalasSUV, tipoTracao, tipoCombustivel);
                break;
            case 3:
                System.out.print("Quantidade de Airbags: "); 
                int quantidadeAirbags = scanner.nextInt();
                System.out.print("Tamanho do Porta-Malas (litros): "); 
                double tamanhoPortaMalasLuxo = scanner.nextDouble();
                scanner.nextLine(); 
                System.out.print("Possui GPS Integrado? (sim/nao): "); 
                boolean gpsIntegrado = scanner.nextLine().equalsIgnoreCase("sim");
                novoVeiculo = new CarroLuxo(marca, modelo, placa, ano, valorLocacaoDiaria, valorMulta, quantidadeAirbags, tamanhoPortaMalasLuxo, gpsIntegrado);
                break;
            default:
                System.out.println("Categoria de veículo inválida. Veículo não cadastrado.");
                return;
        }

        if (novoVeiculo != null) {
            locadora.cadastrarVeiculo(novoVeiculo);
        }
    }

    private static void cadastrarCliente(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Nome: "); 
        String nome = scanner.nextLine();
        System.out.print("Telefone: "); 
        String telefone = scanner.nextLine();
        System.out.print("Endereço: "); 
        String endereco = scanner.nextLine();

        System.out.println("Tipo de Cliente: "); 
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica (Empresa)");
        System.out.print("Opção: ");
        int tipoCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente novoCliente = null;
        switch (tipoCliente) {
            case 1:
                System.out.print("CPF: "); 
                String cpf = scanner.nextLine();
                novoCliente = new PessoaFisica(nome, telefone, endereco, cpf);
                break;
            case 2:
                System.out.print("CNPJ: "); 
                String cnpj = scanner.nextLine();
                System.out.print("Nome do Representante: "); 
                String nomeRepresentante = scanner.nextLine();
                novoCliente = new PessoaJuridica(nome, telefone, endereco, cnpj, nomeRepresentante);
                break;
            default:
                System.out.println("Tipo de cliente inválido. Cliente não cadastrado.");
                return;
        }

        if (novoCliente != null) {
            locadora.cadastrarCliente(novoCliente);
        }
    }

    private static void realizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Realizar Empréstimo ---");
        System.out.print("CPF ou CNPJ do Cliente: ");
        String cpfCnpj = scanner.nextLine();
        System.out.print("Placa do Veículo a ser alugado: ");
        String placa = scanner.nextLine();

        locadora.realizarEmprestimo(cpfCnpj, placa);
    }

    private static void finalizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Finalizar Empréstimo ---");
        System.out.print("Placa do Veículo a ser devolvido: ");
        String placa = scanner.nextLine();

        locadora.finalizarEmprestimo(placa);
    }

    private static void renovarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Renovar Empréstimo ---");
        System.out.print("Placa do Veículo para renovar: ");
        String placa = scanner.nextLine();

        locadora.renovarEmprestimo(placa);
    }
}