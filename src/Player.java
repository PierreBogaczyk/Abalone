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

	public void moveInstruction()
	{
		System.out.println("Enter a move ('Number of direction'-'Count of moved marbles'-'Row of the first marble'-'Column of the first marble')");	
	}

	public void gridDisplay()
	{
		for(int indexrow=0; indexrow < 9; indexrow++)
		{
			
			for(int indexcolumn=0; indexcolumn < 9; indexcolumn++)
			{
				
				
				
			}
			
		}
		
		System.out.println("");
	}


}
