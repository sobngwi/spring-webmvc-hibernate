package com.sobngwi.cache.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sobngwi.cache.hibernate.model.Employee;
import com.sobngwi.cache.hibernate.util.HibernateUtil;

public class HibernateEHCacheMain {

	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("cache.xml");
		System.out.println("Temp Dir:"+System.getProperty("java.io.tmpdir"));
		
		//Initialize Sessions
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Statistics stats = sessionFactory.getStatistics();
		System.out.println("Stats disable by default ====  FALSE="+stats.isStatisticsEnabled());
		stats.setStatisticsEnabled(true);
		System.out.println("Stats enabled TRUE="+stats.isStatisticsEnabled());
		
		Session session = sessionFactory.openSession();
		Session otherSession = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Transaction otherTransaction = otherSession.beginTransaction();
		
		printStats(stats, 0);
		System.out.println("------->");
		Employee emp = (Employee) session.load(Employee.class, 1L);
		//System.out.println("------->" + emp);
		printData(emp, stats, 1);
		
		emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 2);
		/*
		//clear first level cache, so that second level cache is used
		session.evict(emp);
		emp = (Employee) session.load(Employee.class, 1L);
		printData(emp, stats, 3);
		
		emp = (Employee) session.load(Employee.class, 3L);
		printData(emp, stats, 4);
		
		emp = (Employee) otherSession.load(Employee.class, 1L);
		printData(emp, stats, 5);
		
		//Release resources */
		transaction.commit();
		otherTransaction.commit();
		sessionFactory.close();
	}

	private static void printStats(Statistics stats, int i) {
		System.out.println("***** " + i + " *****");
		System.out.println("Fetch Entity Fetchs Count="
				+ stats.getEntityFetchCount());
		System.out.println("Second Level Hit : Entity Retrieve SuccessFully  Count="
				+ stats.getSecondLevelCacheHitCount());
		System.out
				.println("Second Level Entity Not Found  : Miss Count="
						+ stats
								.getSecondLevelCacheMissCount());
		System.out.println("Second Level Put Count="
				+ stats.getSecondLevelCachePutCount());
		System.out.println("Entity Load  Count="
				+ stats.getEntityLoadCount());
		System.out.println("Query Execution   Count="
				+ stats.getQueryExecutionCount());
		
	}

	private static void printData(Employee emp, Statistics stats, int count) {
		System.out.println(count+":: Name="+emp.getName()+", Zipcode="+emp.getAddress().getZipcode());
		printStats(stats, count);
	}

}
