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
	 * 查询单个实例
	 */
	
	@Test
	public void testSingleEntity() {
		
		String hql = "from Customer c where c.name = '张三'";
		Query query = session.createQuery(hql);
		
		Customer c = (Customer) query.uniqueResult();
		
		System.out.println(c);
		
	}

	
	
	
	/**
	 * 模糊匹配
	 * 通配符：%,任意字符
	 * 		  _任意一个字符
	 * 
	 */
	@Test
	public void testLike() {
//		String hql = "from Customer c where c.name like '张_'"; // 姓张，且名字是2个字符
		String hql = "from Customer c where c.address  like '%北京%'"; //地址在北京的
		Query query = session.createQuery(hql);
		List<Customer> customers = query.list();
		
		for(Customer c: customers) {
			System.out.println(c.getName());
			System.out.println(c.getAddress());
		}
	}
	
/**
 * 范围查找
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
	 * distinct 去重复
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
