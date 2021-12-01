package frontend;

import java.util.List;

import entity.Account;
import repository.AccountRepository;

public class Funcition {
	AccountRepository accountRepository = new AccountRepository();

	public void getAllAccount() {
		System.out.println("Danh sách Account trên hệ thống");
		List<Account> list = accountRepository.get_FROM();

		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format( 
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------+%n");
	}

	public void getAccountById(short id) {
		Account account = accountRepository.get_ByID(id);
		if (account == null) {
			System.out.println("khong có ID này trên hệ thống");
		} else {
			System.out.println("Account cần tìm là :");
			System.out.println(account.toString());
		}
	}

	public void getFullName(short id) {
		String account = accountRepository.get_FullName(id);
		System.out.println(account);
	}

	public void getDay() {
		List<Account> list = accountRepository.get_ByCurrentMonth();

		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
	}

	public void getDayDESC() {
		List<Account> list = accountRepository.get_ByCurrentMonthOderBy();

		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Possition      | Create Date            |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+----------------+------------------------+%n");
		for (Account acc : list) {
			System.out.format(leftAlignFormat, acc.getId(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.getDepartment().getName(), acc.getPosition().getName(), acc.getCreateDate());
		}
	}

	public void get_CountAccByMonthInYearCurrent() {
		List<Object[]> list = accountRepository.get_CountAccByMonthInYearCurrent();
		for (Object[] objects : list) {
			System.out.println("Month:" + objects[0] + "SL:" + objects[1]);
		}
	}
	
	public void get_CountAccByMonthInYearCurrentgt2() {
		List<Object[]> list = accountRepository.get_CountAccByMonthInYearCurrent();
		for (Object[] objects : list) {
			System.out.println("Month:" + objects[0] + "SL:" + objects[1]);
		}
	}
	
	public void delete(String email) {
		accountRepository.deleteAccount(email);
	}
}
