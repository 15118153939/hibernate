package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import com.lv.model.Commodity;
import com.lv.model.Customer;
import com.lv.model.OrderItem;
import com.lv.util.HibernateUtil;

public class OrderItemTest extends BeanTest {
	
	
	@Test
	public void testOrderItem() {
		
	
		String hql = "from orderitem";
		Query query = session.createQuery(hql);
		List<OrderItem> items = query.list();
		
		for(OrderItem o:items) {
			System.out.println(o);
		}
		
	}

}
