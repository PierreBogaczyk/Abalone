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
	 * Creates a new Abalone game, ready to be played (gameboard is in default
	 * style starting configuration)
	 */
	public AbaloneGame()
	{
		this.board = new Board();
	}

	/**
	 * Creates player
	 */
	public void player()
	{
				
	}
	
	// TODO(done) fix comment (this is not only about beginning the game)
	// TODO detail comment (what is the main algorithm?)
	/**
	 * Allows to play an Abalone game. Allows players to make moves until the game end.
	 * 
	 * Algorithm :
	 * 
	 * initializes board
	 * 
	 * player round <- white player
	 *  
	 * while number of marbles of white player > 8 
	 * 	and number of marbles of black player > 8
	 * 		sends instruction of a player to move marbles
	 * 
	 * 		gives movement instruction 
	 * 
	 * 		modifies board with new locations of marbles
	 * 
	 * 		if marbles of a color is out 
	 * 			number of marbles <- number of marbles - number of marbles out in this round
	 * 
	 * 		if player round == white player
	 * 			player round <- black player
	 * 		
	 * 		else player round <- white player
	 * 
	 * 		sends to screen numbers of marbles to each color
	 * 			
	 * if number of marbles of white player =< 8
	 * 		sends notification : "Black player wins this game"
	 * 
	 *  else sends notification : "White player wins this game"
	 */
	public void play()
	{

	}

}
