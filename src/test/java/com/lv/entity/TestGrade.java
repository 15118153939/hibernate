package com.lv.entity;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lv.util.HibernateUtil;

/**
 * 单向一对 多关系关系《班级 --->学生》
 * @author lvmin
 *
 */
public class TestGrade {

	/**
	 * 添加
	 */
	@Test
	public void add() {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		
		
		Grade g = new Grade();
		g.setGname("终极一班");
		g.setGdesc("这个很牛逼哟");
		
		for(int i=0;i<10 ;i++) {
			Student s = new Student("张"+i, i%2==0?"男":"女");
//		如果希望在学生表中添加对应的班级编号，需要在班级中添加学生，建立关联关系
			g.getStudents().add(s);
			
			session.save(s);
			
		}
		session.save(g);
		
		transaction.commit();
		
//		关闭
		HibernateUtil.closeSession(session);
		
	}
	
	/**
	 * 建立关联关系后，可以方便的从一个对象，导航到另一个对象
	 * 注意关联的方向
	 */
	
	@Test
	public void findStudentByGrade() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Grade grade = session.get(Grade.class, 1);
		
		System.out.println(grade);
		
//		由班级查询班级包含的学生
		Set<Student> students = grade.getStudents();
		
		for(Student stu: students) {
			System.out.println(stu.toString());
		}
		
		transaction.commit();
		
//		关闭
		HibernateUtil.closeSession(session);
	}
	
	/**
	 * 修改学生信息
	 */
	
	@Test
	public void update() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		
		Grade g = new Grade();
		g.setGname("终极二班");
		g.setGdesc("很吊的终极二班");
		
		Student stu = session.get(Student.class,1);
//		添加到二班
		g.getStudents().add(stu);
		
		session.save(g);
		transaction.commit();
		

		
//		关闭
		HibernateUtil.closeSession(session);
	}
	
//	删除学生信息
	@Test
	public void deletetest() {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Student stu = session.get(Student.class,2);
		
		session.delete(stu);
		transaction.commit();
//		关闭
		HibernateUtil.closeSession(session);
	}
}
