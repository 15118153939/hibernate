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
 * ��Զ������ϵ������
 * ͬʱ������Project��Employee֮���˫���Զ������ϵ
 * ������ϵ��ά������Project�������������ڱ���Project����ʱ��һ������Employee����
 */

public class Many2ManyTest {
	
	@Test
	public void save() {
		
		Project p1 = new Project(1001,"��Ŀһ");
		Project p2 = new Project(1002,"��Ŀ��");
		Project p3 = new Project(1003,"��Ŀ��");
		Project p4 = new Project(1004,"��Ŀ��");
		
		Employee e1 = new Employee(1,"Ů��");
		Employee e2 = new Employee(2,"����");
		Employee e3 = new Employee(3,"����");
		Employee e4 = new Employee(4,"���");
		Employee e5 = new Employee(5,"����");
		Employee e6 = new Employee(6,"����");
		
//		�μ���Ŀ1��Ա���� Ů������
	
		p1.getEmployees().add(e1);
		p1.getEmployees().add(e2);
//		��Ŀ2��ֻ������
		p2.getEmployees().add(e1);
		p3.getEmployees().add(e3);

		
//		��������Ŀ����Ա�Ĺ�ϵ��
		
		e4.getProjects().add(p2);
		e5.getProjects().add(p3); 
		e6.getProjects().add(p4);
		
		
//		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//		// �����Ự��������
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
