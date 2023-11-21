package ticTacToe.testing.matchesTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import ticTacToe.HumanPlayer;
import ticTacToe.Location;
import ticTacToe.Matches;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AddTest {
	static Matches matches;
	static HumanPlayer player;
	@BeforeAll
	static void initializeMatch() {
		matches = new Matches(3);
	}
	
	@Test
	@Order(1)
	void matchOfOneReturnsFalse()
	{
		assertFalse(matches.add(new Location(1, 1, 3), "Meira"));
	}
	
	@Test
	@Order(2)
	void newPlayerCompletesMatchReturnsFalse()
	{
		assertFalse(matches.add(new Location(2, 1, 3), "Tova"));
		assertFalse(matches.add(new Location(3, 1, 3), "Tova"));
	}
	
	@Test
	@Order(3)
	void playerAddsSecondToDiagonalMatchReturnsFalse()
	{
		assertFalse(matches.add(new Location(2, 2, 3), "Meira"));
	}
	
	@Test
	@Order(4)
	void completedMatchReturnsTrue()
	{
		assertTrue(matches.add(new Location(3, 3, 3), "Meira"));
	}

}
