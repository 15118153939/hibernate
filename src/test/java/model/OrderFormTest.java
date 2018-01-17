package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import com.lv.model.OrderForm;
import com.lv.util.HibernateUtil;

public class OrderFormTest extends BeanTest {
	

	/**
	 * 
	 * 
	 * 集合运算
	 * 1：in [not] empty 集合【不】为空，不包含任何元素
	 * 2：member of 袁术属于集合
	 * empty  ---> exists
	 * member of  ----> in
	 */
	
	@Test
	public void testCon() {
		String hql = "from Order o where o.orderItems is not empty";
		Query query = session.createQuery(hql);
		List<OrderForm> orders = query.list();
		for(OrderForm c:orders) {
			System.out.println(c);
		}
	}
	
	@Test
	public void testOrderForm() {
		
		
		String hql ="from OrderForm";
		Query query = session.createQuery(hql);
		
		
		List<OrderForm> orders = query.list();
		
		for(OrderForm c:orders) {
			System.out.println(c);
		}
		
		

		
	}
	


}
