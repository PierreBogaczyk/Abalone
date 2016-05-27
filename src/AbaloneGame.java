/**
 * This class represents an Abalone game cf :
 * https://en.wikipedia.org/wiki/Abalone_%28board_game%29
 * 
 * @author Bogaczyk Pierre / Prades Mickael
 *
 */
public class AbaloneGame
{
	/**
	 * Board used.
	 */
	private Board board;

	/**
	 * Array with both player references
	 */
	private Player[] player;

	/**
	 * Creates a new Abalone game, ready to be played (gameboard is in default
	 * style starting configuration)
	 */
	public AbaloneGame()
	{
		this.board = new Board();
		this.player = new Player[2];
		this.player[0] = new Player();
		this.player[1] = new Player();
	}


	// @formatter.off
	/**
	 * Allows to play an Abalone game. Allows players to make moves until the game end.
	 * 
	 * Algorithm :
	 * 
	 * current player is white player
	 *  
	 * while (<game is not over>)
	 * do
	 * 		<ask current player for a move>
	 * while (<move is not valid>)
	 * <process move>
	 * <changes current player>
	 * 
	 * */
	// @formatter.on
	public void play()
	{
		int cp = 0;
		
		while (!this.isGameOver(this.board))
		{
			if(cp==0) System.out.println("White player");
			if(cp==1) System.out.println("Black player");
			Move move = null;
			Move oppositeMove = null;
			this.player[cp].gridDisplay(this.board);
			do
			{
				this.player[cp].moveInstruction();
				move = this.player[cp].askForMove();
				if(board.getGridCellState(move.getMovedMarbleFinalPosition(0).getX(), move.getMovedMarbleFinalPosition(0).getY())!=CellState.EMPTY)
				{
					oppositeMove = this.createOppositeMove(board,move);
				}
			}
			while(!this.isValidMove(move,oppositeMove));
			if(oppositeMove != null)this.board.updateCellState(oppositeMove);
			this.board.updateCellState(move);
			cp = ( cp + 1 ) % 2;
			
		}
	}

	public Move createOppositeMove(Board board,Move move)
	{
		int marblesCount = board.getMarblesCount(move.getMovedMarbleInitialPosition(0),move.getMoveDirection());
		Position lastOppositeLineMarblePosition = new Position(move.getMovedMarbleInitialPosition(0).getX()+ marblesCount * move.getMoveDirection().getNumberModificator().getX(),
				move.getMovedMarbleInitialPosition(0).getY()+ marblesCount * move.getMoveDirection().getNumberModificator().getY());
		return new Move(marblesCount,move.getMoveDirection(),lastOppositeLineMarblePosition);
	}

	// TODO (ask for advice)
	/**
	 * Check if move is valid
	 * @param move
	 * @return <tt>true</tt> if move is valid, <tt>false</tt> else
	 */
	private boolean isValidMove(Move move,Move oppositeMove)
	{
		if(oppositeMove!= null)
		{
			if(oppositeMove.getMovedMarblesCount() >= 3) return false;
			if(oppositeMove.getMovedMarblesCount() >= move.getMovedMarblesCount()) return false;
		}
		if(board.getGridCellState(move.getMovedMarbleFinalPosition(0).getX(), move.getMovedMarbleFinalPosition(0).getY()) == CellState.INVALID) return false;
		if(move.getMovedMarblesCount() > 3) return false;
		if(this.board.getGridCellState(move.getMovedMarbleInitialPosition(0).getX(), move.getMovedMarbleInitialPosition(0).getY()) 
		   == this.board.getGridCellState(move.getMovedMarbleFinalPosition(0).getX(), move.getMovedMarbleFinalPosition(0).getY())) return false;
		return true;
	}

	/**
	 * Check if game is over
	 * @return <tt>true</tt> if game is over, <tt>false</tt> else
	 */
	private boolean isGameOver(Board currentBoard)
	{
		if((currentBoard.getWhiteMarblesCount()<=8)||(currentBoard.getBlackMarblesCount()<=8))
			return true;
		return false;
	}

}
