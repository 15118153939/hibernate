package model;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

import com.lv.util.HibernateUtil;

public class BeanTest {
	protected Session session;
	
	@Before
	public void init() {
		session = HibernateUtil.getSession();
	}
	@After
	public void distory() {
		HibernateUtil.closeSession(session);
	}

}
