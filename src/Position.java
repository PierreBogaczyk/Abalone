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
	 */
	public Position changePosition(MoveType moveDirection, Position movedMarblesPosition)
	{	
		int lineMarblePosition = movedMarblesPosition.getX() + moveDirection.getNumberModificator().getX();
		int columnMarblePosition = movedMarblesPosition.getY() + moveDirection.getNumberModificator().getY();
		
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
