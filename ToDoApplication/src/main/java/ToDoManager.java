import java.time.format.DateTimeFormatter;


public class ToDoManager {
	//Main Menu and connection to QueryRunner
	static String newDescription;
	static String newDueDate;
	
	//============================================================================================	
	// Add Items	
	//============================================================================================	
	static void addItems(){
		System.out.println("Add new Item (Y/N)?\r\n");
		String q = Main.sc.next().toUpperCase();
		switch(q) {
		case("Y"):
			//call my query method
			newAddDescription();
			newAddDueDate();
			QueryRunner.add();
			//addItems();
			break;
		case("N"):
			// call main menu
			Main.mainMenu();
			break;
		default:
			System.out.println("Invalid selection. Please try again.\r\n");
			addItems();
		}
	}
	
	public static void newAddDescription() {
		System.out.println("Description:\r\n");
		String newDescription = Main.sc.next();
		if(newDescription.isEmpty()) {
			System.out.println("ERROR!! Enter valid values");
			newAddDescription();
		}else {
			Main.desc.setDescription(newDescription);	
		}
	}
	
	public static void newAddDueDate() {
		System.out.println("Due Date (YYYY-MM-DD):\r\n");
		String newDueDate = Main.sc.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
		
		try{
			String test = newDueDate.formatted(formatter);
			if(test.isEmpty()) {
				System.out.println("ERROR!! Enter valid values");
				newAddDueDate();
			}else {
				Main.desc.setDueDate(test);
			}
		}catch(Exception e) {
			System.out.println("ERROR!! Enter valid values.");
		}
	}
	
	//============================================================================================	
	// Update Status of Items	
	//============================================================================================
	static void updateStatus(){
		System.out.println("Change Item Status (Y/N)?\r\n");
		String q = Main.sc.next().toUpperCase();
		switch(q) {
		case("Y"):
			//call my query method
			QueryRunner.tempList();
			gatherStatus();
			QueryRunner.update();
			//addItems();
			break;
		case("N"):
			// call main menu
			Main.mainMenu();
			break;
		default:
			System.out.println("Invalid selection. Please try again.\r\n");
			updateStatus();
		}
	}

	static void gatherStatus() {
		System.out.println("Please select from the IDs above. (ex. 1)");
		int p = (int)Main.sc.nextInt();  
		System.out.println("Please type either 1 (done) or 0 (not done).");
		String status = Main.sc.next();
		if(status.equals("1") || status.equals("0")) {
			Main.desc.setStatus(status);	
			Main.desc.setId(p);  // ID test done on query class
		}else {
			System.out.println("ERROR!! Invalid input.");
			gatherStatus();
		}
	}
	
	
}	
	