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
	 * ��������
	 * 1��in [not] empty ���ϡ�����Ϊ�գ��������κ�Ԫ��
	 * 2��member of Ԭ�����ڼ���
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
