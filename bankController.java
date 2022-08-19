/* Controller
 */
package com.BankApplication.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import com.BankApplication.model.bankModel;

public class bankController {
	
	//UserName Authentication
	public boolean checkUserName(bankModel bm) throws IOException {
		String userName = bm.getAcHolder();
		if (Pattern.matches("[a-zA-Z]{5,13}", userName))
		{
			return true;
		}
		else {
			throw new IOException("! User name should be Alphabetic and must characters between 5 - 15 . ");
		}

	}
	
		//Password checking
	public boolean checkPassword(bankModel bm) throws IOException {
		String bsPassword = bm.getAcPassword();
		if (Pattern.matches("[a-zA-Z0-9@#]{6,}", bsPassword)) {
			return true;
		} else {
			throw new IOException("! password should have@ and # and should be atleast 6 character long ");
		}
	}

	//verifying password to deposit amount
	public boolean pwdDeposit(bankModel bm, String paswd) throws IOException {
		String existingPassword = bm.getAcPassword();
		if (paswd.equals(existingPassword)) {
			return true;
		} else {
			throw new IOException("! Wrong Password");
		}
	}
	
	//verifying password and checking sufficient amount to withdraw
	public boolean pwdWithdraw(bankModel bm, String paswd, int amt)throws IOException {
		String existingPassword = bm.getAcPassword();
		if (paswd.equals(existingPassword)) {
			//checks balance
			if (bm.getAcBalance()>amt) {
				return true;
			}
			//throws exception if there is insufficient balance in account
			else {
				throw new IOException("! Insufficient Amount \n");
			}
			
		} 
		//throws exception if password is wrong
		else {
			throw new IOException("! Wrong Password");
		}
	}
	}
