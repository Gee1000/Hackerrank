
public class sudokuGame implements sudokuInterface {

	private final int GRID_SIZE = 9;
	private int[][] board = new int[GRID_SIZE][GRID_SIZE]; 
	private int[][] defaultBoard = new int[][]{
        { 4, 0, 5, 0, 3, 1, 7, 0, 0 },
        { 0, 3, 0, 0, 0, 0, 0, 0, 0 },
        { 9, 8, 7, 5, 2, 0, 4, 0, 0 },
        { 5, 0, 8, 0, 6, 3, 0, 0, 1 },
        { 0, 4, 1, 0, 0, 0, 0, 5, 2 },
        { 0, 6, 9, 4, 1, 5, 0, 7, 8 },
        { 0, 1, 3, 0, 0, 9, 0, 0, 0 },
        { 0, 5, 4, 0, 7, 2, 0, 6, 9 },
        { 0, 0, 2, 1, 0, 4, 0, 0, 7 },
	};
	
	sudokuGame(int[][] board) {
		this.board = board;
	}
	
	sudokuGame () {
		this.board = defaultBoard; 
	}
	
	public boolean IsNumberInRow(int[][] board, int row, int number) {
		for(int i = 0; i < GRID_SIZE; i++) {
			if(board[row][i] == number) return true;
		}
		return false;
	}

	@Override
	public boolean IsNumberInColumn(int[][] board, int column, int number) {
		for(int i = 0; i < GRID_SIZE; i++) {
			if(board[i][column] == number) return true;
		}
		return false;
	}

	@Override
	public boolean IsNumberInBox(int[][] board, int row, int column, int number) {
		int localRowBox = row - row%3, localColumnBox = column - column%3;
		for(int i = localRowBox; i < localRowBox+3; i++) {
			for(int j = localColumnBox; j < localColumnBox+3; j++) {
				if(board[i][j] == number) return true;
			}
		}
		return false;
	}

	@Override
	public boolean IsValidPlacement(int[][] board, int row, int column, int number) {
		return !IsNumberInRow(board, row, number) && !IsNumberInColumn(board, column, number) && !IsNumberInBox(board, row, column, number);
	}

	@Override
	public boolean SolveBoard(int[][] board) {
		for (int row = 0; row < GRID_SIZE; row++) {
			for(int column = 0; column < GRID_SIZE; column++) {
				if(board[row][column] == 0) {
					for(int i = 1; i <= GRID_SIZE; i++) {
						if(IsValidPlacement(board, row, column, i)) {
							board[row][column] = i;
							if(SolveBoard(board)) return true;
							else board[row][column] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean SolveBoard() {
		return SolveBoard(this.board);
	}

	@Override
	public void PrintBoard() {
		for(int row = 0; row < GRID_SIZE; row++) {
			if(row%3 == 0 && row != 0) { System.out.println("----------------------"); }
			for(int column = 0; column < GRID_SIZE; column++) {
				if(column%3 == 0 && column != 0) System.out.print("| ");
				System.out.print(board[row][column] + " ");
			}
			System.out.println();
		}
	}

}
