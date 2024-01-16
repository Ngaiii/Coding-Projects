import java.util.Scanner;

public class Calculator {
public double answer;
	public void getInput(){
		Scanner input = new Scanner(System.in);
	
		while(true) {
		
		
		System.out.println("i can add, subtract, multiply, and divide");
		System.out.println("what can i do for you");
		String key = input.nextLine();
		if(key.equalsIgnoreCase("add")) {
			System.out.println("input two values you like");
			double A = input.nextDouble();
			double B = input.nextDouble();
			getAdd(A, B);
		}
		else if(key.equalsIgnoreCase("subtract")) {
			System.out.println("input two values you like");
			double A = input.nextDouble();
			double B = input.nextDouble();
			getSubtract(A, B);
		}
		else if(key.equalsIgnoreCase("multiply")) {
			System.out.println("input two values you like");
			double A = input.nextDouble();
			double B = input.nextDouble();
			getMultiply(A, B);
		}
		else if(key.equalsIgnoreCase("divide")) {
			System.out.println("input two values you like");
			double A = input.nextDouble();
			double B = input.nextDouble();
			getDivide(A, B);
		}
		System.out.println(answer);
		System.out.println("would you like to play again");
		input.nextLine();
		String again = input.nextLine();
		if(again.equals("no")) {
			System.out.println("Ended");
			break;
		}
		}
			}
	
	public double getAdd(double A, double B) {
		answer = A + B ;
		return answer;
		
	}
	public double getSubtract(double A, double B) {
		answer = A - B ;
		return answer;
		
	}
	public double getMultiply(double A, double B) {
		answer = A * B ;
		return answer;
		
	}
	public double getDivide(double A, double B) {
		answer = A / B ;
		return answer;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator ready = new Calculator();
		ready.getInput();
	}

}
