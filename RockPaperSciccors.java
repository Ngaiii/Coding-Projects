import java.util.Random;
import java.util.Scanner;

public class RockPaperSciccors {

	public static void main(String[] args) {
		
		String[] rps = {"rock","paper","scissors"};
		while(true) {
		String computerMove = rps[new Random().nextInt(rps.length)];
		Scanner input = new Scanner(System.in);
		String playerMove;
		
		while(true) {
		System.out.println("Please enter your move (rock, paper, or scissors)");
		playerMove = input.nextLine();
		
		if(playerMove.equalsIgnoreCase("rock") || playerMove.equalsIgnoreCase("paper") || playerMove.equalsIgnoreCase("scissors")) {
			break;
		}
		else {
			System.out.println("Please enter a valid move");
		}
		}
		
		System.out.println("Computer played " + computerMove);
		
		if(playerMove.equalsIgnoreCase(computerMove)) {
			System.out.println("Tie");
		}
		else if(playerMove.equalsIgnoreCase("rock")) {
			if(computerMove.equalsIgnoreCase("paper")) {
				System.out.println("You lose!");
			}
			else if(computerMove.equalsIgnoreCase("scissors")) {
				System.out.println("You win");
			}
		}
		else if(playerMove.equalsIgnoreCase("paper")) {
			if(computerMove.equalsIgnoreCase("scissors")) {
				System.out.println("You lose!");
			}
			else if(computerMove.equalsIgnoreCase("rock")) {
				System.out.println("You win");
			}
		}
		else if(playerMove.equalsIgnoreCase("scissors")) {
			if(computerMove.equalsIgnoreCase("rock")) {
				System.out.println("You lose!");
			}
			else if(computerMove.equalsIgnoreCase("paper")) {
				System.out.println("You win");
			}
		}
		
		System.out.println("Would you like to play again? y/n");
		String again = input.nextLine();
		if(again.equals("n")) {
			break;
		}
		
	}
		
	}
}		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


