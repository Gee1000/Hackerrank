
public class sudokuTest {

	public static void main(String[] args) {
		sudokuGame game1 = new sudokuGame(new int[][]{
	        { 5, 6, 0, 0, 0, 0, 0, 8, 0 },
	        { 0, 0, 0, 6, 3, 2, 0, 0, 0 },
	        { 7, 0, 3, 0, 9, 0, 0, 0, 2 },
	        { 0, 3, 0, 0, 0, 0, 2, 0, 7 },
	        { 0, 2, 9, 1, 5, 0, 4, 0, 0 },
	        { 8, 0, 7, 2, 4, 0, 6, 0, 0 },
	        { 1, 9, 6, 0, 7, 8, 0, 2, 5 },
        	{ 2, 0, 0, 3, 0, 9, 0, 4, 1 },
        	{ 0, 8, 0, 0, 2, 1, 0, 9, 0 },
		});
	
		sudokuGame game2 = new sudokuGame();
		if(game2.SolveBoard()) {
			System.out.println("The game is Solvable, Yay!!! :D");
			game2.PrintBoard();
		}
		else System.out.println("The game is unsolvable :(");
	}

}
