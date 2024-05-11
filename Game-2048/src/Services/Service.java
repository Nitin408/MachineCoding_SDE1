package Services;

import DAODATA.DaoData;

import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Service {

    public void fillNewNumber(){
        int row, col;
        Random random = new Random();
        do {
            row = random.nextInt(4);
            col = random.nextInt(4);
        } while (DaoData.grid[row][col] != 0);

        DaoData.grid[row][col] = 2;
    }

    public boolean ifRemainingEmpty(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(DaoData.grid[i][j]==0) return true;
            }
        }
        return false;
    }

    public static boolean ifWon(){
        for (int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(DaoData.grid[i][j]==2048) return true;
            }
        }
        return false;
    }

    public void getStackRowLeft(int rowNumber) {
        Stack<Integer> temp = new Stack<>();
        for(int j=0; j<4; j++){
            int num = DaoData.grid[rowNumber][j];
            if(!temp.isEmpty() && temp.peek()==num && num!=0){
                temp.pop();
                temp.push(2*num);
            }
            else if(num!=0) temp.push(num);
        }

        int remaining = 4-temp.size();
        for(int i=0; i<remaining; i++){
            temp.push(0);
        }

        for(int j=3; j>=0; j--){
            DaoData.grid[rowNumber][j] = temp.peek();
            temp.pop();
        }
    }

    public void getStackRowRight(int rowNumber) {
        Stack<Integer> temp = new Stack<>();
        for(int j=3; j>=0; j--){
            int num = DaoData.grid[rowNumber][j];
            if(!temp.isEmpty() && temp.peek()==num && num!=0){
                temp.pop();
                temp.push(2*num);
            }
            else if(num!=0) temp.push(num);
        }

        int remaining = 4-temp.size();
        for(int i=0; i<remaining; i++){
            temp.push(0);
        }

        for(int j=0; j<4; j++){
            DaoData.grid[rowNumber][j] = temp.peek();
            temp.pop();
        }
    }

    public void getStackColTop(int colNumber) {
        Stack<Integer> temp = new Stack<>();
        for(int i=0; i<4; i++){
            int num = DaoData.grid[i][colNumber];
            if(!temp.isEmpty() && temp.peek()==num && num!=0){
                temp.pop();
                temp.push(2*num);
            }
            else if(num!=0) temp.push(num);
        }

        int remaining = 4-temp.size();
        for(int i=0; i<remaining; i++){
            temp.push(0);
        }

        for(int i=3; i>=0; i--){
            DaoData.grid[i][colNumber] = temp.peek();
            temp.pop();
        }
    }

    public void getStackColBottom(int colNumber) {
        Stack<Integer> temp = new Stack<>();
        for(int j=3; j>=0; j--){
            int num = DaoData.grid[j][colNumber];
            if(!temp.isEmpty() && temp.peek()==num && num!=0){
                temp.pop();
                temp.push(2*num);
            }
            else if(num!=0) temp.push(num);
        }

        int remaining = 4-temp.size();
        for(int i=0; i<remaining; i++){
            temp.push(0);
        }

        for(int j=0; j<4; j++){
            DaoData.grid[j][colNumber] = temp.peek();
            temp.pop();
        }
    }

    public void moveLeft(){
        for(int i=0; i<4; i++){
            getStackRowLeft(i);
        }

    }

    public void moveRight(){
        for(int i=0; i<4; i++){
            getStackRowRight(i);
        }
    }

    public void moveTop(){
        for(int i=0; i<4; i++){
            getStackColTop(i);
        }
    }

    public void moveBottom(){
        for(int i=0; i<4; i++){
            getStackColBottom(i);
        }
    }

    public void playGame(int move){
        switch (move){
            case 0:
                moveLeft();
                break;
            case 1:
                moveRight();
                break;
            case 2:
                moveTop();
                break;
            case 3:
                moveBottom();
                break;
            default:
                System.out.println("Invalid input");
        }

        if(ifWon()){
            DaoData.printGrid();
            System.out.println("Congratulation");
            return;
        }
        if(! ifRemainingEmpty()){
            DaoData.printGrid();
            System.out.println("Game Over");
        }else{
            fillNewNumber();
            DaoData.printGrid();
        }
    }
}
