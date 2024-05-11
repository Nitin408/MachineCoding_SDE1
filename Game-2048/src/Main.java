import DAODATA.DaoData;
import Services.Service;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DaoData.initiateGrid();
        DaoData.printGrid();


        boolean win = false;
        Service newGame = new Service();
        while(!win){
            Scanner input = new Scanner(System.in);
            int move = input.nextInt();
            newGame.playGame(move);

            if(Service.ifWon()) win = true;

        }
    }
}