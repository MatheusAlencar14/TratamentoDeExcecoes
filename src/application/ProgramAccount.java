package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class ProgramAccount {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Digite os dados da conta: ");
            System.out.print("Número: ");
            int number = sc.nextInt();
            System.out.print("Nome do Titular: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Saldo inicial: ");
            double balance = sc.nextDouble();
            System.out.print("Limite de saque: ");
            double withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.println();
            System.out.print("Digite o valor para saque: ");
            double amount = sc.nextDouble();
            account.withdraw(amount);
            System.out.println("Novo saldo: " + String.format("%.2f", account.getBalance()));
        } catch (DomainException e) {
            System.out.println("Erro de saque: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }
        sc.close();
    }
}
