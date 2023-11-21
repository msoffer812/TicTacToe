/**
 * 
 * Enum for types of matches that can be made the 
 * Tic Tac Toe Board. Good for logic, easier than having 
 * strings to compare and using .equals a lot,
 * or introducing bugs by misspelling the match type
 * 
 * However, this prevents extensibility to different board types
 * Really, there should be some kind of dynamic way of adding new columns and rows.
 * However, that's beyond the scope of the project
 */
package ticTacToe;

public enum MatchType {
	DIAGONALRIGHTTOLEFT, DIAGONALLEFTTORIGHT, COLUMN0, COLUMN1, COLUMN2, ROW0, ROW1, ROW2
}
