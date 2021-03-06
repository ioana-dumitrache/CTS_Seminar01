package ro.ase.cts;

import ro.ase.cts.exceptions.IllegalTransferException;
import ro.ase.cts.exceptions.InsufficientFundsException;
import ro.ase.cts.interfaces.NotificationService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank b=new Bank();
		BankAccount ba=b.openBankAccount(AccountType.CURRENT);
		SavingAccount sa=new SavingAccount(300, "IBAN3");
		CurrentAccount ca=new CurrentAccount(800, "IBAN");
		
		CurrentAccount ca2=new CurrentAccount(600, "IBAN2");
		System.out.println("suma disponibila este:"+ ca.getbalance());
		System.out.println("creditul maxim este "+CurrentAccount.MAX_CREDIT);
		ca.deposit(200);
		System.out.println("suma disponibila este:"+ ca.getbalance());
		try {
			ca.withdraw(600);
			ca.transfer(200,ca2);
			ca.setNotificationService(new SMSNotificationService());
			ca.setNotificationService(new NotificationService()
					{

						@Override
						public void sendNotificationService(String message) {
							// TODO Auto-generated method stub
							System.out.println("Send PUSH notif with message: "+message);
						}
				
					});
		} catch (InsufficientFundsException | IllegalTransferException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} 
		System.out.println("suma disponibila este:"+ ca.getbalance());
		System.out.println("suma disponibila din contul 2 este: "+ca2.getbalance());
		System.out.println("suma disponibila din contul 3 este: "+sa.getbalance());
		((SavingAccount) sa).deposit(300);
		//((Profitable) sa).addInterest(10);
		System.out.println("suma disponibila din contul 3 este: "+sa.getbalance());
		
	}
	

}
