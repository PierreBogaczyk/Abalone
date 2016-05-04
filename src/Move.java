/**
 * This class represents a move
 * 
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */
public class Move
{
	/**
	 * Number of marbles moved by the current move.
	 */
	private int movedMarblesCount;
	/**
	 * Direction of the move amongst the possible moves.
	 */
	private MoveType moveDirection;
	/**
	 * Position of the moved marbles prior to the move.
	 */
	private Position[] movedMarblesInitialPosition;
	
	public Move(int movedMarblesCount, MoveType moveDirection, Position movedMarblesPosition)
	{
		this.movedMarblesCount = movedMarblesCount;
		this.moveDirection = moveDirection;
		
		Position movedMarblesTab[] = new Position[movedMarblesCount];
		

		ChangePosition(moveDirection, movedMarblesPosition);
		
		this.movedMarblesInitialPosition = movedMarblesTab;
		
	}
	
	public Move(MoveType moveDirection, Position[] movedMarblesPosition)
	{
		//TODO complete the constructor 
		
	}
	
	
	public boolean isMovePossible()
	{
		if(this.movedMarblesCount > 3) return false;
		
		return true;
		
	}
}
