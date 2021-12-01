package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import entity.Account;
import entity.Department;
import entity.Position;
import entity.Position.PositionName;
import utils.HibernateUtils;

public class AccountRepository {
	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public List<Account> get_FROM() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			// Query<Account> query = session.createQuery("FROM Account ");
			// return query.list();

			// create Criteria query
			// CriteriaBuilder builder = session.getCriteriaBuilder();
			// CriteriaQuery<Account> query = builder.createQuery(Account.class);
			// Root<Account> root = query.from(Account.class); // from account
			// query.select(root); // select
			// List<Account> list = session.createQuery(query).list();
			// return list;

			// create Native query
			// Câu lênh sql như câu lệnh viết trong Workbench
			NativeQuery query = session.createNativeQuery(
					"SELECT a.AccountID, a.Email, a.Username, a.FullName, d.DepartmentName, p.PositionName FROM account a \r\n"
							+ "INNER JOIN department d ON a.DepartmentID = d.DepartmentID\r\n"
							+ "INNER JOIN position p ON a.PositionID = p.PositionID;");

// Phần query này sẽ tạo ra 1 list các array object, sử dụng vòng lặp foreach để truy vấn tới các phần tử trong array, lấy các giá trị trong DB theo Index của array bắt đầu từ 0.
			List<Account> accountList = new ArrayList<Account>();
			List<Object[]> accounts = query.getResultList();
			for (Object[] objects : accounts) {
				Account account = new Account();
				account.setId(Short.parseShort(objects[0].toString()));
				account.setEmail(objects[1].toString());
				account.setUsername(objects[2].toString());
				account.setFullname(objects[3].toString());

				account.setDepartment(new Department(objects[4].toString()));
				account.setPosition(new Position(PositionName.valueOf(objects[5].toString())));
				accountList.add(account);

//				Cách khác.
//				NativeQuery query = session.createNativeQuery("SELECT * FROM account", Account.class );
//			    List<Account> accountList = query.getResultList();

			}
			return accountList;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account get_ByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
//			String hql = "FROM Account AS u WHERE u.id = :id";
//			Query<Account> query = session.createQuery(hql, Account.class);
//			query.setParameter("id", id);
//			// get result
//			Account account = query.uniqueResult();
//			return account;

			// create Criteria query
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Account> query = builder.createQuery(Account.class);
//			Root<Account> root = query.from(Account.class);
//			query.select(root);
//			query.where(builder.equal(root.get("id"), id));
//			Account account = session.createQuery(query).uniqueResult();
//			return account;

			// create Native query
//			Câu lênh sql như câu lệnh viết trong Workbench
			NativeQuery query = session.createNativeQuery(
					"SELECT a.AccountID, a.Email, a.Username, a.FullName, d.DepartmentName, p.PositionName FROM account a \r\n"
							+ "INNER JOIN department d ON a.DepartmentID = d.DepartmentID\r\n"
							+ "INNER JOIN position p ON a.PositionID = p.PositionID\r\n" + "WHERE a.AccountID = ?;");
			Account account = new Account();
			Object[] objects = (Object[]) query.getSingleResult();

			query.setParameter(1, id);
			account.setId(Short.parseShort(objects[0].toString()));
			account.setEmail(objects[1].toString());
			account.setUsername(objects[2].toString());
			account.setFullname(objects[3].toString());

			account.setDepartment(new Department(objects[4].toString()));
			account.setPosition(new Position(PositionName.valueOf(objects[5].toString())));

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public String get_FullName(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query, hàm này sẽ về các đối tượng kiểu String, không phải kiểu
			// Account như bên trên.
			// String hql = "SELECT a.fullname FROM Account a WHERE a.id = :id";
			// Query<String> query = session.createQuery(hql, String.class);
			// query.setParameter("id", id);
			// get result
			// String fullname = query.uniqueResult();
			// return fullname;

			//// create Criteria query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<String> query = builder.createQuery(String.class);
			Root<Account> root = query.from(Account.class);
			query.multiselect(root.get("fullname")); // select
			query.where(builder.equal(root.get("id"), id));
			String fullname = session.createQuery(query).uniqueResult();
			return fullname;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	// Giới hạn điều kiện trả về với WHERE: Lấy ra tất cả các Account được tạo trong
	// tháng hiện tại.

	public List<Account> get_ByCurrentMonth() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create HQL
			// String hql = "FROM Account a WHERE month(a.createDate) <= month(sysdate())";
			// Query<Account> query = session.createQuery(hql, Account.class);
			// get result
			// List<Account> accounts = query.list();
			// return accounts;

			// create Criteria query
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class);
			Expression<Integer> monthCreateDate = builder.function("month", Integer.class, root.get("createDate"));
			Expression<Integer> monthCurent = builder.function("month", Integer.class, builder.currentDate());

//			query.where(builder.equal(root.get("createDate"), builder.currentDate()));
			query.where(builder.equal(monthCreateDate, monthCurent));

			List<Account> accounts = session.createQuery(query).list();
			return accounts;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//		Lấy danh sách Account được tạo trong tháng hiện tại và sắp xếp theo ngảy tạo giảm dần hoặc tăng dần.
	public List<Account> get_ByCurrentMonthOderBy() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// Account như bên trên.
			// String hql = "FROM Account a WHERE month(a.createDate) <= month(sysdate())
			// ORDER BY a.createDate DESC";
			// Query<Account> query = session.createQuery(hql, Account.class);
			// get result
			// List<Account> accounts = query.list();
			// return accounts;

			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class); // FROM
			query.select(root);
			Expression<Integer> monthCreateDate = builder.function("month", Integer.class, root.get("createDate"));
			Expression<Integer> monthCurent = builder.function("month", Integer.class, builder.currentDate());
			query.where(builder.equal(monthCreateDate, monthCurent));
			query.orderBy(builder.desc(root.get("createDate")));
			List<Account> accounts = session.createQuery(query).list();
			return accounts;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<Object[]> get_CountAccByMonthInYearCurrent() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// Account như bên trên.
			String hql = "SELECT month(createDate) AS month, COUNT(createDate) AS SL FROM Account WHERE year(createDate) = year(sysdate()) GROUP BY month(createDate)";
//				Kết quả trả về là 1 mảng kiểu đổi tượng
			Query<Object[]> query = session.createQuery(hql);
			// get result: trả về 1 list mảng các đối tượng
			List<Object[]> results = query.list();
			return results;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//		Đếm số Account được tạo trong mỗi tháng của năm hiện tại với điều kiện tháng có ít nhất 2 Account được tạo.
	public List<Object[]> get_CountAccByMonthInYearCurrentgt2() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// Account như bên trên.
			String hql = "SELECT month(createDate) AS month, COUNT(createDate) AS SL "
					+ "FROM Account WHERE year(createDate) = year(sysdate())"
					+ " GROUP BY month(createDate) HAVING COUNT(createDate) >2";
//				Kết quả trả về là 1 mảng kiểu đổi tượng
			Query<Object[]> query = session.createQuery(hql);
			// get result: trả về 1 list mảng các đối tượng
			List<Object[]> results = query.list();
			return results;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	Update theo trường bất kỳ.
	public void updateEmailUsernameAccountByID(String newEmail, String newUsername, short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update HQL
			// String hql = "UPDATE Account SET email = :email, username = :username WHERE
			// id = :id";
			// Query query = session.createQuery(hql);
			// query.setParameter("email", newEmail);
			// query.setParameter("username", newUsername);
			// query.setParameter("id", id);
			// int affectedRows = query.executeUpdate();

			// criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaUpdate<Account> query1 = builder.createCriteriaUpdate(Account.class);
			Root<Account> root = query1.from(Account.class); // FROM
			query1.set("email", newEmail);
			query1.set("username", newUsername);
			query1.where(builder.equal(root.get("id"), id));

			session.createQuery(query1).executeUpdate();

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	Delete theo trường bất kỳ
	public void deleteAccount(String email) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// Delete
			// String hql = "DELETE FROM Account WHERE email = :email";
			// Query query = session.createQuery(hql);
			// query.setParameter("email", email);
			// int affectedRows = query.executeUpdate();

			// criteria
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Account> query = builder.createQuery(Account.class);
			Root<Account> root = query.from(Account.class); // FROM
			query.select(root);
			query.where(builder.equal(root.get("email"), email));
			Account account = session.createQuery(query).uniqueResult();
			session.delete(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

//	Phân trang bằng hibernate
	public List<Account> get_AccountByPaging() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			String hql = "FROM Account ORDER BY id";
			// create hql query
			Query<Account> query = session.createQuery(hql);
			query.setFirstResult(5);
			query.setMaxResults(3);
			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
