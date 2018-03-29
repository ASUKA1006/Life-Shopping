
public class UserBuilder {
	private String userName;
	private Job job;
	
	public String setUserName(String userName) {
		this.userName = userName;
		return this.userName;
		
	}
	
	public Job setJob(Job job) {
		this.job = job;
		return this.job;
	}
	
	public User build () {
	
		if (userName != null && job != null) {
			return new User (userName, job);
		}else {
			throw new IllegalStateException();
		}
		
	}
}
