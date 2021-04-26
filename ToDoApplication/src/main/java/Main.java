import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ToDoItems desc = new ToDoItems();
	
	public static void main(String[] args) {
		
		//DbConnection.getConnection();
		mainMenu();
		
		
		sc.close();
	}
	
	static void mainMenu() {
		System.out.println("Main Menu\r\n"
				+ "==========\r\n"
				+ "1. Show Items\r\n"
				+ "2. Add Items\r\n"
				+ "3. Change Item Status\r\n"
				+ "4. Exit\r\n"
				+ "Please select from one of the options above (i.e 1,2,3,4):\r\n");
		int m = sc.nextInt();
		switch(m) {
		case(1):
			// option 1 Show Items
			QueryRunner.list();
			break;
		case(2):
			//option 2 add items
			ToDoManager.addItems();
			break;
		case(3):
			//option 3 change items status
			ToDoManager.updateStatus();
			break;
		case(4):
			//option 4 exit
			System.out.println("Application Stopped");
			break;
		default:
			System.out.println("Invalid input. Please try again.");
			mainMenu();
			break;
		}
	}
	

}
