package hibernate;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lv.entity.Address;
import com.lv.entity.Students;

/**
 * 
 * @author lvmin
 *
 */

public class StudentsTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		/**
//		 * Hibernate5.x ����
//		�������ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(config.getProperties()).build();
//		�����Ự��������
		sessionFactory = config.buildSessionFactory(serviceRegistry);
//		�Ự����
		session = sessionFactory.openSession();
//		��������
		transaction = session.beginTransaction();
		*/
//		Hibernate5.x ����
        //��������ע�����
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //�����Ự��������
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //�Ự����
        session = sessionFactory.openSession();
        //��������
        transaction = session.beginTransaction();
	}
	
	/**
	 * 
	 */
	@After 
	public void destory() {
//		�ͷ���Դ
		transaction.commit();//�ύ����
//		�رջỰ
		session.close();
//		�رջỰ����
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents() {


		
		
//		����ѧ������
//		Students s = new Students(6,"����","��",new Date(),"�䵱");
		
		Students s = new Students();
//		s.setAddress("��üɽ");
		s.setSname("��Ϲ��");
		s.setBirthday(new Date());
		s.setGender("��");
		
		Address address = new Address("123456","13410269069","������");
		s.setAddress(address);
//		�������
		session.save(s);
		
		  
		
	}
	
	/**
	 * get������������sql���  load����

		get�������ص���ʵ�����  load�Ǵ������

	 */
	
	@Test
	public void testGetStudents() {
		Students s = session.get(Students.class, 100);
		
		System.out.println(s);
		
	}
	
	@Test
	public void testloadStudents() {
		Students s = session.load(Students.class, 11);
		
		System.out.println(s);
		
	}
	@Test
	public void testUpdateStudents() {
		
		Students s =session.get(Students.class, 1);
		s.setGender("Ů");
		session.update(s);

		System.out.println(s);
		
	}
	
	@Test
	public void testDeleteStudents() {
		Students s = session.get(Students.class, 1);
		session.delete(s );
		s.setGender("Ů");
		session.update(s);
		
		System.out.println(s);
		
	}
	

	
}
