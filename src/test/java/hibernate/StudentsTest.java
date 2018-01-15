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
		Students s = new Students(6,"三丰","男",new Date(),"武当");
		
//		保存对象
		session.save(s);
		
		  
		
	}
}
