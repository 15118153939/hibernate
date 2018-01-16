package com.lv.entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lv.util.HibernateUtil;

/**
 * ����һ�� ���ϵ��ϵ���༶ --->ѧ����
 * @author lvmin
 *
 */
public class TestGrade {

	/**
	 * ���
	 */
	@Test
	public void add() {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		
		Grade g = new Grade();
		g.setGname("�ռ�һ��");
		g.setGdesc("�����ţ��Ӵ");
		
		for(int i=0;i<10 ;i++) {
			Student s = new Student("��"+i, i%2==0?"��":"Ů");
//		���ϣ����ѧ��������Ӷ�Ӧ�İ༶��ţ���Ҫ�ڰ༶�����ѧ��������������ϵ
			g.getStudents().add(s);
			
			session.save(s);
			
		}
		session.save(g);
		
		transaction.commit();
		
//		�ر�
		HibernateUtil.closeSession(session);
		
	}
	
	/**
	 * ����������ϵ�󣬿��Է���Ĵ�һ�����󣬵�������һ������
	 * ע������ķ���
	 */
	
	@Test
	public void findStudentByGrade() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Grade grade = session.get(Grade.class, 1);
		
		System.out.println(grade);
		
//		�ɰ༶��ѯ�༶������ѧ��
		Set<Student> students = grade.getStudents();
		
		for(Student stu: students) {
			System.out.println(stu.toString());
		}
		
		transaction.commit();
		
//		�ر�
		HibernateUtil.closeSession(session);
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 */
	
	@Test
	public void update() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Grade g = new Grade();
		g.setGname("�ռ�����");
		g.setGdesc("�ܵ����ռ�����");
		
		Student stu = session.get(Student.class,1);
//		��ӵ�����
		g.getStudents().add(stu);
		
		session.save(g);
		transaction.commit();
		

		
//		�ر�
		HibernateUtil.closeSession(session);
	}
	
//	ɾ��ѧ����Ϣ
	@Test
	public void deletetest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student stu = session.get(Student.class,2);
		
		session.delete(stu);
		transaction.commit();
//		�ر�
		HibernateUtil.closeSession(session);
	}
}
