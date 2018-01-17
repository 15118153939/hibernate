package model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.lv.model.Customer;
import com.lv.util.HibernateUtil;

public class CustomerTest extends BeanTest {
	

	
	/**
	 * ��ѯ����ʵ��
	 */
	
	@Test
	public void testSingleEntity() {
		
		String hql = "from Customer c where c.name = '����'";
		Query query = session.createQuery(hql);
		
		Customer c = (Customer) query.uniqueResult();
		
		System.out.println(c);
		
	}

	
	
	
	/**
	 * ģ��ƥ��
	 * ͨ�����%,�����ַ�
	 * 		  _����һ���ַ�
	 * 
	 */
	@Test
	public void testLike() {
//		String hql = "from Customer c where c.name like '��_'"; // ���ţ���������2���ַ�
		String hql = "from Customer c where c.address  like '%����%'"; //��ַ�ڱ�����
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();
		
		for(Customer c: customers) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
		}
	}
	
/**
 * ��Χ����
 */
	@Test
	public void testRange() {
//		String hql ="from Customer c where c.age in(20,40)";
//		String hql ="from Customer c where c.age not in(20,40)";
//		String hql ="from Customer c where c.age between 20 and 40";
		String hql ="from Customer c where c.age not between 30 and 40";
		
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();

		for(Customer c: customers) {
			System.out.println(c.getName());
			System.out.println(c.getAge());
		}
	}

	
	/**
	 * distinct ȥ�ظ�
	 */
	@Test
	public void testDistinct() {
//		String hql ="select sex from Customer";
		String hql ="select distinct sex from Customer";
		Query query = session.createQuery(hql);
		List<Object> list = query.list();
	 	
		for(Object o: list) {
			System.out.println(o);
		}
		
	}
	
	@Test
	public void testCustomer() {
	

		
		String hql ="from Customer";

		Query query = session.createQuery(hql);
		
		List<Customer> customers = query.list();
		
		for(Customer c:customers) {
			System.out.println(c);
		}
		
		
	}

}
