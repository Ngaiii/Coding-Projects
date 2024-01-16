import java.util.*;
public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number you want to see multiplied");
		int num = input.nextInt();
		System.out.println("Enter the limit of the Multi-Table");
		int limit = input.nextInt();
		for(int i = 1; i <= limit; i++) {
			System.out.println(num + " * " + i + " =  " + num * i);
		}
	}

}
