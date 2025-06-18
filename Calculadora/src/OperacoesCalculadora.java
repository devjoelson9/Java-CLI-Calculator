import java.util.InputMismatchException;
import java.util.Scanner; 

public class OperacoesCalculadora {

    public double somar(double num1, double num2) {
        return num1 + num2;
    }

    public double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Erro: Divisão por zero não é permitida.");
        }
        return num1 / num2;
    }

    public void iniciarCalculadora() {
        Scanner scanner = new Scanner(System.in); 
        double numero1 = 0;
        double numero2 = 0;
        int opcao = 0;
        boolean continuar = true;

        System.out.println("************ BEM-VINDO À SUA CALCULADORA JAVA ************");

        while (continuar) {
            try {
                System.out.print("\nDigite o PRIMEIRO número (ou 's' para sair): ");
                String input1 = scanner.next();
                if (input1.equalsIgnoreCase("s")) {
                    continuar = false;
                    break;
                }
                numero1 = Double.parseDouble(input1); 

                System.out.print("Digite o SEGUNDO número: ");
                numero2 = scanner.nextDouble();

                System.out.println("\nESCOLHA A OPERAÇÃO:");
                System.out.println("1 - ADIÇÃO (+)");
                System.out.println("2 - SUBTRAÇÃO (-)");
                System.out.println("3 - MULTIPLICAÇÃO (*)");
                System.out.println("4 - DIVISÃO (/)");
                System.out.print("Sua opção: ");
                opcao = scanner.nextInt(); 

                double resultado = 0; 

                switch (opcao) {
                    case 1:
                        resultado = somar(numero1, numero2);
                        System.out.println("Resultado da SOMA: " + resultado);
                        break;
                    case 2:
                        resultado = subtrair(numero1, numero2);
                        System.out.println("Resultado da SUBTRAÇÃO: " + resultado);
                        break;
                    case 3:
                        resultado = multiplicar(numero1, numero2);
                        System.out.println("Resultado da MULTIPLICAÇÃO: " + resultado);
                        break;
                    case 4:
                        resultado = dividir(numero1, numero2);
                        System.out.println("Resultado da DIVISÃO: " + resultado);
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha entre 1 e 4.");
                        break;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Entrada inválida! Por favor, digite números para as operações e um número para a opção.");
                scanner.next(); 
            } catch (NumberFormatException exception) {
                System.out.println("Entrada inválida! Por favor, digite um número válido.");
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            } catch (Exception exception) {
                System.out.println("Ocorreu um erro inesperado: " + exception.getMessage());
            }
        }
        System.out.println("************ CALCULADORA ENCERRADA. ATÉ A PRÓXIMA! ************");
        scanner.close();
    }

    public static void main(String[] args) {
        OperacoesCalculadora calculadora = new OperacoesCalculadora();
        calculadora.iniciarCalculadora();
    }
}