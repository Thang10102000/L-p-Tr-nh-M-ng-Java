package frontend;

import java.util.List;
import java.util.Scanner;

import repository.AccountRepository;

public class Main {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		Funcition funcition = new Funcition();
		 funcition.getAllAccount();
		// System.out.println("nhập ID :");
		// short id=inputScanner.nextShort();
		// funcition.getAccountById(id);
		// funcition.getFullName(id);
		// funcition.getDay();
		// funcition.getDayDESC();
		//funcition.get_CountAccByMonthInYearCurrent();
		//funcition.get_CountAccByMonthInYearCurrentgt2();
		//update();
		
		//System.out.println("nhập email cần xóa");
		//String email= inputScanner.nextLine();
		//funcition.delete(email);
		//funcition.getAllAccount();
		
		
		
	}

	public static void update() {
		Scanner inputScanner = new Scanner(System.in);

		System.out.println("Nhập vào ID cần Update: ");
		short id = inputScanner.nextShort();
		inputScanner.nextLine();
		System.out.println("Nhập vào NewEmail: ");
		String email = inputScanner.nextLine();
		System.out.println("Nhập vào NewUsername: ");

		String username = inputScanner.nextLine();
		AccountRepository accountRepository=new AccountRepository();
		accountRepository.updateEmailUsernameAccountByID(email, username, id);
          Funcition funcition=new Funcition();
          funcition.getAllAccount();
          
	}
}
