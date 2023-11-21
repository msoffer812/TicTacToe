package ticTacToe.testing.humanPlayerTesting;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

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
	
	@Test
	void negativeOneRowReturnsNull() 
	{
		assertNull(player.play(-1, 3, 3));
	}
	
	@Test
	void fourColumnSizeThreeReturnsNull() 
	{
		assertNull(player.play(2, 4, 3));
	}
	
	@Test
	void negativeOneColumnFourRowSizeThreeReturnsNull() 
	{
		assertNull(player.play(4, -1, 3));
	}

}
