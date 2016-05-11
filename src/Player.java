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
		System.out.println("Move list : LEFT(0),UP(1),UPRIGHT(2),RIGHT(3),DOWN(4),DOWNLEFT(5)");
		System.out.println("Enter a move ('Number of direction'-'Count of moved marbles'-'Row of the first marble'-'Column of the first marble')");	
	}

	public void gridDisplay(Board board)
	{
		System.out.println("");
		String ligne;
		for(int indexrow = 8; indexrow >= 0; indexrow--)
		{
			ligne = indexrow + " ";
			for(int indexcolumn = 0; indexcolumn <9; indexcolumn++)
			{
				if(board.getGridCellState(indexrow, indexcolumn)==CellState.BLACK_MARBLE)
				{
					ligne = ligne + " B ";
				}
				if(board.getGridCellState(indexrow, indexcolumn)==CellState.WHITE_MARBLE)
				{
					ligne = ligne + " W ";
				}
				if(board.getGridCellState(indexrow, indexcolumn)==CellState.EMPTY)
				{
					ligne = ligne + " * ";
				}
				if(board.getGridCellState(indexrow, indexcolumn)==CellState.INVALID)
				{
					ligne = ligne + " / ";
				}
			}
			System.out.println(ligne);
		}
		System.out.println("   0  1  2  3  4  5  6  7  8");
		
		System.out.println("");
	}


}
