package ticTacToe.testing.humanPlayerTesting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import ticTacToe.HumanPlayer;
import ticTacToe.Location;

class ConstructorExceptionsTest {

	@Test
	void emptySymbolThrowsException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new HumanPlayer("Meira", ""));
	}
	
	@Test
	void symbolLengthOverOneThrowsException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new HumanPlayer("Meira", "ABC"));
	}
	
	@Test
	void emptyNameThrowsException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new HumanPlayer("", "O"));
	}
	
	@Test
	void whitespaceNameThrowsException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new HumanPlayer("    ", "O"));
	}
	
	@Test
	void whitespaceSymbolThrowsException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new HumanPlayer("Meira", " "));
	}

}
