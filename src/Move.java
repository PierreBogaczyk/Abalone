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
	/**
	 * Position of the moved marbles after to the move.
	 */
	private Position[] movedMarblesFinalPosition;
	
	public Move(int movedMarblesCount, MoveType moveDirection, Position movedMarblesPosition)
	{
		this.movedMarblesCount = movedMarblesCount;
		this.moveDirection = moveDirection;
		
		Position movedMarblesTab[] = new Position[movedMarblesCount];
		
		for(int i = 0; i < movedMarblesCount; i++)
		{
			movedMarblesTab[i] = movedMarblesPosition;
			movedMarblesPosition = new Position(movedMarblesPosition.getX()-moveDirection.getNumberModificator().getX(),
												movedMarblesPosition.getY()-moveDirection.getNumberModificator().getY());
		}
		this.movedMarblesInitialPosition = movedMarblesTab;
		for(int i=0; i < movedMarblesCount;i++)
		{
			movedMarblesFinalPosition[i]=movedMarblesInitialPosition[i].changePosition(moveDirection,movedMarblesInitialPosition[i]);
		}
		

		
	}
	/*
	public Move(MoveType moveDirection, Position[] movedMarblesPosition)
	{
		//TODO complete the constructor 
		
	}
	*/
	public int getMovedMarblesCount()
	{
		return this.movedMarblesCount;
	}
	public int getMovedMarbleInitialRow()
	{
		return this.movedMarblesInitialPosition[0].getX();
	}
	public int getMovedMarbleInitialColumn()
	{
		return this.movedMarblesInitialPosition[0].getY();
	}
	public int getMovedMarbleFinalRow()
	{
		return this.movedMarblesFinalPosition[0].getX();
	}
	public int getMovedMarbleFinalColumn()
	{
		return this.movedMarblesFinalPosition[0].getY();
	}
}
