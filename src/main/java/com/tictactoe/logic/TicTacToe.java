package com.tictactoe.logic;

import com.tictactoe.output.ConsoleOutput;
import com.tictactoe.output.iml.ConsoleOutputImp;

import java.util.Scanner;

public class TicTacToe {
    ConsoleOutput consoleOutput = new ConsoleOutputImp();
    Scanner scan = new Scanner(System.in);
    byte input;
    byte rand;
    byte i;
    boolean boxAvailable = false;
    public static final byte IN_GAME = 0;
    public static final byte WIN = 1;
    public static final byte LOSE = 2;
    public static final byte DRAW = 3;
    byte winner=IN_GAME;
    char[] grid = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    boolean isGameStarted = false;


    public void gameStart() {

        System.out.println("Enter box number to select. Enjoy!\n");
        consoleOutput.gridPrint(grid);
        startGrid();
        while (winner==IN_GAME) {
            playerTurn();
            consoleOutput.gridPrint(grid);
            if(checkWin(grid,'X')){
                winner=WIN;
            }

            if (!isCellAvailable()) {
                winner = DRAW;
                break;
            }

            pcTurn();
            consoleOutput.gridPrint(grid);
            if(checkWin(grid,'0')){
                winner=LOSE;
            }

        }
        consoleOutput.endgameMessage(winner, grid);
    }
    private void playerTurn(){
        do {
            input = scan.nextByte();
            if (input > 0 && input < 10) {

                if (grid[input - 1] == 'X' || grid[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    grid[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }while(grid[input-1]!='X');
    }
    private void pcTurn(){
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (grid[rand - 1] != 'X' && grid[rand - 1] != 'O') {
                grid[rand - 1] = 'O';
                break;
            }
        }
    }

    private boolean checkWin(char[] grid, char symbol) {

        return (checkRows(grid, symbol) || checkColumns(grid, symbol) || checkDiagonals(grid, symbol));
    }

    private boolean checkRows(char[] grid, char symbol) {
        for (int cell = 0; cell < 3; cell++) {
            if (grid[cell * 3] == symbol && grid[cell * 3 + 1] == symbol && grid[cell * 3 + 2] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(char[] grid, char symbol) {
        for (int cell = 0; cell < 3; cell++) {
            if (grid[cell] == symbol && grid[cell + 3] == symbol && grid[cell + 6] == symbol) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(char[] grid, char symbol) {
        return (grid[0] == symbol && grid[4] == symbol && grid[8] == symbol) ||
                (grid[2] == symbol && grid[4] == symbol && grid[6] == symbol);
    }
    private boolean isCellAvailable(){
        for (i = 0; i < 9; i++) {
            if (grid[i] != 'X' && grid[i] != 'O') {
                return true;
            }
        }
        return false;
    }
    private void startGrid(){
        for (i = 0; i < 9; i++){
            grid[i] = ' ';
        }
        isGameStarted = true;
    }
}
