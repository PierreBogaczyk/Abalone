/**
 * This class represents a marble of Abalone.
 * @author Pierre Bogaczyk/Mickael Prades
 *
 */
public class Marble
{
	// TODO consider using an enumeration of colors instead of a string to represent a color
	// TODO think about the relevance of a class that embeds only a field.
	/**
	 * Color of the marble
	 */
	private String color;
	
	/**
	 * Create a marble of Abalone of the desired color.
	 * @param color Color of the marble
	 */
	public Marble(String color)
	{
		this.color=color;
	}
}
