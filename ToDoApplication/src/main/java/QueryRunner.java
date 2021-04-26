import java.sql.*;

public class QueryRunner {
	
	public static void list(){
		
		try{
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT id, description, due_date, status FROM todolist");
			
			System.out.println("ID | Description	 | Due Date | Status");
			System.out.println("------------------------------------------------------------------------");

			while(rs.next()) {
				String id = rs.getString(1);
				String description = rs.getString(2);
				String duedate = rs.getString(3);
				String status = rs.getString(4);
				System.out.println(id + " | " + description + " | " + duedate + " | " + status);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured ");
		}finally {
			Main.mainMenu();
		}
	}
	
public static void tempList(){
		
		try{
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id, description, status FROM todolist");
			System.out.println("ID | Description	 | Status");
			System.out.println("------------------------------------------------------------------------");

			while(rs.next()) {
				String id = rs.getString(1);
				String description = rs.getString(2);
				String status = rs.getString(3);
				System.out.println(id + " | " + description + " | " + status);
			}
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured ");
		}
	}
	
	public static void add() {
		try{
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			String d  = Main.desc.getDescription();
			String d2 = Main.desc.getDueDate();
			stmt.executeUpdate("INSERT INTO todolist (description, due_date) VALUES('" + d + "','" + d2 + "')");
			System.out.println("Done");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured ");
		}
		ToDoManager.addItems();
	}	
	
	public static void update() {
		try{
			Connection con = DbConnection.getConnection();
			Statement stmt = con.createStatement();
			int d  = Main.desc.getId();
			String d2 = Main.desc.getStatus();
			stmt.executeUpdate("UPDATE todolist SET status = " + d2 + " WHERE id = " + d);
			System.out.println("Done");
			
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Error occured ");
		}
		tempList();
		ToDoManager.updateStatus();
	}		
}

//List<ToDoItems> list(){
//	
//	List<ToDoItems> items = new ArrayList<ToDoItems>();
//	Connection con = DbConnection.getConnection();
//	
//	try{
//		Statement stmt = con.createStatement();
//		
//		ResultSet rs = stmt.executeQuery("SELECT id, description, due_date, status FROM todolist");
//		
//		System.out.println("ID | Description | Due Date | Status");
//		System.out.println("------------------------------------------------------------------------");
//
//		while(rs.next()) {
//			ToDoItems td = new ToDoItems();
//			td.setId(rs.getString(1));
//			td.setDescription(rs.getString(2));
//			td.setDueDate(rs.getString(3));
//			td.setStatus(rs.getString(4));
//			items.add(td);
//		}
//		
//	} catch(SQLException e) {
//		e.printStackTrace();
//		System.out.println("Error occured ");
//	}
//	return items;
//}
