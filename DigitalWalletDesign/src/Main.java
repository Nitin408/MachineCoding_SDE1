import Model.User;
import Service.Service;

import java.util.Scanner;

import static DaoData.daoData.userData;
import static DaoData.daoData.userHashMap;

public class Main {
    public static void main(String[] args) {

        int AccountNumber = 0;

        Scanner input = new Scanner(System.in);
        boolean working = false;
        while(!working){
            System.out.println("1. Create Wallet");
            System.out.println("2. Transfer Amount");
            System.out.println("3. Account statement");
            System.out.println("4. Overview");
            System.out.println("5. Exit");
            int choosenOption = input.nextInt();
            switch (choosenOption){
                case 1:
                    System.out.println("You are creating account");
                    System.out.println("Please provide your Name");
                    String name = input.next();
                    System.out.println("Please give your initial account balance");
                    int balance = input.nextInt();
                    if(balance<=0){
                        System.out.println("Invalid account balance, please make account balance greater than 0");
                        break;
                    }
                    AccountNumber++;
                    User newUser = new User(name, balance, AccountNumber);
                    userData.add(newUser);
                    userHashMap.put(AccountNumber, newUser);
                    System.out.println("Account has been created for " + newUser.getAccountHolderName() + " with account number " + AccountNumber);
                    break;

                case 2:
                    System.out.println("You selected transfer");
                    System.out.println("Please enter sender account number");
                    int sender = input.nextInt();

                    System.out.println("please enter receiver account number");
                    int receiver = input.nextInt();

                    System.out.println("Please enter amount to send");
                    int amount = input.nextInt();

                    Service newService = new Service();
                    newService.tranfer(sender, receiver, amount);
                    break;
                case 3:
                    System.out.println("You Selected Account Statement");
                    System.out.println("Enter Acount Number");
                    int accNumber = input.nextInt();
                    Service newService2 = new Service();
                    newService2.AccountStatement(accNumber);


                    break;
                case 4:
                    System.out.println("You Selected Overview");
                    Service service3 = new Service();
                    service3.getOverview();
                    break;
                case 5:
                    System.out.println("Exiting");
                    working = true;
                    break;
            }
        }
    }
}