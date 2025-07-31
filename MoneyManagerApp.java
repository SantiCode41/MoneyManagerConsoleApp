// Util Imports
import java.util.Scanner;
import java.util.Random;
// SQL Imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MoneyManagerApp {
	public static void main(String[] args) {
		// Start of application
		System.out.println("Application Starting...");
		
		Assets asset = new Assets();  // Assets object for visual items such as loading bars
		
		// Connecting to the database
		System.out.println("Connecting to SQLite database...");
		String dbName = "mmappdb.db";
		String url = String.format("jdbc:sqlite:%s", dbName);
		try (Connection connection = DriverManager.getConnection(url)) {
			asset.loadingBar(20, "Connected to SQLite database.", "Redirecting you to main menu");  // (loading bar length, message once loading completes, message informing user where they are being sent)
		}
		catch (SQLException e) {
			System.out.println("Error occured. Unable to connect to database " + dbName);
			System.out.println("Exiting Program");
			System.exit(1);
		}
				
		System.out.println("\033[H\033[2J");  // Clearing terminal
		System.out.flush();
		
		// Application control mechanism
		final int startUpState = -2;
		Integer requestedState = startUpState;
		String returnedString = "";
		final int mainMenuState = 0;
		final int selectBudgetState = 1;
		final int createNewBudgetState = 2;
		final int exitProgramState = -1;
		
		Scanner scnr = new Scanner(System.in);
		
		while (requestedState != -1) {
			
			switch (requestedState) {
				case startUpState:
					requestedState = mainMenuState;
					continue;
				case mainMenuState:  // Show Main Menu
					//returnedString = showMainMenu(scnr);
					MainMenu moduleMain = new MainMenu();
					returnedString = moduleMain.show(scnr);
					break;
				case selectBudgetState:
					System.out.println("This is where you will see a list of budgets to choose from");
					break;
				case createNewBudgetState:
					System.out.println("This is where you will be able to create a new budget");
					break;
				case exitProgramState:
					System.out.println("This choice triggers program exit");
					break;
				default:
					System.out.println("Invalid choice. Please select another item.");
			}
			
			if (returnedString.equals("mainMenu")) {
				requestedState = mainMenuState;
			}
			else if (returnedString.equals("selectBudget")) {
				requestedState = selectBudgetState;
			}
			else if (returnedString.equals("createBudget")) {
				requestedState = createNewBudgetState;
			}
			else if (returnedString.equals("exitProgram")) {
				requestedState = exitProgramState;
			}
			else {
				System.out.println("Unexpected error occured. Returning to Main Menu.");
				requestedState = mainMenuState;
			}
		}
		
		System.out.println("You selected menu option " + requestedState);
		scnr.close();
	}
	
	
//	// Loading bar method to simulate progress
//	private static void loadingBar(int length, String outputMessage, String redirectMessage) {
//		int percentIncrement = 100 / length;
//		int maxDelay = 10;
//		Random randomNum = new Random();
//		int sleepDelay;
//		try {
//			for (int i = 0; i <= length; i++) {
//				System.out.print("\r[");
//				System.out.print(String.valueOf('#').repeat(i));
//				System.out.print(String.valueOf(' ').repeat(length - i));
//				System.out.print(String.format("] %d%%", (i * percentIncrement)));
//				System.out.flush();
//				sleepDelay = randomNum.nextInt(maxDelay);
//				Thread.sleep(sleepDelay);
//			}
//			
//			System.out.println("\n" + outputMessage);
//			System.out.println(redirectMessage);
//			Thread.sleep(2000);
//		}
//		catch (InterruptedException e) {
//			System.out.println("Loading interrupted: " + e.getMessage());
//		}
//	}
}