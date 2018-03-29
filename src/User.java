
public class User {
	
	private String userName;
	private Job yourJob;
	private int yourBalance;
	
	public User(String userName,Job yourJob) {
		this.userName = userName;
		this.yourJob = yourJob;
		
		
	}
	
	//getter
	public String getUserName() {
		return this.userName;
	}
	
	public Job getYourJob() {
		return this.yourJob;
	}
	
	public int getYourBalance() {
		return this.yourBalance;
	}
	
}
