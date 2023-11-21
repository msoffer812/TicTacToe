package ticTacToe;

import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.LinkedList;


public class TicTacToeGame {
	private TicTacToeBoard gameBoard;
	private Queue<TicTacToePlayer> players;
	private Scanner in;
	private final int MAXBOARDSIZE;
	
	public TicTacToeGame(Queue<TicTacToePlayer> players, Scanner input, int size)
	{
		MAXBOARDSIZE = size;
		this.players = players;
		this.gameBoard = new TicTacToeBoard(MAXBOARDSIZE);
		this.in = input;
	}
	
	/**
	 * Starts the game
	 * @see isGameOver()
	 * @see markDown(TicTacToePlayer)
	 * @see endGame(TicTacToePlayer)
	 */
	public void startGame()
	{
		//Declare currentPlayer now, since I don't want to redeclare it in every iteration of the loop
		TicTacToePlayer currentPlayer = null;
		//Refresh the board, get out all the previous stuff from past games
		gameBoard = new TicTacToeBoard(MAXBOARDSIZE);
		boolean gameover = false;
		while(!isGameOver() && !gameover)
		{
			currentPlayer = players.remove();
			System.out.println(currentPlayer.getName() + "'s turn: ");
			System.out.println(gameBoard.toString());
			gameover = markDown(currentPlayer);
			players.add(currentPlayer);
		}
		//Call method to end game - say all the stuff about who won and increments the player's wins
		if(gameover)
		{
			endGame(currentPlayer);
		}else
		{
			endGame(null);
		}
	}
	
	/**
	 * Mark down the location
	 * @return result of marking down - is game over or not?
	 * @see playHumanPlayer(Player)
	 * @see TicTacToeBoard.mark(Location)
	 */
	public boolean markDown(TicTacToePlayer currentPlayer)
	{
		Location whereToMarkDown;
		boolean result = false;
		boolean cont = false;
		do
		{
			cont = false;
			//First play - get user input
			whereToMarkDown = playHumanPlayer(currentPlayer);
			//Then try to mark down
			try
			{
				result = gameBoard.mark(whereToMarkDown, currentPlayer);
			} catch(InputMismatchException e)
			{
				System.out.println("Location already marked down, please reenter");
				cont = true;
			}
		}while(cont);
		return result;
	}
	/**
	 * @return the requested Location of the human player
	 * @see getPlayerInput(String)
	 */
	public Location playHumanPlayer(TicTacToePlayer player)
	{
		Location newLocation = null;
		while(newLocation == null){
			//Get the player input
			int row = getPlayerInput("Enter the row to mark down:");
			int column = getPlayerInput("Enter the column to mark down:");
			newLocation = player.play(row, column, MAXBOARDSIZE);
			if(newLocation == null)
			{
				System.out.println("Invalid input, please reenter a valid board location");
			}
		}
		return newLocation;
	}
	/**
	 * @return player input
	 */
	public int getPlayerInput(String message)
	{
		int input = -1;
		System.out.println(message);
		boolean cont = false;
		do
		{
			if(cont)
			{
				System.out.println("Invalid input, please reenter");
			}
			cont = false;
			try
			{
				input = in.nextInt();
				in.nextLine();
			} catch(InputMismatchException e)
			{
				cont = true;
				in.nextLine();
			}
		}while(cont);
		return input;
	}
	/**
	 * end the game with all the notifications and increment the winner's wins
	 */
	public void endGame(TicTacToePlayer winner)
	{
		if(winner != null)
		{
			System.out.println(gameBoard.toString() + "\n");
			System.out.println("Game Over! The winner is " + winner.getName());
			winner.addWin();
		} else
		{
			System.out.println("Board is full, no one won):");
		}
	}
	/**
	 * @return if game is over by board is full
	 */
	public boolean isGameOver()
	{
		if(gameBoard.full())
		{
			return true;
		}
		return false;
	}
}
