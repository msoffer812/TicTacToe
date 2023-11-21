/**
 * 
 * This class holds locations which are matches, made to see if there's a match in the board
 */
package ticTacToe;

import java.util.List;

public class TicTacToeMatch {
	private int size;				/* Specifies the size of the match - when it's three it's full */
	private final int MAXSIZE;		/* The max size of a match - after this can't add */
	String playerWhoMadeIt;			/* Says who made the match */
	
	/**
	 * 
	 * Constructor - need to start with a location
	 */
	public TicTacToeMatch(String playerName, int maxSize)
	{
		this.MAXSIZE = maxSize;
		this.playerWhoMadeIt = playerName;
		this.size = 1;
	}
	
	/**
	 * 
	 * Add one to the match
	 */
	public void add()
	{
		if(size<MAXSIZE)
		{
			size++;
		}
	}
	
	/**
	 * 
	 * @return the size of the match
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * 
	 * @return name of the player who made the match
	 */
	public String playerWhoMadeIt()
	{
		return this.playerWhoMadeIt;
	}
	/**
	 * 
	 * @return if the match is complete - that is, it's size is three
	 */
	public boolean full()
	{
		return size == MAXSIZE;
	}
}
