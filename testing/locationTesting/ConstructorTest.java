package ticTacToe.testing.locationTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.util.InputMismatchException;

import org.junit.Test;

import ticTacToe.Location;


public class ConstructorTest{

	@Test
	public void negativeOneRowThrowsInputMismatchException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new Location(-1, 1 , 3));
	}

	@Test
	public void negativeColumnThrowsInputMismatchException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new Location(1, -1, 3));
	}
	
	@Test
	public void rowAbove3ThrowsInputMismatchException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new Location(4, 1, 3));
	}
	
	@Test
	public void columnAbove3ThrowInputMismatchsException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new Location(1, 4, 3));
	}
	
	@Test
	public void rowOfZeroThrowsInputMismatchException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new Location(0, 1, 3));
	}
	
	@Test
	public void columnOfZeroThrowsInputMismatchException() {
		InputMismatchException e = assertThrows(InputMismatchException.class, () -> new Location(1, 0, 3));
	}
	
	@Test
	public void InputOfRow1Column1CreatesNewLocationWithCorrespondingValues() {
		Location newLocation = new Location(1, 1, 3);
		assertEquals(0, newLocation.getRow());
		assertEquals(0, newLocation.getColumn());
	}
	
	@Test
	public void InputOfRow2Column2CreatesNewLocationWithCorrespondingValues() {
		Location newLocation = new Location(2, 2, 3);
		assertEquals(1, newLocation.getRow());
		assertEquals(1, newLocation.getColumn());
	}
	
	@Test
	public void InputOfRow3Column3CreatesNewLocationWithCorrespondingValues() {
		Location newLocation = new Location(3, 3, 3);
		assertEquals(2, newLocation.getRow());
		assertEquals(2, newLocation.getColumn());
	}

}
