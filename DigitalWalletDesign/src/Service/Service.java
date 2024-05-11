package Service;

import DaoData.daoData;
import Model.Transactions;
import Model.User;

import java.util.ArrayList;
import java.util.Map;

import static DaoData.daoData.*;

public class Service {

    public void tranfer(int sender, int receiver, int amount) {
        if(userHashMap.get(sender).getAccountHolderBalance()>=amount) {
            User updatedSender = new User(userHashMap.get(sender).getAccountHolderName(), userHashMap.get(sender).getAccountHolderBalance() - amount, sender);
            User updatedReceiver = new User(userHashMap.get(receiver).getAccountHolderName(), userHashMap.get(receiver).getAccountHolderBalance() + amount, receiver);

            userHashMap.put(sender, updatedSender);
            userHashMap.put(receiver, updatedReceiver);

            System.out.println("Transfer Successful");

            Transactions newTransactionSender = new Transactions(sender, amount, receiver, 0);
            Transactions newTransactionReceiver = new Transactions(receiver, amount, sender, 1);
            if (userTransactions.get(sender) == null) {
                userTransactions.put(sender, new ArrayList<Transactions>());
            }
            if(userTransactions.get(receiver)==null){
                userTransactions.put(receiver, new ArrayList<Transactions>());
            }
            userTransactions.get(sender).add(newTransactionSender);
            userTransactions.get(receiver).add(newTransactionReceiver);
        }else{
            System.out.println("Insufficient balance");
        }

    }


    public void AccountStatement(int accNumber) {
        System.out.println("Your transaction history");
       for(Transactions ts: userTransactions.get(accNumber)){
           if(ts.getType()==1){
               System.out.println("from " + ts.getReceiver() + " to " + ts.getSender() + ", amount " + ts.getAmount() + " received");
           }else{
               System.out.println("from "+ ts.getSender() + " to " + ts.getReceiver() + ", amount " + ts.getAmount() + " sent");
           }
       }
    }

    public void getOverview(){
        for(Map.Entry<Integer, User> userEntry: daoData.userHashMap.entrySet()){
            System.out.println("Account balance for " + userEntry.getKey() + " is " + userEntry.getValue().getAccountHolderBalance());
        }
    }
}
