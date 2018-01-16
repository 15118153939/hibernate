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
		g.setGname("��������");
		g.setGdesc("�ܵ����ռ�һ��");
		
		
		
		for(int i=0;i<10 ;i++) {
			Student s = new Student("��"+i, i%2==0?"��":"Ů");
//			���ù�����ϵ--˫������
			s.setGrade(g);
			g.getStudents().add(s);
//			��������������ʵ����ѧ����Ҳ�ἶ������Ͱ༶��ص�ѧ����
//			session.save(s);
		}
		
		session.save(g);
		transaction.commit();
		HibernateUtil.closeSession(session);
		
	}
}
