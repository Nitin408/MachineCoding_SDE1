package Model;

public class User {
    private String accountHolderName;
    private int accountHolderBalance;
    private int accountNumber;


    public User(String accountHolderName, int accountHolderBalance, int accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountHolderBalance = accountHolderBalance;
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountHolderBalance() {
        return accountHolderBalance;
    }

    public void setAccountHolderBalance(int accountHolderBalance) {
        this.accountHolderBalance = accountHolderBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
