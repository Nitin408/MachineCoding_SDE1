package DAODATA;

import java.util.Random;

public class DaoData {
    public static int[][] grid = {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}};

    public static void initiateGrid(){
        Random ram = new Random();
        int xPos1 = ram.nextInt(4);
        int xPos2 = ram.nextInt(4);
        int yPos1 = ram.nextInt(4);
        int yPos2 = ram.nextInt(4);

        grid[xPos1][yPos1] = 2;
        grid[xPos2][yPos2] = 2;
    }

    public static void printGrid(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(grid[i][j]!=0) System.out.print(grid[i][j] + " ");
                else System.out.print('-' + " ");
            }
            System.out.println();
        }
    }
}
