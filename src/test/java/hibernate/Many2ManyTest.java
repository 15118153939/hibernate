package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.lv.entity.Employee;
import com.lv.entity.Project;
import com.lv.util.HibernateUtil;

/*
 * 多对多关联关系的配置
 * 同时建立了Project和Employee之间的双向多对多关联关系
 * 关联关系的维护交由Project方来处理，并且在保存Project对象时会一并保存Employee对象
 */

public class Many2ManyTest {
	
	@Test
	public void save() {
		
		Project p1 = new Project(1001,"项目一");
		Project p2 = new Project(1002,"项目二");
		Project p3 = new Project(1003,"项目三");
		Project p4 = new Project(1004,"项目四");
		
		Employee e1 = new Employee(1,"女神");
		Employee e2 = new Employee(2,"男神");
		Employee e3 = new Employee(3,"疯子");
		Employee e4 = new Employee(4,"癫子");
		Employee e5 = new Employee(5,"妹子");
		Employee e6 = new Employee(6,"汉子");
		
//		参加项目1的员工有 女神，男神
	
		p1.getEmployees().add(e1);
		p1.getEmployees().add(e2);
//		项目2的只有男神
		p2.getEmployees().add(e1);
		p3.getEmployees().add(e3);

		
//		以上由项目到雇员的关系。
		
		e4.getProjects().add(p2);
		e5.getProjects().add(p3); 
		e6.getProjects().add(p4);
		
		
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//		// 创建会话工厂对象
//		SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
//		
		Session session = HibernateUtil.getSession();
//		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		
		session.save(e4);
		session.save(e5);
		session.save(e6);
		
		transaction.commit();
		
		HibernateUtil.closeSession(session);
		
	
	}

}
