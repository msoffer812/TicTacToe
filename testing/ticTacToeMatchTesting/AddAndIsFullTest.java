package ticTacToe.testing.ticTacToeMatchTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ticTacToe.TicTacToeMatch;

public class AddAndIsFullTest {
	private TicTacToeMatch match = new TicTacToeMatch("Meira", 3);
	
	@Test
	public void newlyCreatedMatchIsSizeOneAndIsNotFull() {
		assertEquals(1, match.size());
		assertFalse(match.full());
	}
	
	
	@Test
	public void addToNewMatchMakesItTwoAndIsNotFull() {
		match.add();
		assertEquals(2, match.size());
		assertFalse(match.full());
	}
	
	@Test
	public void addToMatchOfTwoMakesItThreeAndNowIsFull() {
		match.add();
		match.add();
		assertEquals(3, match.size());
		assertTrue(match.full());
	}
	
	@Test
	public void addToFullMatchWontWork() {
		match.add();
		match.add();
		match.add();
		assertFalse(match.size() == 4);
	}

}

