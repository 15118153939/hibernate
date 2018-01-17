package model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.junit.Test;

import com.lv.model.Commodity;

/**
 * Ò»¼¶»º´æµÄdemo
 * @author lvmin
 *
 */
public class TestSecondCache extends BeanTest{

	@Test
	public void testSecondCache() {
		
	
	Commodity com =	session.get(Commodity.class, 1L);
	System.out.println(com.getName());
	
	
	 com =	session.get(Commodity.class, 1L);
	System.out.println(com.getName());
	}
}
