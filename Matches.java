/**
 * Holds all the made matches
 * Helpful because implements the logic for adding a location for a match
 * rather than it going in the main game
 */
package ticTacToe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Matches 
{
	private HashMap<MatchType, TicTacToeMatch> matches; /* Holds all the matches made, for easy access */
	private final int MATCHSIZE;						/* The max size a match can be - over that, can't add to the match */
	
	public Matches(int size)
	{
		matches = new HashMap<>();
		this.MATCHSIZE = size;
	}
	
	/**
	 * 
	 * Add a location to the board
	 * get the potential matches from the location,
	 * for each put down in matches
	 * @return if the match is now full
	 * @param Location location to mark down, String player who made it
	 */
	public boolean add(Location location, String player)
	{
		/*
		 * The location generates a list of all its potential matches. 
		 * First we get that
		 * */
		List<MatchType> potentialMatches = location.getPotentialMatches();
		/*
		 * Now we loop through those matches, 
		 * adding to a match where need be or creating a new match
		 */
		for(MatchType type:potentialMatches)
		{
			/*
			 * If matches contains the match already, 
			 * and this is the player who made it, add the match 
			 * and return if it's full
			 */
			if(matches.containsKey(type))
			{
				/*
				 * If this isn't the player who made it, there's no point
				 * in adding the match as neither player will ever get to finish it anyways
				 */
				if(matches.get(type).playerWhoMadeIt.equals(player))
				{
					matches.get(type).add();
					if(matches.get(type).full())
					{
						return true;
					}
				}
			/*
			 * Otherwise create a new match	
			 */
			}else
			{
				matches.put(type, new TicTacToeMatch(player, MATCHSIZE));
			}
		}
		return false;
	}
}
