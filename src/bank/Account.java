package bank;

public class Account {
	public Account(String username,String password) {
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public boolean checkPassword(String password) {
		if(password.equals(this.password)) {
			return true;
		}
		return false;
	}
	private String username;
	private String password;
	private Double balance = 0.0;
}
