public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String bankname, String branch,
                          String ifscCode, int pincode,
                          String city, int accountnumber,
                          String customerdetails,
                          double interestRate) {

        super(bankname, branch, ifscCode,
              pincode, city, accountnumber,
              customerdetails);

        this.interestRate = interestRate;
    }

    public void display() {

        super.displayBalance();

        System.out.println(
                "Interest Rate: " + interestRate + "%");
    }

    public void addInterestRate() {

        double interestAmount =
                balance * (interestRate / 100);

        balance += interestAmount;

        System.out.println(
                "Interest added: " + interestAmount);
    }
}