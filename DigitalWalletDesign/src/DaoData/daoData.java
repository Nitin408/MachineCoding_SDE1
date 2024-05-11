package DaoData;

import Model.Transactions;
import Model.User;

import java.util.ArrayList;
import java.util.HashMap;

public class daoData {
    public static ArrayList<User> userData = new ArrayList<User>();
    public static HashMap<Integer, User> userHashMap = new HashMap<Integer, User>();
    public static HashMap<Integer, ArrayList<Transactions>> userTransactions = new HashMap<Integer, ArrayList<Transactions>>();
}
