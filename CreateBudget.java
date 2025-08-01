import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBudget {

	private String budgetName;
	
	public CreateBudget() {
		
	}
	
	public String show(Connection sqlConnection, Scanner scnr, Assets asset) {
		
		asset.clearTerminal();
		
		System.out.print("Enter name for new budget or enter m/M to return to the main menu: ");
		budgetName = scnr.nextLine();
		
		if (budgetName.equals("m") || budgetName.equals("M") || budgetName.equals("m/M")) {
			return "mainMenu";
		}
		
		SqlQuery query = new SqlQuery(sqlConnection);
		List<Map<String, Object>> results = new ArrayList<>();
		String sqlQuery = String.format("CREATE TABLE [%s_budget] (" +
										"Id INTEGER PRIMARY KEY," +
										"Due_Date TEXT," +
										"Item TEXT," +
										"Amount REAL," +
										"Balance REAL," +
										"Notes TEXT);", budgetName
									);
		results = query.run(sqlQuery);
		
		sqlQuery = String.format("INSERT INTO Budgets (Budget_Name) VALUES ('%s');", budgetName);
		
		results = query.run(sqlQuery);
		
		
		
		
//		results = query.run("SELECT * FROM main_budget");
//		
//		if (results == null) {
//			System.out.println("Query returned empty");
//			return "error";
//		}
//		
//		System.out.println("Column count: " + results.get(0).size());
//		System.out.println("results.get(0): " + results.get(0));
//		
//		int columnCount = results.get(0).size();
//		List<String> columnNames = new ArrayList<>(results.get(0).keySet());
//		
//		for (int i = 0; i < columnCount; i++) {
//			System.out.print("   " + columnNames.get(i) + "   ");
//		}
//		System.out.println();
//		
//		for (Map<String, Object> row : results) {
//			for (String key : columnNames) {
//				Object value = row.get(key);
//				System.out.print("   " + value + "   ");
//			}
//			System.out.println();
//		}
//		
//		String pauseString = scnr.nextLine();
		
		return "error";
	}
}



