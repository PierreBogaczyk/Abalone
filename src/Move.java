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
	private MoveDirection moveDirection;
	/**
	 * Position of the moved marbles prior to the move.
	 */
	private Position[] movedMarblesInitialPosition;
	/**
	 * Position of the moved marbles after to the move.
	 */
	private Position[] movedMarblesFinalPosition;
	
	public Move(int movedMarblesCount, MoveDirection moveDirection, Position headMarblePosition)
	{
		this.movedMarblesCount = movedMarblesCount;
		this.moveDirection = moveDirection;
		this.movedMarblesInitialPosition = new Position[movedMarblesCount];
		this.movedMarblesFinalPosition = new Position[movedMarblesCount];
		Position temporaryPosition = headMarblePosition;
		
		for(int i = 0; i < movedMarblesCount; i++)
		{
			this.movedMarblesInitialPosition[i] = temporaryPosition;
			this.movedMarblesFinalPosition[i]=this.movedMarblesInitialPosition[i].getNewPosition(moveDirection);
			temporaryPosition = new Position(temporaryPosition.getX()-moveDirection.getNumberModificator().getX(),
					temporaryPosition.getY()-moveDirection.getNumberModificator().getY());
		}
	}
	 
	
	public int getMovedMarblesFinalCount()
	{
		return this.movedMarblesFinalPosition.length;
	}
	
	public int getMovedMarblesCount()
	{
		return this.movedMarblesCount;
	}
	
	public Position getMovedMarbleInitialPosition(int i)
	{
		return this.movedMarblesInitialPosition[i];
	}
	
	public Position getMovedMarbleFinalPosition(int i)
	{
		return this.movedMarblesFinalPosition[i];
	}
	
	public MoveDirection getMoveDirection()
	{
		return this.moveDirection;
	}
}
