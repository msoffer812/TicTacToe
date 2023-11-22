/**
 * The Player class
 */
package ticTacToe;

import java.util.InputMismatchException;

public class HumanPlayer extends TicTacToeGeneralPlayer
{
	
	public HumanPlayer(String name, String symbol)
	{
		super(name.trim(), symbol.trim());
		String tempName = name.trim();
		String tempSymbol = symbol.trim();
		validateName(tempName);
		validateSymbol(tempSymbol);
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
	 * @return whether the player is human or not in the game.
	 * That changes how we implement their turn if there's a computer player
	 */
	@Override
	public boolean isHuman()
	{
		return true;
	}
}
