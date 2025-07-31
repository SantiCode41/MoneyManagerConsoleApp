// Util Imports
import java.util.Scanner;

public class MainMenu {
	private int userChoice;
	
	public MainMenu() {
		userChoice = 0;
	}
	
	public void setUserChoice(int userChoice) {
		this.userChoice = userChoice;
	}
	
	public int getUserChoice() {
		return userChoice;
	}
	
	public String show(Scanner scnr) {
		System.out.println(
			"""
					Main Menu
			1) Select Budget
			2) Create New Budget
			3) Exit Program
			"""
		);
		
		while (userChoice == 0) {
			System.out.print("Enter your selection: ");
			userChoice = scnr.nextInt();
			scnr.nextLine();
			
			final int selectBudget = 1;
			final int createBudget = 2;
			final int exitProgram = 3;
			
			switch (userChoice) {
				case selectBudget:
					return "selectBudget";
				case createBudget:
					return "createBudget";
				case exitProgram:
					return "exitProgram";
				default:
					System.out.println("Invalid choice. Please select another item.");
					userChoice = 0;
			}
		}
		return "unexpectedError";
	}
}