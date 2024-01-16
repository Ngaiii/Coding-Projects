import java.util.*;
import java.text.DecimalFormat;
public class GpaCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int credits = 0, totalCredits = 0;
			String grade = null;
			String className = null;
			int gradeValue = 0;
			int points = 0, totalPoints = 0;
			double gpa;
			int counter = 0;
			List<String> classNames = new ArrayList<>();
			List<String> classGrade = new ArrayList<>();
			
			Scanner input = new Scanner (System.in);
			
			while(true) {
				
				System.out.println("What class are you taking?");
				className = input.nextLine();
				classNames.add(className);
				while(true) {
					
					counter++;
					System.out.println("Enter number of credits");
					credits = input.nextInt();
					if (credits <= 0) {
						System.out.println("Invaild input");
					}
					else {
						break;
					}
				}
		
				input.nextLine();
			
				while(true) {
					System.out.println("Enter letter grade for the class");
					grade = input.nextLine();
					grade = grade.toUpperCase();
					if (grade.equals("A")|| grade.equals("A") || grade.equals("B") || grade.equals("C") || grade.equals("D") || grade.equals("F")) {
						classGrade.add(grade);
						break;
					} else {
						System.out.println("Invaild input");
					}
			
				}
			
			
			
				if(grade.equalsIgnoreCase("A")) {
				gradeValue = 4;
				} else if(grade.equalsIgnoreCase("B")) {
				gradeValue = 3;
				} else if(grade.equalsIgnoreCase("C")) {
				gradeValue = 2;
				} else if(grade.equalsIgnoreCase("D")) {
				gradeValue = 1;
				} else if(grade.equalsIgnoreCase("F")) {
				gradeValue = 0;
				} else {
				System.out.println("Invaild input");
				}
				points = gradeValue * credits;
				totalPoints += points;
				totalCredits += credits;
				
				
				System.out.println("Class: " + className);
				System.out.println("Letter grade: " + grade);
				System.out.println("Credit: " + credits);
				
				System.out.println("Would you like to enter more grades?");
				System.out.println("Enter yes/no");
				String answer = input.nextLine();
				if (answer.equalsIgnoreCase("no")) {
					break;
				} 
			
			}
			
			
			gpa = Double.valueOf(totalPoints)/ Double.valueOf(totalCredits);
			DecimalFormat df = new DecimalFormat("0.00");
			
			for (int i = 0; i < classNames.size(); i++) {
				System.out.print("Class: " + classNames.get(i));
				System.out.println(" Grade: " + classGrade.get(i));
			}
			System.out.println("Your Gpa: " + df.format(gpa));
			
			
	}

}
