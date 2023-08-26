package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int accountNumber = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(accountNumber, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.println("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);
            System.out.println(account);
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        catch (InputMismatchException e){
            System.out.println("Please type a valid value.");
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error.");
        }

        sc.close();
    }
}
