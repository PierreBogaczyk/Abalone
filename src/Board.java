
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
			this.grid[8][8 - indexcol] = CellState.BLACK_MARBLE;
		}
		for (int indexcol = 0; indexcol < 6; indexcol++)
		{
			this.grid[1][indexcol] = CellState.WHITE_MARBLE;
			this.grid[7][8 - indexcol] = CellState.BLACK_MARBLE;
		}
		for (int indexcol = 2; indexcol < 5; indexcol++)
		{
			this.grid[2][indexcol] = CellState.WHITE_MARBLE;
			this.grid[6][8 - indexcol] = CellState.BLACK_MARBLE;
		}
		this.grid[3][8] = CellState.INVALID;
		this.grid[2][7] = CellState.INVALID;
		this.grid[1][6] = CellState.INVALID;
		this.grid[0][5] = CellState.INVALID;
		this.grid[5][0] = CellState.INVALID;
		this.grid[6][1] = CellState.INVALID;
		this.grid[7][2] = CellState.INVALID;
		this.grid[8][3] = CellState.INVALID;
	}

	/**
	 * This method allows to update the board
	 * @param move
	 */
	public void updateCellState(Move move)
	{
		CellState color = this.grid[move.getMovedMarbleInitialPosition(0).getX()][move.getMovedMarbleInitialPosition(0).getY()];
		
		for(int i = 0;i < move.getMovedMarblesCount();i++)
		{
			this.grid[move.getMovedMarbleInitialPosition(i).getX()][move.getMovedMarbleInitialPosition(i).getY()] = CellState.EMPTY;
		}
		for(int i = 0; i < move.getMovedMarblesFinalCount();i++)
		{
			if(isPositionValid(move.getMovedMarbleFinalPosition(i)))
			{
				this.grid[move.getMovedMarbleFinalPosition(i).getX()][move.getMovedMarbleFinalPosition(i).getY()] = color;
			}
			else
			{
				if(color == CellState.BLACK_MARBLE) this.blackMarblesCount --;
				if(color == CellState.WHITE_MARBLE) this.whiteMarblesCount --;
			}
		}
	}
		
	public int getMarblesCount(Position position, MoveDirection moveType)
	{
		Position initialPosition = position.getNewPosition(moveType);
		Position finalPosition = position.getNewPosition(moveType);
		int count = 0;
		if(this.getGridCellState(initialPosition.getX(),initialPosition.getY())==CellState.EMPTY) return count;
		while(this.getGridCellState(initialPosition.getX(),initialPosition.getY())==
				this.getGridCellState(finalPosition.getX(),finalPosition.getY()))
		{
			count ++;
			finalPosition = finalPosition.getNewPosition(moveType);
		}
		return count;
	}
	
	public boolean isPositionValid(Position position)
	{
		if((position.getX()>8)||(position.getX()<0)) return false;
		if((position.getY()>8)||(position.getY()<0)) return false;
		
		if((position.getX()>4)&&(position.getY()==0)) return false;
		if((position.getX()>5)&&(position.getY()==1)) return false;
		if((position.getX()>6)&&(position.getY()==2)) return false;
		if((position.getX()>7)&&(position.getY()==3)) return false;
		if((position.getX()<1)&&(position.getY()==5)) return false;
		if((position.getX()<2)&&(position.getY()==6)) return false;
		if((position.getX()<3)&&(position.getY()==7)) return false;
		if((position.getX()<4)&&(position.getY()==8)) return false;
		
		if(this.getGridCellState(position.getX(),position.getY()) == CellState.INVALID) return false;
		return true;
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
		return this.blackMarblesCount;
	}

	public void setBlackMarblesCount(int i)
	{
		this.blackMarblesCount = i;
	}

	public void setWhiteMarblesCount(int i)
	{
		this.whiteMarblesCount = i;
	}
	
	public CellState getGridCellState(int x,int y)
	{
		if((x < 0)||(y < 0)) return CellState.INVALID;
		if((x > 8)||(y > 8)) return CellState.INVALID;
		return this.grid[x][y];
	}
}
