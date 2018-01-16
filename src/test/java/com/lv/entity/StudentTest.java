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
		g.setGname("级联二班");
		g.setGdesc("很吊的终极一班");
		
		
		
		for(int i=0;i<10 ;i++) {
			Student s = new Student("王"+i, i%2==0?"男":"女");
//			设置关联关系--双向设置
			s.setGrade(g);
			g.getStudents().add(s);
//			级联操作，不现实保存学生，也会级联保存和班级相关的学生。
//			session.save(s);
		}
		
		session.save(g);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
	}
}
