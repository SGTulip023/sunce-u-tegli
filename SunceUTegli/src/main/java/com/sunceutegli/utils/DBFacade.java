package com.sunceutegli.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * @author: Stevan Tomasev
 * ovu fasadu previm prema trenutnim potrebama
 */

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBFacade {
	
	private static Session session;
	private static Transaction transaction;
	
	// metoda za perzistovanje tranzijentnih objekata
	// dajem prednost persist() u  odnosu na save()
	public static boolean persistEntity(Object object) {

		session = HibernateConnection.createSessionFactory().openSession();

		try {
			transaction = session.beginTransaction();
			session.persist(object);
			transaction.commit();

			return true;

		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}

			return false;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	// metoda za izmenu entiteta
	// dajem prednost merge() zato sto ne vraca izuzetak
	public static boolean mergeEntity(Object object) {

		session = HibernateConnection.createSessionFactory().openSession();

		try {
			transaction = session.beginTransaction();
			session.merge(object);
			transaction.commit();

			return true;

		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}

			return false;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public static List retriveEntity(String jpql) {

		session = HibernateConnection.createSessionFactory().openSession();
		List res = new ArrayList();

		try {
			transaction = session.beginTransaction();
			res = session.createQuery(jpql).getResultList();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();

			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		return res;
	}


}
