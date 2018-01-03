package com.sunceutegli.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.sunceutegli.dao.City;
import com.sunceutegli.dao.Comment;
import com.sunceutegli.dao.Country;
import com.sunceutegli.dao.Discount;
import com.sunceutegli.dao.GroupOfProducts;
import com.sunceutegli.dao.Item;
import com.sunceutegli.dao.MethodOfPayment;
import com.sunceutegli.dao.OrderPlaced;
import com.sunceutegli.dao.Product;
import com.sunceutegli.dao.User;

public class HibernateConnection {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	// kreiranje fabrike sesija
	protected static SessionFactory createSessionFactory() {
		// ne znam zbog cega mi ne prihvata iz xml anotiranje klase, odnosno koja je
		// klasa mapirana anotacijama
		Configuration configuration = new Configuration();
		// na ovaj mi nacin radi
		configuration.configure()
						.addAnnotatedClass(City.class)
						.addAnnotatedClass(Comment.class)
						.addAnnotatedClass(Country.class)
						.addAnnotatedClass(Discount.class)
						.addAnnotatedClass(GroupOfProducts.class)
						.addAnnotatedClass(Item.class)
						.addAnnotatedClass(MethodOfPayment.class)
						.addAnnotatedClass(OrderPlaced.class)
						.addAnnotatedClass(Product.class)
						.addAnnotatedClass(User.class);

		serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		return sessionFactory;
	}
}
