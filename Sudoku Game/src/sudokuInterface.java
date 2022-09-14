
public interface sudokuInterface {
	
	boolean IsNumberInRow(int[][] board, int row, int number);
	
	boolean IsNumberInColumn(int[][] board, int column, int number);
	
	boolean IsNumberInBox(int[][] board, int row, int column, int number);
	
	boolean IsValidPlacement(int[][] board, int row, int column, int number);
	
	boolean SolveBoard(int[][] board);
	
	public void PrintBoard();
}
