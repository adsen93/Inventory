package inventory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
import login.Login;

public class InventoryManager{
	
	/**
	 * 
	 */
	
	private int numUsers = 0;
	private int numItems = 0;
	public LinkedList <Item> inventory = new LinkedList<Item>();
	public InventoryManager() {
		
	}
	public void createUser(String username, String password) {
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
			setNumUsers(getNumUsers() + 1);
			System.out.println("User has been created.");
		}
		
		else
			System.out.println("The user already exists.");
	}
	
	public void createItem(String name, String SKU, int quantity) {
		inventory.push(new Item(name,SKU,quantity));
	}
	
	public Item searchItem(String name) {
		ListIterator<Item> iter = inventory.listIterator();
		Item hold;
		while(iter.hasNext()) {
			hold = iter.next();
			if (hold.getName().equals(name)) {
				System.out.println("found it");
				return hold;
			}
		}
		System.out.println("That item does not exist in the system.");
		return null;
	}
	public int getNumUsers() {
		return numUsers;
	}
	public void setNumUsers(int numUsers) {
		this.numUsers = numUsers;
	}
	public int getNumItems() {
		return numItems;
	}
	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
}
