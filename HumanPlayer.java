/**
 * The Player class
 */
package ticTacToe;

import java.util.InputMismatchException;

public class HumanPlayer implements TicTacToePlayer
{
	private String name;				/* Name for user interface purposes */
	private String symbol;				/* Symbol that we want to mark down on the board */
	int wins;							/* wins they've achieved while playing */
	
	public HumanPlayer(String name, String symbol)
	{
		String tempName = name.trim();
		String tempSymbol = symbol.trim();
		validateName(tempName);
		validateSymbol(tempSymbol);
		wins = 0;
		this.symbol = tempSymbol;
		this.name = tempName;
	}
	
	/**
	 * 
	 * Validate name input for declaring human player
	 */
	private void validateName(String name)
	{
		if(name.length() < 1)
		{
			throw new InputMismatchException("Invalid name");
		} 
	}
	
	/**
	 * 
	 * Validate symbol input for declaring human player
	 */
	private void validateSymbol(String symbol)
	{
		if(symbol.length() != 1)
		{
			throw new InputMismatchException("Symbol must be one character long");
		}
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
		return true;
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
