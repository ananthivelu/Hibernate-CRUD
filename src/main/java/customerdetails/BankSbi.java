package customerdetails;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BankSbi")
public class BankSbi {

	private int Accountnumber;
	private String CustomerName;
	private double Deposit;
	private double Balance;
	private double Withdraw;

	public int getAccountnumber() {
		return Accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		Accountnumber = accountnumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public double getDeposit() {
		return Deposit;
	}

	public void setDeposit(double deposit) {
		Deposit = deposit;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public double getWithdraw() {
		return Withdraw;
	}

	public void setWithdraw(double withdraw) {
		Withdraw = withdraw;
	}
}
