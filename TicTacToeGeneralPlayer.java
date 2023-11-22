/**
 * The General Player class -
 * Can be extended by different kinds of tic tac toe player
 */
package ticTacToe;

import java.util.InputMismatchException;

public class TicTacToeGeneralPlayer implements TicTacToePlayer
{
	protected String name;				/* Name for user interface purposes */
	protected String symbol;				/* Symbol that we want to mark down on the board */
	protected int wins;							/* wins they've achieved while playing */
	
	public TicTacToeGeneralPlayer(String name, String symbol)
	{
		this.name = name;
		this.symbol = symbol;
		wins = 0;
	}
	
	/**
	 * 
	 * Catch some possible errors
	 * @return converted player's choice into a Location
	 */
	@Override
	public Location play(int row, int col, int max)
	{
		Location location;
		try
		{
			location = new Location(row, col, max);
		}catch(InputMismatchException e)
		{
			return null;
		}
		return location;
	}
	
	/**
	 * 
	 * @return player's symbol
	 */
	@Override
	public String getSymbol()
	{
		return symbol;
	}
	
	/**
	 * 
	 * @return player's name
	 */
	@Override
	public String getName()
	{
		return name;
	}
	
	/**
	 * 
	 * @return whether the player is human or not in the game.
	 * That changes how we implement their turn if there's a computer player
	 */
	@Override
	public boolean isHuman()
	{
		return false;
	}
	/**
	 * 
	 * Increment the wins achieved
	 */
	@Override
	public void addWin()
	{
		wins++;
	}
	/**
	 * @return the amount of wins achieved
	 */
	@Override
	public int getWins()
	{
		return this.wins;
	}
}
