package com.codeMantra.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.ast.tree.Statement;
import com.codeMantra.controller.*;


@Entity
@Table(name = "TIMESHEET_USERS")
public class UserDaoImpl {
	@Id
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "UserName")
	private String username;
	
	@Column(name = "Password")
	private String passsword;
	
	public UserDaoImpl(String userName, String passWord)
	{
		this.username = userName;
		this.passsword = passWord;
	}
	
	private static org.hibernate.SessionFactory sessionFactory;
	
	static {
		 final Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 sessionFactory = cfg.buildSessionFactory();
		 }
		 public static SessionFactory getInstance() {
		 return sessionFactory;
		 }

	
	public boolean CheckUser()
	{
		boolean userExist = false;
		try
		{
			Session session = sessionFactory.openSession();
			 Transaction tx = session.beginTransaction();
			 @SuppressWarnings("unchecked")
//			List<UserDaoImpl> users = session.createSQLQuery(String.format("SELECT \"ID\" FROM public.TIMESHEET_USERS WHERE \"UserName\"='%s' AND \"Password\"='%s';", this.username, this.passsword)).list();
			 Query sql = session.createSQLQuery(String.format("SELECT \"ID\" FROM public.\"TIMESHEET_USERS\" WHERE \"UserName\"='%s' AND \"Password\"='%s';", this.username, this.passsword));
			 
			 //sql.executeUpdate();
			 
			 List<Object[]> users = sql.list();
			
			 if(users.size() > 0)
			 {
				 Object id= sql.uniqueResult();
				 UserController.userID = Integer.parseInt(id.toString());
				 userExist = true;
			 }
			 tx.commit();
			 session.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}

		return userExist;
	}
}
