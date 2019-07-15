import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import inventory.*;
import login.*;
public class Driver {
	public static void main (String[] args) {
		String username = "test";
		String password = "test";
		InventoryManager master = new InventoryManager();
		Item searched;
		Login test = new Login(username, password);
		if(test.verify())
			System.out.println("login successful");
		master.createItem("printer", "abc123", 1);
		searched = master.inventory.getFirst();
		searched = master.searchItem("printer");
		System.out.println(searched.getName());
	/*	createUser("a","a");
		test.setUsername("ahmed@koomi.com");
		test.setPassword("1234test");
		if(test.verify())
		System.out.println("YES");
*/
		
	}
	
	public static void createUser(String username, String password) {
		Login test = new Login(username, password);
		if(test.verify() == false) {
			
			try(FileWriter fw = new FileWriter("users.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(username + "," + password);
				} catch (IOException e) {
				    //exception handling left as an exercise for the reader
				}
			
			System.out.println("User has been created.");
		}
		
		else
			System.out.println("The user already exists.");
	}
}
