import java.util.*;

public class TicTacToe {
	
	public static char[][] board = new char[3][3]; // Creates a 2D array of type char called board.
	public static char currentPlayerMark; // Tracks player 'X' or 'O'.
	public TicTacToe() { // Initializes the game board with empty spaces. currentPlayerMark initialized.
		
		for(int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		currentPlayerMark = 'X'; // Sets first player to 'x'.
	}
	
	public static void writeBoard() { // Displays the board.
	
		System.out.println("-----------------");
		System.out.println("|R\\C| 1 | 2 | 3 |");
		System.out.println("-----------------");
		
		for(int row = 0; row < board.length; row++) {
			System.out.print("| " + (row + 1) + " | ");

			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + " | ");
		
			}
			System.out.println();
			System.out.println("-----------------");
			
		}
		
	}
	
	public static void getMove(int row, int col, char mark) { // Records a players move on the game board and checks if its invalid.
		if(row >= 1 && row <= 3 && col >= 1 && col <= 3) {
			board[row - 1][col - 1] = mark;
		}
		else {
			System.out.println("Invalid input");
		}

	}
	
	public boolean winner() { // Checks to see if there is a win.
		
		for(int col = 0; col <= 2; col++) {
			if(board[0][col]!= ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) { // Vertical win check.
				return true;
			}
		}
	
		for(int row = 0; row <= 2; row++) {
			if(board[row][0]!= ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) { // Horizontal win check.
				return true;
			}
		} 
		
		if(board[0][0]!= ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
				|| board[0][2]!= ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) { // Diagonal win check.
					return true;
				}
		
		else {
			return false;
		}
	}
	
	void makeMove() {// Allows the player to make a move and checks if it is a valid move.

		Scanner input = new Scanner (System.in);
		int row, col; // Declares integer rows and columns.
		
		do {
		System.out.println("Please enter row number and column number separated by a space.");
		row = input.nextInt(); 
		col = input.nextInt();
		
		if(row <= 0 || col <= 0 || row > 3 || col > 3) { // Checks if move is inbounds.
			System.out.println("Invalid Input \nTry again");
		} 
		else if(board[row -1 ][col - 1] == 'X' || board[row - 1][col - 1] == 'O') { // Checks if spot is not taken 
			System.out.println("That cell is already taken.");
			System.out.println("PLease make another selection.");
		}
		else {
			System.out.println("You have entered row # " + row + " and column # " + col);
			System.out.println("Thank you for your selection.");
			System.out.println();
		}
		
		
		} while (checkMove(row, col) != true);
		
		getMove(row, col, currentPlayerMark);
	
	}
	
	public boolean checkMove(int row, int col) { // Checks if a move is valid.
		if(row >= 1 && row <= 3 && col >= 1 && col <= 3) {
			if(board[row - 1][col - 1] == ' ') {
					return true;
			}
		}
		return false;
	}
	
	public void playGame() {
		int moves= 0; // Counts how many moves have been made.
		
		System.out.println("New Game: " + currentPlayerMark + " goes first.\n");
		writeBoard(); // Calls the method writeBoard.
	
		while(!winner()) { // While false runs.
		System.out.println();
		System.out.println(currentPlayerMark + "'s turn. ");
		System.out.println("Where do you want your " + currentPlayerMark + " placed?");
		
		makeMove(); // Calls the method makeMove from the player class.
	
		writeBoard();  // Calls the method writeBoard.
		
		moves++; // Increments moves by 1.
		if(winner() == true) { // If there is a winner it ends.
			System.out.println(currentPlayerMark + " IS THE WINNER!!!");
			break;
		}
		else if ( moves == 9) { // If moves equal 9 it also ends as a draw.
			System.out.println("Its a draw!");
			break;
		}
		
		if(currentPlayerMark == 'X') { // Switches players turns.
			currentPlayerMark  = 'O';
		}
		else {
			currentPlayerMark = 'X';
		}
		
		
				
		
	}

		
	}
	
}
	









	



