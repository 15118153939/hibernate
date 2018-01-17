package model;

import java.util.Iterator;
import java.util.List;

import org.hibernate.query.Query;
import org.junit.Test;

import com.lv.model.Commodity;

/**
 * 一级缓存的demo
 * @author lvmin
 *
 */
public class TestCache extends BeanTest{

	@Test
	public void testCache() {
		
		Commodity com =	session.get(Commodity.class, 1L);
		System.out.println(com.getName());
		
//		evict方法清楚一级缓存中的指定对象,所以下面又需要执行sql了
		session.evict(com);
		
//		clear 清楚一级缓存中的所有内容
	
			com =	session.get(Commodity.class, 1L);
		System.out.println(com.getName());
		
		
//		查询多行信息
		Query query = session.createQuery("from Commodity");
		
		List<Commodity> list = query.list();
		
		for(Commodity c:list) {
			System.out.println(c.getName());
		}
		
			list = query.list();
		
		for(Commodity c:list) {
			System.out.println(c.getName());
		}
//		query.list(),是不会使用到缓存的
		
		
//		迭代器 iterator
//		迭代器：首先查询所有的id,然后缓存中查询，如果没有又要去数据库查询。多少个发送多少个sql
		Iterator it = query.iterate();
		
		while(it.hasNext()) {
			Commodity c = (Commodity) it.next();
			System.out.println("iterator: "+c.getName());
			
		}
		
	}
}
