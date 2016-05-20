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
	 * Allow to change a marble position following the move direction
	 * @param moveDirection
	 * @param movedMarblesPosition
	 */
	public Position getNewPosition(MoveDirection moveDirection)
	{	
		int rowMarblePosition = this.getX() + moveDirection.getNumberModificator().getX();
		int columnMarblePosition = this.getY() + moveDirection.getNumberModificator().getY();
		
		Position marblePositionAfterMove = new Position(rowMarblePosition,columnMarblePosition);
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
