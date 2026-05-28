import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

accounts.add(new SavingsAccount(
        "Dayakar, Chintu",
        "Main Branch",
        "IFSC001",
        123456,
        "CityA",
        1,
        "Customer1",
        4.5));
        
accounts.add(new CurrentAccount(
        "Dayakar, Chintu",
        "Main Branch",
        "IFSC002",
        123456,
        "CityA",
        2,
        "Customer2",
        1000.0));
        System.out.println("Welcome to the Bank Account Management System!");

        do {

            System.out.println("\nMenu:");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Add Interest (Savings Account)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {

                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:

                        System.out.println("\n--- All Accounts ---");

                        for (BankAccount acc : accounts) {
                            acc.displayBalance();
                        }

                        break;

                    case 2:

                        System.out.print("Enter Account Number: ");

                        int depAccNo =
                                Integer.parseInt(scanner.nextLine());

                        BankAccount depAcc =
                                findAccount(accounts, depAccNo);

                        if (depAcc != null) {

                            System.out.print(
                                    "Enter deposit amount: ₹");

                            double depAmount =
                                    Double.parseDouble(scanner.nextLine());

                            depAcc.deposit(depAmount);

                        } else {

                            System.out.println("Account not found!");
                        }

                        break;

                    case 3:

                        System.out.print("Enter Account Number: ");

                        int witAccNo =
                                Integer.parseInt(scanner.nextLine());

                        BankAccount witAcc =
                                findAccount(accounts, witAccNo);

                        if (witAcc != null) {

                            System.out.print(
                                    "Enter withdrawal amount: ₹");

                            double witAmount =
                                    Double.parseDouble(scanner.nextLine());

                            witAcc.withdraw(witAmount);

                        } else {

                            System.out.println("Account not found!");
                        }

                        break;

                    case 4:

                        System.out.print(
                                "Enter Savings Account Number: ");

                        int savAccNo =
                                Integer.parseInt(scanner.nextLine());

                        BankAccount savAcc =
                                findAccount(accounts, savAccNo);

                        if (savAcc instanceof SavingsAccount) {

                            ((SavingsAccount) savAcc)
                                    .addInterestRate();

                        } else {

                            System.out.println(
                                    "This is not a Savings Account!");
                        }

                        break;

                    case 5:

                        System.out.println(
                                "Thank you. Goodbye!");

                        break;

                    default:

                        System.out.println(
                                "Invalid choice! Enter 1-5.");
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number.");
            }

        } while (choice != 5);

        scanner.close();
    }

    public static BankAccount findAccount(
            ArrayList<BankAccount> accounts,
            int accNo) {

        for (BankAccount acc : accounts) {

            if (acc.getaccountnumber() == accNo) {
                return acc;
            }
        }

        return null;
    }
}