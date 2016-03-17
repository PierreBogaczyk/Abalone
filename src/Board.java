
// @formatter:off
/**
 * This class represents a board of Abalone using the following scheme:
 * 
 *     I O O O O O
 *    H O O O O O O
 *   G + + O O O + +
 *  F + + + + + + + +
 * E + + + + + + + + +
 *  D + + + + + + + + 8
 *   C + + @ @ @ + + 7
 *    B @ @ @ @ @ @ 6
 *     A @ @ @ @ @ 5
 *        0 1 2 3 4
 * 
 * @author Bogaczyk Pierre / Prades Mickael
 *
 *
 */
// @formatter:on
public class Board
{
	/**
	 * Default count of marbles
	 */
	private static final int MARBLES_COUNT = 14;

	// TODO write comment
	private static final int GRID_SIZE = 9;

	// TODO a comment for each field
	/**
	 * Count of marbles of each color on the board
	 */
	private int whitemarblescount;
	private int blackmarblescount;

	// TODO fix comment
	/**
	 * grid[x][y]: x=row, y=column
	 */
	private Marble[][] grid;

	// TODO write a constructor
	/**
	 * Creates an initialized board of Abalone (gameboard is in default style
	 * starting configuration)
	 */
	public Board()
	{
		this.grid = new Marble[GRID_SIZE][GRID_SIZE];
		this.whitemarblescount = MARBLES_COUNT;
		this.blackmarblescount = MARBLES_COUNT;
		for (int indexcol = 0; indexcol < 5; indexcol++)
		{
			this.grid[0][indexcol] = new Marble("white");
			this.grid[8][9 - indexcol] = new Marble("black");
		}
		for (int indexcol = 0; indexcol < 6; indexcol++)
		{
			this.grid[1][indexcol] = new Marble("white");
			this.grid[7][9 - indexcol] = new Marble("black");
		}
		for (int indexcol = 2; indexcol < 5; indexcol++)
		{
			this.grid[2][indexcol] = new Marble("white");
			this.grid[6][9 - indexcol] = new Marble("black");
		}
	}
}
