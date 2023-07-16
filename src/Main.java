import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            String [] vet = sc.nextLine().split(" ");
            int pos = sc.nextInt();
            System.out.println(vet[pos]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição inválida!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada!");
        }

        System.out.println("Fim do programa");

        sc.close();
    }
}