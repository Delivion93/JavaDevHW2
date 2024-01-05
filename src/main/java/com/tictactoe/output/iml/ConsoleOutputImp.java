package com.tictactoe.output.iml;

import com.tictactoe.logic.TicTacToe;
import com.tictactoe.output.ConsoleOutput;

public class ConsoleOutputImp implements ConsoleOutput {

    @Override
    public void gridPrint(char[] grid) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i <= grid.length - 3; i += 3) {
            sb.append(grid[i]).append(" | ").append(grid[i + 1]).append(" | ").append(grid[i + 2]).append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public void endgameMessage(int winner, char[] grid) {
        gridPrint(grid);
        if (winner == TicTacToe.WIN) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == TicTacToe.LOSE) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if (winner == TicTacToe.DRAW) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
        }
    }
}
