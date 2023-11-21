/**
 * 
 * Interface for player, can be extended to human or computer player
 */
package ticTacToe;

public interface TicTacToePlayer extends Player{
	Location play(int row, int col, int max);
	boolean isHuman();
	String getName();
	String getSymbol();
	void addWin();
	int getWins();
}
