package Service;

import DAO.DaoData;

import static DAO.DaoData.*;

public class Service {

    boolean checkIfwon(int playerTurn){
        boolean ans = false;

        for(int i=0; i<3; i++){
            if(grid[i][0]==grid[i][1] && grid[i][1]==grid[i][2] && grid[i][1]!='-') ans = true;
            if(grid[0][i]==grid[1][i] && grid[1][i]==grid[2][i] && grid[1][i]!='-') ans = true;
        }

        if(grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2] && grid[0][0]!='-') ans = true;
        if(grid[2][0]==grid[1][1] && grid[1][1]==grid[0][2] && grid[1][1]!='-') ans = true;

        return ans;

    }


    boolean isValid(int row, int coloumn){
        if(grid[row][coloumn]!='-') return false;
        else return true;
    }

    public void playGame(){
        int playerTurn=0;
        boolean isWon = false;

        DaoData.printGrid();
        System.out.println();

        for(int i = 0; i< playerMovesX.size(); i++) {
            if (isValid(playerMovesX.get(i), playerMovesY.get(i))) {
                grid[playerMovesX.get(i)][playerMovesY.get(i)] = playerTurn == 0 ? 'X' : 'O';

                DaoData.printGrid();
                System.out.println();

                if (checkIfwon(playerTurn)) {
                    System.out.println(playerData.get(playerTurn).getPlayerName() + " won the game");
                    isWon = true;
                    return;
                }

                playerTurn = playerTurn==0 ? 1: 0;

            }else {
                System.out.println("Invalid move");

                System.out.println();
                DaoData.printGrid();
                System.out.println();
            }
        }

        System.out.println("Game Over Lodus");

    }
}
