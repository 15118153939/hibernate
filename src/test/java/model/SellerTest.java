package model;



import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lv.model.Seller;
import com.lv.util.HibernateUtil;


public class SellerTest {
	
	private Session session ;
	
	/**
	 * �Զ��壬��Ҫʵ�����ж�Ӧ�Ĺ��췽��
	 */
	
	
	@Before
	public void init() {
		session = HibernateUtil.getSession();
	}
	@After
	public void destory() {
		HibernateUtil.closeSession(session);
	}
	@Test
	public void testSelectClauseSelf(){
		
		String hql = " select new Seller(s.name,s.tel,s.address) from Seller s ";
		Query query = session.createQuery(hql);
		List<Seller> sellers = query.list();
		
		for(Seller seller : sellers){
			System.out.println("name: "+seller.getName());
			System.out.println("tel:"+seller.getTel());
			System.out.println("address:"+seller.getAddress());
		}
		
	}
	
	
	/**
	 * 
	 */
	@Test
	public void TestSelectClauseMap() {
		String hql ="select new map(s.name,s.tel,s.address) from Seller s";
		Query query = session.createQuery(hql);
		
		List<Map> maps = query.list();
		
		for(Map map : maps){
			System.out.println("name:"+map.get("0"));
			System.out.println("tel:"+map.get("1"));
			System.out.println("address:"+map.get("2"));
		}
	}
	/**
	 * ʹ��map,������ʹ�ñ���
	 */
	@Test
	public void TestSelectClauseMapAlias() {
		String hql ="select new map(s.name as name,s.tel as tel,s.address as address) from Seller s";
		Query query = session.createQuery(hql);
		
		List<Map> maps = query.list();
		
		for(Map map : maps){
			System.out.println("name:"+map.get("name"));
			System.out.println("tel:"+map.get("tel"));
			System.out.println("address:"+map.get("address"));
		}
	}
	
	
	/**
	 * new list(�ֶ�...) ����list
	 */
	@Test
	public void testSelectClauseList(){
		
		String hql = " select new list(s.name,s.tel,s.address) from Seller s ";
		
		Query query = session.createQuery(hql);
		List<List> lists = query.list();
		
		for(List list : lists){
			System.out.println("name : "+list.get(0));
			System.out.println("tel:"+list.get(1));
			System.out.println("address:"+list.get(2));
		}
		
	}
	
	
	/**
	 * 1,name,tel,3 address ,4 star �Ӿ��ѯ�����ֶ��@������ ���ݴ����������ص�object[]
	 */
	@Test
	public void testSelectClauseObjectArray() {
		String hql ="select s.name ,s.tel,s.address ,s.star from Seller s";
		
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		
		for(Object[] objs : list) {
			System.out.println("name:"+ objs[0]);
			System.out.println("tel:"+ objs[1]);
			System.out.println("address:"+ objs[2]);
			System.out.println("star:"+ objs[3]);
		}
		
		
		
	}
	
	/**
	 * ���select ֻ��һ���ֶΣ��򷵻ص���object��������object���飬������
	 */
	@Test
	public void testSelectClauseObject() {
		String hql ="select s.name  from Seller s";
		session = HibernateUtil.getSession();
		
		Query query = session.createQuery(hql);
		List<Object> list = query.list();
		
		for(Object obj : list) {
			System.out.println("name:"+ obj);
	
		}
		HibernateUtil.closeSession(session);
	}
	
	@Test
	public void TestfromClause() {

		String hql = " from Seller  s ";

		session = HibernateUtil.getSession();
		Query query = session.createQuery(hql);

		List<Seller> sellers = query.list();
		for (Seller seller : sellers) {
			System.out.println("name:" + seller.getName());
		}

		HibernateUtil.closeSession(session);
	}
	
	@Test
	public void testList() {
		
		String hql = "from Seller as s";
		session = HibernateUtil.getSession();
		
		
		
		Query query = session.createQuery(hql);
		
		List<Seller> sllers = query.list();
		
		for(Seller s:sllers) {
			System.out.println(s);
		}
		
		
		HibernateUtil.closeSession(session);
	}
	
	

}
