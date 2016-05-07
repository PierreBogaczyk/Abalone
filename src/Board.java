
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

	/**
	 * Default grid size
	 */
	private static final int GRID_SIZE = 9;

	// TODO(DONE) rename field (coding conventions
	/**
	 * Count of white marbles
	 */
	private int whiteMarblesCount;

	// TODO(DONE) rename field (coding conventions
	/**
	 * Count of black marbles
	 */
	private int blackMarblesCount;

	/**
	 * game board, each cell contains information about content (@see CellState) 
	 * grid[x][y]: x=row, y=column
	 */
	private CellState[][] grid;

	/**
	 * Creates an initialized board of Abalone (gameboard is in default style
	 * starting configuration)
	 */
	public Board()
	{
		this.grid = new CellState[GRID_SIZE][GRID_SIZE];
		this.whiteMarblesCount = MARBLES_COUNT;
		this.blackMarblesCount = MARBLES_COUNT;
		
		/**
		 * Initializes the board with empty value
		 */
		for (int indexcol = 0; indexcol < GRID_SIZE; indexcol++)
		{
			for (int indexrow = 0; indexrow < GRID_SIZE; indexrow++)
			{
				this.grid[indexrow][indexcol] = CellState.EMPTY;				
			}	
		}
		
		/**
		 * Sets marbles on the board with default style
		 */
		for (int indexcol = 0; indexcol < 5; indexcol++)
		{
			this.grid[0][indexcol] = CellState.WHITE_MARBLE;
			this.grid[8][9 - indexcol] = CellState.BLACK_MARBLE;
		}
		for (int indexcol = 0; indexcol < 6; indexcol++)
		{
			this.grid[1][indexcol] = CellState.WHITE_MARBLE;
			this.grid[7][9 - indexcol] = CellState.BLACK_MARBLE;
		}
		for (int indexcol = 2; indexcol < 5; indexcol++)
		{
			this.grid[2][indexcol] = CellState.WHITE_MARBLE;
			this.grid[6][9 - indexcol] = CellState.BLACK_MARBLE;
		}	
	}

	/**
	 * Get the white marbles count
	 * @return white marbles count
	 */
	public int getWhiteMarblesCount()
	{
		return whiteMarblesCount;
	}
	
	/**
	 * Get the black marbles count
	 * @return black marbles count
	 */
	public int getBlackMarblesCount()
	{
		return blackMarblesCount;
	}
	
	public CellState getGridCellState(int x,int y)
	{
		return this.grid[x][y];
	}
}
