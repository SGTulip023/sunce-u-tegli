package com.sunceutegli.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

import org.hibernate.Session;

import com.sunceutegli.dao.City;
import com.sunceutegli.dao.Country;
import com.sunceutegli.dao.GroupOfProducts;
import com.sunceutegli.dao.MethodOfPayment;
import com.sunceutegli.dao.OrderPlaced;
import com.sunceutegli.dao.Product;
import com.sunceutegli.dao.User;

public class TestConn {

	public static void main(String[] args) {
		/*		
		// testiranje konekcije
		String jdbcConnStr = "jdbc:mysql://localhost:3306/honey?useSSL=false";
		String user = "root";
		String password = "Chenta443896_";
		
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(jdbcConnStr, user, password);
			System.out.println("Da li je konekcija zatvorena:" + " " + conn.isClosed());
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
		*/
		
		
		
		
		Session session = HibernateConnection.createSessionFactory().openSession();
		
		try {
			System.out.println("Pocetak");
			
			session.beginTransaction();
			
			//GroupOfProducts group = session.get(GroupOfProducts.class, 1);
			
			Product p = session.get(Product.class, 2);
			
			OrderPlaced orderPlaced = new OrderPlaced("na cekanju", new Date(), 
					150, "puzecem", 
					new Date(), new User("Pera", "Peric", 
							"pera@peric.com", "pera", "+062353443", 
							"Branka Radicevica bb", "4546696", new City("Zrenjanin", 
									"23000", new Country("Srbija"))), 
					new MethodOfPayment("pouzecem"));
			
			session.persist(orderPlaced);
			
			session.getTransaction().commit();
			
			System.out.println("Kraj");
		}catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
		
		
		
		
	}
	
}
