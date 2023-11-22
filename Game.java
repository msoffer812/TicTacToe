package ticTacToe;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game 
{
	public static void main(String[] args)
	{
		//Declare all the resources and starting validation
		Scanner in = new Scanner(System.in);
		int playAgain = 1;
		int createNewGame = 1;
		/*
		 * Has an outer loop which loops while the user still wants to play.
		 * The inner loop loops while the user wants to continue that specific game
		 * Each inner loop is a new round, while each outer loop is a new game
		 */
		while(createNewGame == 1)
		{
			printOutRules();
			Queue<TicTacToeGeneralPlayer> players = createPlayerQueue(in);
			TicTacToeGame game = new TicTacToeGame(players, in, 3);
			playAgain = 1;
			while(playAgain == 1)
			{
				/*
				 * Set off the logic to start to the game. 
				 * The class takes care of the rest
				 */
				game.startGame();
				/*
				 * Print out the current wins so we know where we're holding
				 */
				printWins(players);
				playAgain = intUserInput("1. New Round\n2. End Current Game", 1, 2, in);
			}
			printOutWhoWon(players);
			createNewGame = intUserInput("1. Start a new game\n2. Quit", 1, 2, in);
		}
		//Say goodbye, close resources, exit
		System.out.println("Goodbye!");
		in.close();
		System.exit(0);
	}
	
	/**
	 * 
	 * Print out the rules for the game
	 */
	public static void printOutRules()
	{
		System.out.println("Welcome to Tic Tac Toe!\n\n"
				+ "Two players take turns marking spaces on a 3x3 grid.\n"
					+ "The first to get three of their marks in a row "
						+ "(horizontally, vertically, or diagonally) wins.\n" 
							+ "If the grid fills up before that, "
								+ "the game ends in a draw.\nPlayers, let the fun begin!\n");
	}
	/**
	 * 
	 * Prints out the current amount of wins each player has so far
	 */
	public static void printWins(Queue<TicTacToeGeneralPlayer> players)
	{
		/*
		 * Since if we pull out each player in the queue once, 
		 * and then put back in, the order is maintained, we do that
		 * to access each player's stats so far
		 */
		System.out.println("Current Wins:");
		int size = players.size();
		for(int i=0;i<size;i++)
		{
			TicTacToeGeneralPlayer currPlayer = players.remove();
			System.out.println(currPlayer.getName() + "'s: " + currPlayer.getWins());
			players.add(currPlayer);
		}
	}
	
	/**
	 * 
	 * Prints out who has won the end of the game
	 */
	public static void printOutWhoWon(Queue<TicTacToeGeneralPlayer> players)
	{
		TicTacToeGeneralPlayer player1 = players.remove();
		TicTacToeGeneralPlayer player2 = players.remove();
		if(player1.getWins() > player2.getWins())
		{
			System.out.println("The final winner is " + player1.getName() + " with " + player1.getWins() + " wins!\n");
		}else if(player1.getWins() < player2.getWins())
		{
			System.out.println("The final winner is " + player2.getName() + " with " + player2.getWins() + " wins!\n");
		} else
		{
			System.out.println("The game has ended with a draw, both players have " + player1.getWins() + " wins!");
		}
	}
	
	/**
	 * 
	 * This creates creates the players and initializes a queue of them
	 * @return a filled-up queue of players
	 * @see intUserInput
	 * @see createHumanPlayer
	 */
	public static Queue<TicTacToeGeneralPlayer> createPlayerQueue(Scanner in)
	{
		Queue<TicTacToeGeneralPlayer> players = new LinkedList<>();
		TicTacToeGeneralPlayer player1 = createHumanPlayer(in, 1, "", "");
		TicTacToeGeneralPlayer player2 = createHumanPlayer(in, 2, player1.getName(), player1.getSymbol());
		players.add(player1);
		players.add(player2);
		return players;
	}
	
	/**
	 * 
	 * Create a human player, loops until valid
	 * @return human player
	 * @see stringUserInput
	 * @see HumanPlayer.HumanPlayer()
	 */
	public static TicTacToeGeneralPlayer createHumanPlayer(Scanner in, int i, String pastName, String pastSymbol)
	{
		TicTacToeGeneralPlayer newPlayer = null;
		boolean cont = false;
		/*
		 * Loops while the player's info is entered incorrectly
		 */
		do
		{
			cont = false;
			/*
			 * Call the methods to get user input to get the symbol and the name
			 * Make sure the name/Symbol wasn't used already by passing them into stringUserInput
			 */
			String playerName = stringUserInput("Enter player " + i + "'s name: ", in, pastName);
			String playerSymbol = getPlayerSymbol("Enter symbol for the player to use, either an X or an O ", in, pastSymbol);
			try
			{
				newPlayer = new HumanPlayer(playerName, playerSymbol); 
			} catch(InputMismatchException e)
			{
				System.out.println(e.getMessage());
				cont = true;
			}
		} while(cont);
		return newPlayer;
	}
	
	/**
	 * 
	 * Get the playerSymbol, must be either an x or an o
	 * @return playerSymbol
	 */
	public static String getPlayerSymbol(String message, Scanner in, String pastSymbol)
	{
		boolean cont = false;
		String playerSymbol;
		do
		{
			cont = false;
			playerSymbol = stringUserInput(message, in, pastSymbol).toUpperCase();
			/*
			 * validate the symbol is either an x or an o
			 */
			if(!playerSymbol.equals("X") && !playerSymbol.equals("O"))
			{
				message = "Please enter an X or an O";
				cont = true;
			}
		}while(cont);
		return playerSymbol;
	}
	/**
	 * 
	 * @return numerical user input as to whether to play again, player types, etc.
	 */
	public static int intUserInput(String message, 
			int minInputValue, int maxInputValue, Scanner in)
	{
		int input = -1;
		System.out.println(message);
		boolean cont = false;
		/* 
		 * Loops while the user input is invalid:
		 * either it's not an int or it's below or above the maximum allowed value
		 */
		do
		{
			/*
			 * If loop just ran and there was invalid input, 
			 * print out the prompt to reenter
			 */
			if(cont)
			{
				System.out.println("Invalid input, please reenter");
			}
			cont = false;
			try
			{
				//Get input and keyboard buffer
				input = in.nextInt();
				in.nextLine();
			} catch(InputMismatchException e)
			{
				cont = true;
				in.nextLine();
			}
			
			if(input < minInputValue || input>maxInputValue)
			{
				cont = true;
			}
		}while(cont);
		return input;
	}
	/**
	 * Gets the user input and returns
	 * @return String user input - names, symbol etc.
	 */
	public static String stringUserInput(String message, Scanner in, String notAllowed)
	{
		String ans;
		/*
		 * Loop while the user enters string that isn't allowed
		 * Generally for either a symbol or name that was taken already
		 */
		do
		{
			System.out.println(message);
			ans = in.nextLine().trim();
			message = "Already taken, please reenter";
		} while(ans.toLowerCase().equals(notAllowed.toLowerCase()));
		
		return ans;
	}
}
