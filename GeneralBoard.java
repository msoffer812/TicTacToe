/**
 * General Board class that can be reused in a bunch of different ways
 */
package ticTacToe;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

public class GeneralBoard implements GameBoard
{
	protected String[][] board;					/* This 2d array holds the representation of the board*/
	private final String boardSymbol;
	protected final int BOARDSIZE;				/*The size of the board, so we know how to initialize it. 
													This is the beginning of extensibility to different board sizes, 
														however it's not fully supported in the algorithm in general*/
	
	/**
	 * 
	 * Initialize the board
	 * I want the code to be more extensible, 
	 * so putting in the option for different board sizes if need be
	 */
	public GeneralBoard(int size, String boardSymbol)
	{
		BOARDSIZE = size;
		this.boardSymbol = boardSymbol;
		resetBoard();
	}
	
	/**
	 * 
	 * Create the board given the size
	 */
	public void createBoard(String boardSymbol)
	{
		for(int row=0;row<BOARDSIZE;row++)
		{
			String[] boxes = new String[BOARDSIZE];
			for(int col=0;col<BOARDSIZE; col++)
			{
				boxes[col] = boardSymbol;
			}
			this.board[row] = boxes;
		}
	}
	
	/**
	 * reset the board when starting a new round
	 */
	@Override
	public void resetBoard()
	{
		board = new String[BOARDSIZE][BOARDSIZE];
		createBoard(boardSymbol);
	}
	
	/**
	 * 
	 * @return if you can mark down a specific location. Default true
	 */
	public boolean canMark(Location location)
	{
		return true;
	}
	
	/**
	 * 
	 * @return the board as a string to print out
	 */
	public String toString()
	{
		/*
		 * Use a StringBuilder to save memory
		 */
		StringBuilder boardToString = new StringBuilder();
		
		/*
		 * First loop to add the column numbers
		 */
		for(int i=1;i<=BOARDSIZE;i++)
		{
			boardToString.append("  " + i);
		}
		boardToString.append('\n');      			/* Start a new line for the board */
		
		for(int row=0;row<BOARDSIZE;row++)
		{
			boardToString.append(row+1);		  	/*Row Numbers*/
			for(int col=0;col<BOARDSIZE;col++)
			{
				boardToString.append(board[row][col]); /*Actual Board Squares*/
			}
			boardToString.append('\n');
		}
		return boardToString.toString();
	}
}
