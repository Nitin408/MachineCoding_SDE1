import DAO.DaoData;
import Model.Pair;
import Model.Player;
import Service.Service;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);


        String player = input.nextLine();
        String[] temp = player.split(" ");
        char playerSymbol = temp[0].charAt(0);
        String playerName = temp[1];
        Player newPlayer = new Player(playerName, playerSymbol);
        DaoData.playerData.add(newPlayer);


        String player2 = input.nextLine();
        String[] temp2 = player2.split(" ");
        char playerSymbol2 = temp2[0].charAt(0);
        String playerName2 = temp2[1];
        Player newPlayer2 = new Player(playerName2, playerSymbol2);
        DaoData.playerData.add(newPlayer2);



        //int numberOfPlayer = input.nextInt();
//        while(numberOfPlayer>0){
//            String player = input.nextLine();
//            System.out.println(player);
////            char playerSymbol = player[0].charAt(0);
////            String playerName = player[1];
////            Player newPlayer = new Player(playerName, playerSymbol);
////            DaoData.playerData.add(newPlayer);
//            numberOfPlayer--;
//        }

        String str = input.nextLine();
        while(str != null && !str.equalsIgnoreCase("Exit")){
                String[] split = str.split(" ");
                int rowName = Integer.parseInt(split[0]);
                int coloumnName = Integer.parseInt(split[1]);
                DaoData.playerMovesX.add(rowName-1);
                DaoData.playerMovesY.add(coloumnName-1);

                str = input.nextLine();

        }
        Service newGame = new Service();
        newGame.playGame();






//        File inputFile = new File("/Users/nitinbaghel/Desktop/Java/NewTicTacToe/src/input.txt");
//
//        BufferedReader br = new BufferedReader(new FileReader(inputFile));
//        String str;
//        while((str=br.readLine())!=null && !str.equalsIgnoreCase("Exit")){
//            int numOfPlayers = Integer.parseInt(str);
//        }



    }
}