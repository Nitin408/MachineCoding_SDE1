package Model;

public class Transactions {
    private int userAccountNumber;
    private int sender;
    private int receiver;
    private int amount;
    private int type;  // if receive then 1 and if send then 0

    public Transactions(int sender, int amount, int receiver, int type) {
        //this.userAccountNumber = userAccountNumber;
        this.sender = sender;
        this.amount = amount;
        this.receiver = receiver;
        this.type = type;
    }

    public int getUserAccountNumber() {
        return userAccountNumber;
    }

    public void setUserAccountNumber(int userAccountNumber) {
        this.userAccountNumber = userAccountNumber;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
