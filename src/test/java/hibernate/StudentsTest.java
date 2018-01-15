package hibernate;


import java.util.Date;
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
		Students s = new Students(6,"����","��",new Date(),"�䵱");
		
//		�������
		session.save(s);
		
		  
		
	}
}
