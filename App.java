package com.BankApplication;

import java.util.Scanner;
import static java.lang.System.*;
import com.BankApplication.controller.bankController;
import com.BankApplication.model.bankModel;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		bankModel bm = new bankModel();
		bankController bc = new bankController();
		Scanner scan = new Scanner(System.in);
		out.println("\t\t************ WELCOME TO THE INDIAN BANK *************");
		out.println("\t--- Please fill the following information ---");

		// TAking Name,Account Number, Password, Balance as input via get and set
		// methods in bankModel class
		out.print("Enter the user name = ");
		String acHolderName = scan.next();
		bm.setAcHolder(acHolderName);
        
		// this try block is for Name checking whether user enters the name under described criteria or not 
		try {
			// this goes to controller class if correct then continue else generates an exception
			if (bc.checkUserName(bm)) 
			{
				out.print("\nEnter your Password = ");
				String acHolderPwd = scan.next();
				bm.setAcPassword(acHolderPwd);// in model class
				}
			
			// this try block is for Password checking whether user enters the password under described criteria or not 
				try {
					// this goes to controller class if correct then continue else generates an exception
					if (bc.checkPassword(bm)) {
						
						out.println("\n" + acHolderName + " Please, enter your account number = ");
						int acHolderNum = scan.nextInt();
						bm.setAcNumber(acHolderNum);;// in model class

						out.print("\nEnter Balance = ");
						int acHolderBalance = scan.nextInt();
						bm.setAcBalance(acHolderBalance);;// in model class

						out.println("\n\t\t----------------Your Bank Details Are----------------");

						out.print(bm.toString());;// in model class
						
						//here, while loop continues till user wants to make transaction 
						int in =0;
                        while (in<3) { 
                        	//this statement generates the options for transaction
						out.println("\n# To deposit press 1\n# To withdraw press 2\n# To exit press 0");
						
						 in = scan.nextInt();// inputs transaction number
						 // switch expression statement runs on the basis user input for transaction
						switch (in) {
						 //this case is to deposit 
						case 1 -> 
						{
							out.print("Enter password to verify : ");
							String pwd = scan.next();
							//try block is to verify password; if verified then transaction continues ; else generates an exception
							try {
								if (bc.pwdDeposit(bm, pwd)) // verification is performed here
									{
									out.print("Enter Amount to deposit");
									int depAmt = scan.nextInt();
									bm.amtDeposit(depAmt);// adds deposited  amount to the balance
									out.println("Your current balance is " + bm.getAcBalance());
								}

							}
							// the exception if password is not verified to deposit amount is handled here
							catch (Exception e)
							{
								out.print(e.getMessage());
							}

						}
						//this case is to deposit 
						case 2 -> 
						{
							out.print("Enter password to verify : ");
							String pwd = scan.next();
							out.print("Enter Amount to Withdraw :");
							int withAmt = scan.nextInt();
							
							//try block is to verify password and check the required amount; if verified then transaction continues ; else generates an exception
							try {
								if (bc.pwdWithdraw(bm, pwd, withAmt)) // verification is performed here
								{

									bm.amtWithdraw(withAmt);;// subtracts withdrawal amount from the balance
									out.println("Your current balance is " + bm.getAcBalance());
								}
							} 
							// the exception if password is not verified or if  withdraw amount is more than balance is handled here
							catch (Exception e) 
							{
								out.print(e.getMessage());
							}
						}//*****case -> 2 ends here*****
						default -> System.exit(0);
					}//*****Switch statement ends here*****
                  }// *****While Loop ends here*****
				}
				
				} 
				//this catch block is for password
				catch (Exception e) {
					out.println(e.getMessage());
				}

			
		
		}
         // this catch block is for username(acHolderName)
		catch (Exception e) {
			out.println(e.getMessage());

		}

		scan.close();
	
}
}
