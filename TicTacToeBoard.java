/**
 * 
 * This is the Tic Tac Toe board. It's a visual and abstract representation 
 * of the board and has various methods to enable playing the game
 */
package ticTacToe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TicTacToeBoard 
{
	private String[][] board;							/* This 2d array holds the board's marked-down spots */
	private Set<Location> notMarkedDown;        		/*Not marked-down yet locations */
	private Matches matches;							/* These are the potential matches made so far */
	private final int BOARDSIZE;						/*The size of the board, so we know how to initialize it. 
															This is the beginning of extensibility to different board sizes, 
																however it's not fully supported in the algorithm in general*/
	
	/**
	 * 
	 * Initialize the board
	 * I want the code to be more extensible, 
	 * so putting in the option for different board sizes if need be
	 */
	public TicTacToeBoard(int size)
	{
		BOARDSIZE = size;
		board = new String[BOARDSIZE][BOARDSIZE];
		createBoard();
		matches = new Matches(BOARDSIZE);
		notMarkedDown = new HashSet<>();
		fillUpNotMarkedDown();
	}
	
	/**
	 * 
	 * Create the board given the size
	 */
	public void createBoard()
	{
		for(int row=0;row<BOARDSIZE;row++)
		{
			String[] boxes = new String[BOARDSIZE];
			for(int col=0;col<BOARDSIZE; col++)
			{
				boxes[col] = "[ ]";
			}
			this.board[row] = boxes;
		}
	}
	/**
	 * 
	 * Initialize "notMarkedDown" with all the locations on the board
	 */
	public void fillUpNotMarkedDown()
	{
		for(int row=1;row<=BOARDSIZE;row++)
		{
			for(int col=1;col<=BOARDSIZE;col++)
			{
				Location location = new Location(row, col, BOARDSIZE);
				notMarkedDown.add(location);
			}
		}
	}
	
	/** 
	 * 
	 *marks location down correctly, using the correct character for the correct user. 
	 *@param the location the player's chosen
	 *@return boolean whether game is over now or not
	 *@see Matches.add(Location, String, HashSet)
	 */
	
	public boolean mark(Location location, TicTacToePlayer player)
	{
		String userSymbol = player.getSymbol();
		int row = location.getRow();
		int column = location.getColumn();
		/*
		 * check if the location can be marked down
		 */
		if(canMark(location))
		{
			//Mark it down
			addSymbolToBoard(userSymbol, row, column);
			boolean matchIsFull = matches.add(location, player.getName());
			if(matchIsFull)
			{
				return true;
			}
		}else
		{
			throw new InputMismatchException("Already marked Down");
		}
		return false;
	}
	
	/**
	 * 
	 * puts the symbol in specified place
	 */
	public void addSymbolToBoard(String userSymbol, int row, int column)
	{
		board[row][column] = "[" + userSymbol + "]";
	}
	
	/**
	 * 
	 * @return location was already marked down or not
	 */
	public boolean canMark(Location location)
	{
		/*
		 * check and remove from notMarkedDown
		 */
		if(notMarkedDown.contains(location))
		{
			notMarkedDown.remove(location);
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Checks if board is full
	 * @return if board is full
	 */
	public boolean full()
	{
		return notMarkedDown.size() == 0;
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
