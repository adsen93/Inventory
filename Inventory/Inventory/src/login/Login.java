package login;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Login {
	private String username;
	private String password;
	
	public Login(String username, String password){
		this.username = username;
		this.password = password;
	}
	public boolean verify(){
		try{
			String line;
			String login[]=new String[2];
			BufferedReader br;
			br = new BufferedReader(new FileReader("users.txt"));
			while((line = br.readLine()) != null){
				login = line.split(",");
				if(username.equals(login[0]) && password.equals(login[1])){
					br.close();
					return true;
				}
			}
			br.close();
		}catch(FileNotFoundException e1){
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return false;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}