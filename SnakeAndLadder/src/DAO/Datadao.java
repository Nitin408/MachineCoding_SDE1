package DAO;

import Model.Ladder;
import Model.Player;
import Model.Snake;

import java.util.ArrayList;
import java.util.Map;

public class Datadao {
    public static ArrayList<Snake> snakeData = new ArrayList<Snake>();
    public static ArrayList<Ladder> ladderData = new ArrayList<Ladder>();
    public static ArrayList<Player> playerData = new ArrayList<Player>();

    public static void printSnake(){
        for(Snake snake: snakeData){
            System.out.println("printing snake " + snake.getStartPosition() + " " + snake.getEndPosition());
        }
    }
    public static void printLadder(){
        for(Ladder ladder: ladderData){
            System.out.println("printing Ladder " + ladder.getStartPosition() + " " + ladder.getEndPosition());
        }
    }

}
