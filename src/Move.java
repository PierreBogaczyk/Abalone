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
		this.movedMarblesInitialPosition = new Position[movedMarblesCount];
		this.movedMarblesFinalPosition = new Position[movedMarblesCount];
		Position temporaryPosition = movedMarblesPosition;
		/*Position movedMarblesTab[] = new Position[movedMarblesCount];*/
		
		for(int i = 0; i < movedMarblesCount; i++)
		{
			this.movedMarblesInitialPosition[i] = temporaryPosition;
			this.movedMarblesFinalPosition[i]=this.movedMarblesInitialPosition[i].changePosition(moveDirection);
			temporaryPosition = new Position(temporaryPosition.getX()-moveDirection.getNumberModificator().getX(),
					temporaryPosition.getY()-moveDirection.getNumberModificator().getY());
		}
		/*this.movedMarblesInitialPosition = movedMarblesTab;
		for(int i=0; i < movedMarblesCount;i++)
		{
			this.movedMarblesFinalPosition[i]=this.movedMarblesInitialPosition[i].changePosition(moveDirection);
		}
		*/
	}
	/*
	public Move(MoveType moveDirection, Position[] movedMarblesPosition)
	{
		//TODO complete the constructor 
		
	}
	*/
	public Move createOppositeMove(Board board)
	{
		if(board.getGridCellState(getMovedMarbleFinalRow(), getMovedMarbleFinalColumn())!=CellState.EMPTY)
		{
			int count=0;
			while(board.getGridCellState(this.getMovedMarbleFinalRow() + count, this.getMovedMarbleFinalColumn() + count)==
					board.getGridCellState(this.getMovedMarbleFinalRow() + count * this.moveDirection.getNumberModificator().getX(), this.getMovedMarbleFinalColumn() + count * this.moveDirection.getNumberModificator().getY()))
			{
				count=count+1;
				if(this.getMovedMarbleFinalRow()+this.moveDirection.getNumberModificator().getX()>8) break;
				if(this.getMovedMarbleFinalColumn()+this.moveDirection.getNumberModificator().getY()>8) break;
				if(this.getMovedMarbleFinalRow()+this.moveDirection.getNumberModificator().getX()<0) break;
				if(this.getMovedMarbleFinalColumn()+this.moveDirection.getNumberModificator().getY()<0) break;
			}
			return new Move(count,this.moveDirection,this.movedMarblesFinalPosition[this.movedMarblesCount-1]);
		}
		return new Move(0,this.moveDirection,this.movedMarblesFinalPosition[this.movedMarblesCount-1]);
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
	public MoveType getMoveDirection()
	{
		return this.moveDirection;
	}
}
