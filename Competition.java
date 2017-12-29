import java.util.Scanner;

/**
 * The Competition class represents a Nim competition between two players, consisting of a given number of rounds. 
 * It also keeps track of the number of victories of each player.
 */

public class Competition {
	/** represent the id of the first and second player **/
	private static final int FIRST_ID = 1;
	private static final int SECOND_ID = 2;
	/** each competition has 2 players that play against each other **/
	Player player1;

	Player player2;

    /** saves the scores of each player during the competition **/
	int[] scores = new int[2];

	/** determines whether to display questions to the user or not **/
	boolean displayMessage;

    /**
     * Initializing a new Competition.
     * @param player1 the first player.
     * @param player2 the second player.
     * @param displayMessage determines whether to display questions to the user or not.
     */
	public Competition(Player player1, Player player2, boolean displayMessage){
		this.player1 = player1;
		this.player2 = player2;
		this.displayMessage = displayMessage;
	}

	/**
	 *
	 * @param playerPosition the number of the player. Should be 1 or 2.
	 * @return the number of victories of a player. If the playerPosition is not 1 or 2, returns -1.
     */
	public int getPlayerScore(int playerPosition){
		if (playerPosition != 1 && playerPosition != 2)
			return -1;
		return scores[playerPosition - 1];
	}

	/*
	 * Returns the integer representing the type of player 1; returns -1 on bad
	 * input.
	 */
	private static int parsePlayer1Type(String[] args){
		try{
			return Integer.parseInt(args[0]);
		} catch (Exception E){
			return -1;
		}
	}
	
	/*
	 * Returns the integer representing the type of player 2; returns -1 on bad
	 * input.
	 */
	private static int parsePlayer2Type(String[] args){
		try{
			return Integer.parseInt(args[1]);
		} catch (Exception E){
			return -1;
		}
	}
	
	/*
	 * Returns the integer representing the type of player 2; returns -1 on bad
	 * input.
	 */
	private static int parseNumberOfGames(String[] args){
		try{
			return Integer.parseInt(args[2]);
		} catch (Exception E){
			return -1;
		}
	}

	/**
	 * Runs the competition for numRounds rounds.
	 * @param numRounds determines how many rounds the competition is.
     */
	public void playMultiple(int numRounds) {
		for (int i = 0; i < numRounds; i++) {
			Board board = new Board();
			if (displayMessage)
				System.out.println("Welcome to the sticks game!");
			Player current = player1;
			while (board.getNumberOfUnmarkedSticks() > 0) { // while there are still sticks on board the
				// game continues
				if (displayMessage)
					System.out.println("Player " + current.getPlayerId() + ", it is now your turn!");
				Move currentMove = current.produceMove(board);
				while (board.markStickSequence(currentMove) < 0) {
					if (displayMessage)
						System.out.println("Invalid move. Enter another:");
					currentMove = current.produceMove(board);
				}
				if (displayMessage)
					System.out.println("Player " + current.getPlayerId() + " made the move: " +
							currentMove.toString());
				// Now it is the other player's turn
				if (current == player1)
					current = player2;
				else
					current = player1;
			}
			scores[current.getPlayerId() - 1]++;
			if (displayMessage)
				System.out.println("Player " + current.getPlayerId() + " won!");
		}
		System.out.println("The results are " + getPlayerScore(FIRST_ID) + ":" + getPlayerScore(SECOND_ID));
	}

	/**
	 * The method runs a Nim competition between two players according to the three user-specified arguments. 
	 * (1) The type of the first player, which is a positive integer between 1 and 4: 1 for a Random computer
	 *     player, 2 for a Heuristic computer player, 3 for a Smart computer player and 4 for a human player.
	 * (2) The type of the second player, which is a positive integer between 1 and 4.
	 * (3) The number of rounds to be played in the competition.
	 * @param args an array of string representations of the three input arguments, as detailed above.
	 */
	public static void main(String[] args) {
		int p1Type = parsePlayer1Type(args);
		int p2Type = parsePlayer2Type(args);
		int numGames = parseNumberOfGames(args);
		Scanner scanner = new Scanner(System.in);
		Player player1 = new Player(p1Type, FIRST_ID, scanner);
		Player player2 = new Player(p2Type, SECOND_ID, scanner);
		boolean displayMsg = false;
		if (p1Type == Player.HUMAN || p2Type == Player.HUMAN)
			displayMsg = true;
		Competition competition = new Competition(player1, player2, displayMsg);
 		System.out.println("Starting a Nim competition of " + numGames + " rounds between a "
							+ player1.getTypeName() + " player and a " + player2.getTypeName() + " player.");
		competition.playMultiple(numGames);
		scanner.close();
	}
}
