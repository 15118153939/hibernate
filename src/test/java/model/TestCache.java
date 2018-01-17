package model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.junit.Test;

import com.lv.model.Commodity;

/**
 * һ�������demo
 * @author lvmin
 *
 */
public class TestCache extends BeanTest{

	@Test
	public void testCache() {
		
		Commodity com =	session.get(Commodity.class, 1L);
		System.out.println(com.getName());
		
//		evict�������һ�������е�ָ������,������������Ҫִ��sql��
		session.evict(com);
		
//		clear ���һ�������е���������
	
			com =	session.get(Commodity.class, 1L);
		System.out.println(com.getName());
		
		
//		��ѯ������Ϣ
		Query query = session.createQuery("from Commodity");
		
		List<Commodity> list = query.list();
		
		for(Commodity c:list) {
			System.out.println(c.getName());
		}
		
			list = query.list();
		
		for(Commodity c:list) {
			System.out.println(c.getName());
		}
//		query.list(),�ǲ���ʹ�õ������
		
		
//		������ iterator
//		�����������Ȳ�ѯ���е�id,Ȼ�󻺴��в�ѯ�����û����Ҫȥ���ݿ��ѯ�����ٸ����Ͷ��ٸ�sql
		Iterator it = query.iterate();
		
		while(it.hasNext()) {
			Commodity c = (Commodity) it.next();
			System.out.println("iterator: "+c.getName());
			
		}
		
	}
}
