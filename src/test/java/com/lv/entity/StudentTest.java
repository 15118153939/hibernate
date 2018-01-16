package com.lv.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lv.util.HibernateUtil;

public class StudentTest {

	
	@Test
	public void save() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Grade g = new Grade();
		g.setGname("终极多对一班");
		g.setGdesc("很吊的终极一班");
		
		session.save(g);
		
		for(int i=0;i<10 ;i++) {
			Student s = new Student("隔壁老王"+i, i%2==0?"男":"女");

//			设置关联关系
			s.setGrade(g);
			session.save(s);
			
		}
		transaction.commit();
		HibernateUtil.closeSession(session);
		
	}
}
