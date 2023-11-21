/**
 * 
 * This represents the x'ed spot of the location
 */
package ticTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;

public class Location 
{
	/*
	 * This is the location the player marks down: row and column
	 */
	private int[] location;
	private List<MatchType> potentialMatches;
	private final int MAXINDEX;

	/**
	 * constructor
	 * @see isValid(int r, int c)
	 */
	public Location(int r, int c, int max)
	{
		this.MAXINDEX = max;
		location = new int[2];
		/*
		 * Check to make sure it's a valid location on the board - since the board is 3X3 can't be greater than two or less than 0
		 */
		if(!isValid(r-1, c-1))
		{
			throw new InputMismatchException("Invalid board location");
		}else /* If it's valid */
		{
			location[0] = r-1;//row
			location[1] = c-1;//column
			potentialMatches = new ArrayList<>();
			setPotentialMatches(r-1, c-1);
		}
	}
	/**
	 * @param int row, int column spot on board
	 * @return boolean is valid location
	 */
	public boolean isValid(int r, int c)
	{
		return r>=0 && c>= 0 && r<MAXINDEX && c<MAXINDEX;
	}
	public int[] getLocation()
	{
		return location;
	}
	public int getRow()
	{
		return location[0];
	}
	public int getColumn()
	{
		return location[1];
	}
	
	/**
	 * @param int row, int column given for location
	 * finds potential matches it can be part of and sets them.
	 * In an ideal world, the setPotentialMatches would be 
	 * dynamic to allow boards of different sizes. However, 
	 * that goes beyond the bounds of the project
	 */
	public void setPotentialMatches(int r, int c)
	{
		if(c == 0)
		{
			potentialMatches.add(MatchType.COLUMN0);
			if(r==0)
			{
				potentialMatches.add(MatchType.DIAGONALLEFTTORIGHT);
				potentialMatches.add(MatchType.ROW0);
			}else if(r == 1)
			{
				potentialMatches.add(MatchType.ROW1);
			}else
			{
				potentialMatches.add(MatchType.ROW2);
				potentialMatches.add(MatchType.DIAGONALRIGHTTOLEFT);
			}
		} else if(c==1)
		{
			potentialMatches.add(MatchType.COLUMN1);
			if(r==0)
			{
				potentialMatches.add(MatchType.ROW0);
			}else if(r == 1)
			{
				potentialMatches.add(MatchType.ROW1);
				potentialMatches.add(MatchType.DIAGONALRIGHTTOLEFT);
				potentialMatches.add(MatchType.DIAGONALLEFTTORIGHT);
			}else
			{
				potentialMatches.add(MatchType.ROW2);
			}
		} else
		{
			potentialMatches.add(MatchType.COLUMN2);
			if(r==0)
			{
				potentialMatches.add(MatchType.DIAGONALRIGHTTOLEFT);
				potentialMatches.add(MatchType.ROW0);
			}else if(r == 1)
			{
				potentialMatches.add(MatchType.ROW1);
			}else
			{
				potentialMatches.add(MatchType.DIAGONALLEFTTORIGHT);
				potentialMatches.add(MatchType.ROW2);
			}
		}
		Collections.sort(potentialMatches);
	}
	/**
	 * @return potential matches
	 */
	public List<MatchType> getPotentialMatches()
	{
		return this.potentialMatches;
	}
	
	/**
	 * @return if a location is equal to this - for hashset
	 */
	@Override
	public boolean equals(Object o)
	{
		Location newLocation = (Location) o;
		return location[0] == newLocation.getRow() && location[1] == newLocation.getColumn();
	}
	
	/**
	 * Override standard hashing so a hashset recognizes that two object match
	 */
	 @Override
	    public int hashCode() {
	        return Arrays.hashCode(location);
	    }
	
}
