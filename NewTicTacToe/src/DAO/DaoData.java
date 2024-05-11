package DAO;

import Model.Player;

import java.util.ArrayList;

public class DaoData {

    public static char grid[][] = {{'-','-','-'}, {'-','-','-'}, {'-','-','-'}};
    public static ArrayList<Player> playerData = new ArrayList<Player>();
    public static ArrayList<Integer> playerMovesX = new ArrayList<>();
    public static ArrayList<Integer> playerMovesY = new ArrayList<>();


    public static void printGrid(){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
