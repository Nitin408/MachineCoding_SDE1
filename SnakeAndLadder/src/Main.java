import Model.Ladder;
import Model.Player;
import Model.Snake;
import DAO.Datadao;
import Services.PlayGame;

import java.lang.management.MonitorInfo;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int numberOfSnakes = input.nextInt();

        while(numberOfSnakes>0){
            int startPos = input.nextInt();
            int endPos = input.nextInt();

            Snake newSnake = new Snake(startPos, endPos);
            Datadao.snakeData.add(newSnake);
            numberOfSnakes--;
        }

        int numberOfLadder = input.nextInt();
        while(numberOfLadder>0){
            int startPos = input.nextInt();
            int endPos = input.nextInt();

            Ladder newLadder = new Ladder(startPos, endPos);
            Datadao.ladderData.add(newLadder);
            numberOfLadder--;
        }
        int numberOfPlayer = input.nextInt();
        while(numberOfPlayer>0){
            String playerName = input.next();
            Player newPlayer = new Player(playerName);
            Datadao.playerData.add(newPlayer);
            numberOfPlayer--;
        }

        PlayGame newGame = new PlayGame();
//          System.out.println();
//        Datadao.printLadder();
//        Datadao.printSnake();
        newGame.StartGame();

    }
}


