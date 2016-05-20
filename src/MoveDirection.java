/**
 * Enumeration of the possible move for a marble
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */
public enum MoveDirection
{
	UPLEFT(0,-1),
	UPRIGHT(1,0),
	RIGHT(1,1),
	DOWNRIGHT(0,1),
	DOWNLEFT(-1,0),
	LEFT(-1,-1);
	

	private Position numberModificator;

	
	/**
	 * Constructor of move type
	 * @param x
	 * @param y
	 */
	private MoveDirection(int x, int y)
	{
		this.numberModificator = new Position(x,y);		
		
	}

	
	/**
	 * Get number modificator
	 * @return number modificator
	 */
	public Position getNumberModificator()
	{
		return this.numberModificator;
	}
	
	
	public static MoveDirection getMoveTypeByIndex(int index)
	{
		return MoveDirection.values()[index];
	}
}
