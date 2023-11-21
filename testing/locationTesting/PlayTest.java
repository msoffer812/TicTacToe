package ticTacToe.testing.locationTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ticTacToe.HumanPlayer;
import ticTacToe.Location;
import ticTacToe.TicTacToePlayer;

class PlayTest {
	TicTacToePlayer player;
	
	@BeforeEach
	void initializePlayer()
	{
		player = new HumanPlayer("Meira", "X");
	}
	@Test
	void row2Col3Max3InputReturnsValidLocation() 
	{
		Location location = player.play(2, 3, 3);
		assertEquals(1, location.getRow());
		assertEquals(2, location.getColumn());
	}

}
