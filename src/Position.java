/**
 * This class represents a position on the board 
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */
public class Position
{
	/**
	 * X : Row index
	 * Y : Column index
	 */
	private final int x;
	private final int y;
	/**
	 * Build a position with two parameters.
	 * @param x : Row index
	 * @param y : Column index
	 */
	public Position(int X,int Y){
		this.x = X;
		this.y = Y;
		
	}
	
	/**
	 * Allow to change a marble position because move direction
	 * @param moveDirection
	 * @param movedMarblesPosition
	 * @return marblePositionAfterMove
	 */
	private Position ChangePosition(MoveType moveDirection, Position movedMarblesPosition)
	{
		int initialLineMarblePosition;
		int initialColumnMarblePosition;
		initialLineMarblePosition = movedMarblesPosition.getX();
		initialColumnMarblePosition = movedMarblesPosition.getY();
		
		int lineMarblePosition;
		int columnMarblePosition;
		
		/*
		switch(moveDirection)
		{
		case UPLEFT : lineMarblePosition = initialLineMarblePosition ;
		case UPRIGHT : ;
		case RIGHT : ;
		case DOWNRIGHT : ;
		case DOWNLEFT : ;
		case LEFT : ;
		}*/
		
		Position marblePositionAfterMove = new Position(lineMarblePosition,columnMarblePosition);
		return marblePositionAfterMove;
	}
	
	
	
	/**
	 * Get the value of x;
	 * @return x : Row index
	 */
	public int getX()
	{
		return x;
	}
	/**
	 * Get the value of y;
	 * @return y : Column index
	 */
	public int getY()
	{
		return y;
	}
}
