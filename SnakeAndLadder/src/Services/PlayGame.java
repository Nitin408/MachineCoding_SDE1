package Services;

import DAO.Datadao;
import Model.Ladder;
import Model.Player;
import Model.Snake;

import javax.xml.crypto.Data;

import java.util.Random;

import static DAO.Datadao.playerData;

public class PlayGame {

    private Random diceNumber = new Random();

    public void StartGame(){
        boolean isWon = false;
        do{
            for(Player playername: Datadao.playerData){
                int numberOnDice = diceNumber.nextInt(6)+1;
                int playerNewPositon = playername.getCurrentPosition()+numberOnDice;

                if(playerNewPositon>100) playerNewPositon = playername.getCurrentPosition();
                for(Ladder ladder: Datadao.ladderData){
                    playerNewPositon = ladder.getStartPosition()==playerNewPositon ? ladder.getEndPosition() : playerNewPositon;
                }
                for(Snake snake: Datadao.snakeData){
                    playerNewPositon = snake.getStartPosition()==playerNewPositon ? snake.getEndPosition() : playerNewPositon;
                }

                System.out.println(playername.getPlayerName() + " rolled a " + numberOnDice + " and moved from " + playername.getCurrentPosition() + " to " + playerNewPositon);
                playername.setCurrentPosition(playerNewPositon);
                if(playername.getCurrentPosition()==100){
                    System.out.println(playername.getPlayerName() + " Wins the game");
                    isWon = true;
                    break;
                }
            }
        }while(!isWon);
    }
}
