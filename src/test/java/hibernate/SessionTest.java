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
//		��÷���ע�����
	      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	        //�����Ự��������
	      SessionFactory  sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	        //�Ự����
	      Session  session = sessionFactory.openSession();
	      Session session2 = sessionFactory.openSession();
	      System.out.println(session == session2);//false
	      Assert.assertNotNull(session);
		
	}
	@Test
	public void testGetCurrentSession() {
//		��÷���ע�����
	      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	        //�����Ự��������
	      SessionFactory  sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
	        //�Ự����
	      Session  session = sessionFactory.getCurrentSession();
	      Session session2 = sessionFactory.getCurrentSession();
	      
	      System.out.println(session == session2);//true
	   
	      Assert.assertNotNull(session);
		
	}

	/**
	 * ����Ŀ�ģ��۲첻�ֶ��رգ�session�������Ӳ�ʩ�ţ��ֶ��ر��˺�dowork��ᱨ����
	 */
	@Test
	public void testSaveStudentWithOpenSession() {
		// ��÷���ע�����
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// �����Ự��������
		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// �Ự����
		Session session = sessionFactory.openSession();

//		Students s = new Students(3, "л����", "��", new Date(), "�䵱");
		Students s = new Students();
		
		// ��������
		Transaction transaction = session.beginTransaction();
		//
		session.save(s);
		transaction.commit();
		//session.close(); //���ֶ��رգ�sessionָ������Ӷ��󲻻��ͷš�
		
		
		session.doWork(new Work() {

			public void execute(Connection connection) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("connection hashCode:"+connection.hashCode() );//true
			}
			
		});
		
		
		Session session2 = sessionFactory.openSession();
//		Students s2 = new Students(4, "л����", "��", new Date(), "�䵱");
		Students s2 = new Students();
		
		Transaction transaction2 = session2.beginTransaction();
		session2.save(s2);
		transaction2.commit();//�ύ����
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
		// ��÷���ע�����
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
				// �����Ự��������
				SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
				// �Ự����
				Session session = sessionFactory.getCurrentSession();

//				Students s = new Students(1, "������", "��", new Date(), "�䵱");
				Students s = new Students();
				
				// ��������
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
//				commit���Զ��رգ������dowork�� commit��ִ�У���ᱨ��
				transaction.commit();
			
				
			
				
				
				Session session2 =  sessionFactory.getCurrentSession();
//				Students s2 = new Students(2, "������", "��", new Date(), "�䵱");
				Students s2 = new Students();
				
				Transaction transaction2 = session2.beginTransaction();
				session2.save(s2);
				
				session2.doWork(new Work() {

					public void execute(Connection connection) throws SQLException {
						// TODO Auto-generated method stub
						System.out.println("connection2 hashCode:"+connection.hashCode() );//true
					}
					
				});
				
				transaction2.commit();//�ύ����
	

			
		
	}
	
}
