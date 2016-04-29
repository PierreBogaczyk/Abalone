/**
 * Enumeration of the possible move for a marble
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */
public enum MoveType
{
	UPLEFT,
	UPRIGHT,
	RIGHT,
	DOWNRIGHT,
	DOWNLEFT,
	LEFT;
	
	public static MoveType getMoveTypeByIndex(int index)
	{
		return MoveType.values()[index];
	}
}
