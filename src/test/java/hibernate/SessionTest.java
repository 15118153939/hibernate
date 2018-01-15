package hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lv.entity.Students;
public class SessionTest {

	@Test
	public void testOpenSession() {
//		获得服务注册对象
	      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	        //创建会话工厂对象
	      SessionFactory  sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	        //会话对象
	      Session  session = sessionFactory.openSession();
	      Session session2 = sessionFactory.openSession();
	      System.out.println(session == session2);//false
	      Assert.assertNotNull(session);
		
	}
	@Test
	public void testGetCurrentSession() {
//		获得服务注册对象
	      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	        //创建会话工厂对象
	      SessionFactory  sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	        //会话对象
	      Session  session = sessionFactory.getCurrentSession();
	      Session session2 = sessionFactory.getCurrentSession();
	      
	      System.out.println(session == session2);//true
	   
	      Assert.assertNotNull(session);
		
	}

	/**
	 * 测试目的：观察不手动关闭，session，测连接不施放，手动关闭了后，dowork则会报错咯，
	 */
	@Test
	public void testSaveStudentWithOpenSession() {
		// 获得服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建会话工厂对象
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// 会话对象
		Session session = sessionFactory.openSession();

//		Students s = new Students(3, "谢二哥", "男", new Date(), "武当");
		Students s = new Students();
		
		// 开启事务
		Transaction transaction = session.beginTransaction();
		//
		session.save(s);
		transaction.commit();
		//session.close(); //不手动关闭，session指向的连接对象不会释放。
		
		
		session.doWork(new Work() {

			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("connection hashCode:"+connection.hashCode() );//true
			}
			
		});
		
		
		Session session2 = sessionFactory.openSession();
//		Students s2 = new Students(4, "谢三哥", "男", new Date(), "武当");
		Students s2 = new Students();
		
		Transaction transaction2 = session2.beginTransaction();
		session2.save(s2);
		transaction2.commit();//提交事务
		//session2.close();

		session2.doWork(new Work() {

			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("connection2 hashCode:"+connection.hashCode() );//true
			}
			
		});
		
//		
	}
	/**
	 * 
	 */
	@Test
	public void testSaveStudentWithgetCurrentSession() {
		// 获得服务注册对象
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
				// 创建会话工厂对象
				SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
				// 会话对象
				Session session = sessionFactory.getCurrentSession();

//				Students s = new Students(1, "王二哥", "男", new Date(), "武当");
				Students s = new Students();
				
				// 开启事务
				Transaction transaction = session.beginTransaction();
				//
				session.save(s);
				
				
//			
				session.doWork(new Work() {

					public void execute(Connection connection) throws SQLException {
						// TODO Auto-generated method stub
						System.out.println("connection hashCode:"+connection.hashCode() );//true
					}
					
				});
//				commit后自动关闭，如果把dowork丢 commit后执行，则会报错咯
				transaction.commit();
			
				
			
				
				
				Session session2 =  sessionFactory.getCurrentSession();
//				Students s2 = new Students(2, "王三哥", "男", new Date(), "武当");
				Students s2 = new Students();
				
				Transaction transaction2 = session2.beginTransaction();
				session2.save(s2);
				
				session2.doWork(new Work() {

					public void execute(Connection connection) throws SQLException {
						// TODO Auto-generated method stub
						System.out.println("connection2 hashCode:"+connection.hashCode() );//true
					}
					
				});
				
				transaction2.commit();//提交事务
	

			
		
	}
	
}
