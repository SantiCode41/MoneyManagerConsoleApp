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

public class SqlQuery {
	
	private Connection sqlConnection;
	
	public SqlQuery(Connection sqlConnection) {
		this.sqlConnection = sqlConnection;
	}
	
	public List<Map<String, Object>> run(String query) {
		List<Map<String, Object>> data = new ArrayList<>();
		try (Statement statement = sqlConnection.createStatement(); ResultSet results = statement.executeQuery(query)) {
			ResultSetMetaData metaData = results.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			while (results.next()) {
				Map<String, Object> row = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String columnName = metaData.getColumnName(i);
					Object value = results.getObject(i);
					row.put(columnName, value);
				}
				data.add(row);
			}	
			return data;
		}
		catch (SQLException e) {
			System.err.println("Query error: " + e.getMessage());
			return null;
		}
	}
}