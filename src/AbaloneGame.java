/**
 * This class represents an Abalone game cf :
 * https://en.wikipedia.org/wiki/Abalone_%28board_game%29
 * 
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */
public class AbaloneGame
{
	/**
	 * Board used.
	 */
	private Board board;

	/**
	 * White player
	 */
	private Player whitePlayer;

	/**
	 * Black player
	 */
	private Player blackPlayer;

	/**
	 * Creates a new Abalone game, ready to be played (gameboard is in default
	 * style starting configuration)
	 */
	public AbaloneGame()
	{
		this.board = new Board();
		this.whitePlayer = new Player();
		this.blackPlayer = new Player();
	}


	// @formatter.off
	/**
	 * Allows to play an Abalone game. Allows players to make moves until the game end.
	 * 
	 * Algorithm :
	 * 
	 * current player is white player
	 *  
	 * while (<game is not over>)
	 * do
	 * 		<ask current player for a move>
	 * while (<move is not valid>)
	 * <process move>
	 * <changes current player>
	 * 
	 * */
	// @formatter.on
	public void play()
	{
		Player currentPlayer = this.whitePlayer;
		
		while (!this.isGameOver())
		{
			Move move = null;
			
			do
				currentPlayer.askForMove();
			while(!this.isValidMove(move));
			
			this.moveMarbles(move);
			
			// TODO (ask for advice)
			currentPlayer.changeCurrentPlayer();
		}
	}
	
	/**
	 * Change marble's locations on the board 
	 * @param move Last move
	 */
	private void moveMarbles(Move move)
	{
		// TODO Auto-generated method stub
		
	}
	
	// TODO (ask for advice)
	/**
	 * Check if move is valid
	 * @param move
	 * @return <tt>true</tt> if move is valid, <tt>false</tt> else
	 */
	private boolean isValidMove(Move move)
	{
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Check if game is over
	 * @return <tt>true</tt> if game is over, <tt>false</tt> else
	 */
	private boolean isGameOver()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
