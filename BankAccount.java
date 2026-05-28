public class BankAccount {

    private String bankname;
    private String branch;
    private String ifscCode;
    private int pincode;
    private String city;
    private int accountnumber;
    private String customerdetails;
public int getaccountnumber() {
        return accountnumber;
    }


    protected double balance;

    public BankAccount(String bankname, String branch,
                       String ifscCode, int pincode,
                       String city,int accountnumber, String customerdetails
                    ) {

        this.bankname = bankname;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.pincode = pincode;
        this.city = city;
        this.accountnumber = accountnumber;
        this.customerdetails = customerdetails;
        
    }

    public String getBankname() {
        return bankname;
    }

    public String getBranch() {
        return branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }

    public String getCustomerdetails() {
        return customerdetails;
    }

    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount + " successfully.");
        }
    }

    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return;
        }

        balance -= amount;

        System.out.println("Withdrawn: " + amount + " successfully.");
    }

    public void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}