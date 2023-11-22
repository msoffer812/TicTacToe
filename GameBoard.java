/**
 * interface for a general board that can be reused 
 */
package ticTacToe;

public interface GameBoard {
	void createBoard(String boardSymbol);
	boolean canMark(Location location);
	void resetBoard();
	String toString();
}
