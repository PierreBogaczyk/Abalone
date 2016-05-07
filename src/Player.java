import java.util.Scanner;

// TODO fix comment (ask for advice)
/**
 * This class represents a player of an Abalone game
 * 
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */

public class Player
{
	/**
	 * Ask current player to move
	 * @return
	 */
	public Move askForMove()
	{
		Scanner sc = new Scanner(System.in);
		
		String demandedMoveString = sc.nextLine();
		String[] demandedMove = demandedMoveString.split("-");
		
		String moveDirectionNumber = demandedMove[0];
		String movedMarblesCount = demandedMove[1];
		String initialRow = demandedMove[2];
		String initialColumn = demandedMove[3];
		
		
		Position newPosition = new Position(Integer.parseInt(initialRow),Integer.parseInt(initialColumn));
		
		
		
		return new Move(Integer.parseInt(movedMarblesCount), MoveType.getMoveTypeByIndex(Integer.parseInt(moveDirectionNumber)), newPosition);	
	}




}
