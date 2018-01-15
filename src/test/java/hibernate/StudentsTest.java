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
//		 * Hibernate5.x 以下
//		创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(config.getProperties()).build();
//		创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
//		会话对象
		session = sessionFactory.openSession();
//		开启事物
		transaction = session.beginTransaction();
		*/
//		Hibernate5.x 以上
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();
	}
	
	/**
	 * 
	 */
	@After 
	public void destory() {
//		释放资源
		transaction.commit();//提交事务
//		关闭会话
		session.close();
//		关闭会话工厂
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents() {


		
		
//		创建学生对象
//		Students s = new Students(6,"三丰","男",new Date(),"武当");
		
		Students s = new Students();
//		s.setAddress("峨眉山");
		s.setSname("李瞎子");
		s.setBirthday(new Date());
		s.setGender("男");
		
		Address address = new Address("123456","13410269069","草泥马");
		s.setAddress(address);
//		保存对象
		session.save(s);
		
		  
		
	}
	
	/**
	 * get方法立即发出sql语句  load不会

		get方法返回的是实体对象  load是代理对象

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
		s.setGender("女");
		session.update(s);

		System.out.println(s);
		
	}
	
	@Test
	public void testDeleteStudents() {
		Students s = session.get(Students.class, 1);
		session.delete(s );
		s.setGender("女");
		session.update(s);
		
		System.out.println(s);
		
	}
	

	
}
