package com.tictactoe.output;

public interface ConsoleOutput {
    public void gridPrint(char[] grid);

    public void endgameMessage(int winner, char[] grid);

}
