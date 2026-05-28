public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String bankname, String branch,
                          String ifscCode, int pincode,
                          String city, int accountnumber, String customerdetails,
                          double overdraftLimit) {

        super(bankname, branch, ifscCode, pincode,
              city, accountnumber, customerdetails);

        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance + overdraftLimit) {
            System.out.println("Overdraft limit exceeded. Cannot withdraw " + amount);
            return;
        }

        balance -= amount;

        System.out.println("Withdrew: " + amount + " successfully.");
    }

    public void display() {

        System.out.println("Bank Name: " + getBankname());
        System.out.println("Branch: " + getBranch());
        System.out.println("IFSC Code: " + getIfscCode());
        System.out.println("City: " + getCity());
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}