package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lv.model.Commodity;
import com.lv.model.Customer;
import com.lv.util.HibernateUtil;

public class CommodityTest extends BeanTest {
	
	/**
	 * 1:����asc
	 * 2������desc
	 */
	
	@Test
	public void testOrderBy() {
//		String hql ="from Commodity order by price desc";
		String hql ="from Commodity order by price asc";

		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for(Commodity c:commoditys) {
			System.out.println(c);
		}
	}

	
	/**
	 * ��������
	 * 1��in [not] empty ���ϡ�����Ϊ�գ��������κ�Ԫ��
	 * 2��member of Ԭ�����ڼ���
	 * empty  ---> exists
	 * member of  ----> in
	 */

	/** 
	 * �߼�����
	 *  and��or
	 *  not
	 * 
	 */
	@Test
	public void testlogic() {
		
//		String hql ="from Commodity c where c.price between 100 and 5000 and c.category like '%����%'";
		String hql ="from Commodity c where c.price between 100 and 5000 or c.category like '%����%'";
		
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for(Commodity c:commoditys) {
			System.out.println(c);
		}
	}
	
	
	/**
	 * 2:null �ж� is not null
	 * x=null hibernate ��ת��sql Ϊx is null
	 * x<> null  --->  x is not null
	 */
	@Test
	public void whereNull() {
		String hql = "from Commodity c where c.description <> null";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		for(Commodity c:commoditys) {
			System.out.println(c);
		}
		
	}
	
	
	
	/**
	 * �Ƚ�����
	 * 1:=,<>,<,>,>=,<=  
	 * 2:null �ж� is not null
	 * x=null hibernate ��ת��sql Ϊx is null
	 * x<> null  --->  x is not null
	 */
	
	@Test
	public void testWhereComparisons() {
		String hql = "from Commodity c where c.price > 400";
		
		Query query = session.createQuery(hql);
		
		List<Commodity> commoditys = query.list();
		
		for(Commodity c:commoditys) {
			System.out.println("name:"+c.getName());
			System.out.println("price:"+c.getPrice());
		}
		
	}
	
	
	
	@Test
	public void testCommodity() {
		
		session = HibernateUtil.getSession();
		String hql ="from Commodity";
		Query query = session.createQuery(hql);
		List<Commodity> commoditys = query.list();
		
		for(Commodity c:commoditys) {
			System.out.println(c);
		}

	}

}
