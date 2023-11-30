package projeto;
import java.util.InputMismatchException;
import java.util.Scanner;

// Classe base para representar um funcionário
class Funcionario {
    private String nome;
    private double salarioBase;

    // Construtor para inicialização de objetos Funcionario
    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    // Método para calcular o salário base do funcionário
    public double calcularSalario() {
        return salarioBase;
    }

    // Encapsulamento: getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}

// Classe derivada que herda de Funcionario
class Gerente extends Funcionario {
    private double bonus;

    // Construtor que chama o construtor da classe base (Funcionario)
    public Gerente(String nome, double salarioBase, double bonus) {
        super(nome, salarioBase);
        this.bonus = bonus;
    }

    // Sobrecarga do método calcularSalario
    @Override
    public double calcularSalario() {
        // Soma o salário base com o bônus para calcular o salário total do gerente
        return getSalarioBase() + bonus;
    }
}

public class SistemaDeRH {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do funcionário: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o salário base do funcionário: ");
            double salarioBase = scanner.nextDouble();

            // Verificação de bônus apenas se for gerente
            double bonus = 0.0;
            System.out.print("É um gerente? (S/N): ");
            char resposta = scanner.next().charAt(0);
            if (resposta == 'S' || resposta == 's') {
                System.out.print("Digite o bônus do gerente: ");
                bonus = scanner.nextDouble();
            }

            // Validar entradas
            if (salarioBase < 0 || bonus < 0) {
                System.err.println("Erro: Os valores de salário base e bônus devem ser não negativos.");
                return;
            }

            // Validar limites razoáveis (exemplo: salário não pode ser maior que 1 milhão)
            if (salarioBase > 1000000 || bonus > 1000000) {
                System.err.println("Erro: Valores muito altos. Verifique as entradas.");
                return;
            }

            // Criação de objetos
            Funcionario funcionario = new Funcionario(nome, salarioBase);
            Gerente gerente = new Gerente(nome, salarioBase, bonus);

            // Exibição de salários
            System.out.println("Salário do Funcionário: " + funcionario.calcularSalario());
            System.out.println("Salário do Gerente: " + gerente.calcularSalario());

        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Certifique-se de inserir os tipos corretos.");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
