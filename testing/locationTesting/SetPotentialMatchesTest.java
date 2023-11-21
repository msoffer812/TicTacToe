/**
 * 
 * Test that all locations are assigned
 * correct potential matches
 */
package ticTacToe.testing.locationTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import ticTacToe.Location;
import ticTacToe.MatchType;

public class SetPotentialMatchesTest {

	@Test
	public void middleSquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(2, 2, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN1, MatchType.ROW1, MatchType.DIAGONALRIGHTTOLEFT, MatchType.DIAGONALLEFTTORIGHT));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	
	@Test
	public void row1Col1LocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(1, 1, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN0, MatchType.ROW0, MatchType.DIAGONALLEFTTORIGHT));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	
	@Test
	public void row1Col2SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(1, 2, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN1, MatchType.ROW0));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	
	@Test
	public void row1Col3SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(1, 3, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN2, MatchType.ROW0, MatchType.DIAGONALRIGHTTOLEFT));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	
	@Test
	public void row2Col1SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(2, 1, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN0, MatchType.ROW1));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	
	@Test
	public void row2Col3SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(2, 3, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN2, MatchType.ROW1));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	@Test
	public void row3Col1SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(3, 1, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN0, MatchType.ROW2, MatchType.DIAGONALRIGHTTOLEFT));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}
	
	@Test
	public void row3Col2SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(3, 2, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN1, MatchType.ROW2));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}

	@Test
	public void row3Col3SquareLocationGeneratesAllCorrectPotentialMatches() {
		Location newLocation = new Location(3, 3, 3);
		List<MatchType> potentialMatches = new ArrayList<>();
		potentialMatches.addAll(List.of(MatchType.COLUMN2, MatchType.ROW2, MatchType.DIAGONALLEFTTORIGHT));
		Collections.sort(potentialMatches);
		assertEquals(potentialMatches, newLocation.getPotentialMatches());
	}


}
