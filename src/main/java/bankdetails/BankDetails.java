package bankdetails;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import customerdetails.BankSbi;

public class BankDetails {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(BankSbi.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		// SessionFactory factory = meta.getSessionFactoryBuilder().build();
		// Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		while (true) {
			System.out.println("Choose the number...");
			System.out.println("1.Add details \n2.Deposit amount \n3.Withdrawn amount");
			Scanner sc = new Scanner(System.in);
			int number;
			int balance = 1000;
			System.out.print("Enter the number:");
			balance = sc.nextInt();
			if (balance > 0) {
				switch (balance) {
				case 1:
					BankSbi bank = new BankSbi();
					bank.setAccountnumber(1);
					bank.setCustomerName("Kalpana");
					bank.setDeposit(10000);
					bank.setBalance(10000);
					bank.setWithdraw(5000);

					session.save(bank);
					transaction.commit();
					System.out.println("successfully saved");
					factory.close();
					session.close();
					break;

				case 2:
					System.out.print("Enter the amount to be deposited:");
					double deposit = sc.nextDouble();
					balance = (int) (balance + deposit);
					System.out.println("Total balance:" + balance);
					break;
				case 3:
					System.out.print("Enter the amount to be withdrawn:");
					double withdraw = sc.nextDouble();
					balance = (int) (balance - withdraw);
					System.out.println("Total balance:" + balance);
					break;

				}
			}
		}
	}
}