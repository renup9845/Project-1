
/* model*/

package com.BankApplication.model;
public class bankModel{
	private int acNumber, acBalance;
	private String acHolder, acPassword, acPwd;
	public int getAcNumber() {
		return acNumber;
	}
	public void setAcNumber(int acNumber) {
		this.acNumber = acNumber;
	}
	public String getAcPwd() {
		return acPwd;
	}
	public void setAcPwd(String acPwd) {
		this.acPwd = acPwd;
	}
	public int getAcBalance() {
		return acBalance;
	}
	public void setAcBalance(int acBalance) {
		this.acBalance = acBalance;
	}
	public String getAcHolder() {
		return acHolder;
	}
	public void setAcHolder(String acHolder) {
		this.acHolder = acHolder;
	}
	public String getAcPassword() {
		return acPassword;
	}
	public void setAcPassword(String acPassword) {
		this.acPassword = acPassword;
	}
	@Override
	public String toString() {
		return "bankModel [acNumber=" + acNumber + ", acBalance=" + acBalance + ", acHolder=" + acHolder
				+ ", acPassword=" + acPassword + "]";
	}
	
	public int amtDeposit(int amt) {
		return this.acBalance+=amt;
	}
	
	public int amtWithdraw(int amt) {
		return this.acBalance-=amt;
	}
}
