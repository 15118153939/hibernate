# hibernate
hibernate_demo
简单的hibernate demo:
实现步骤：
1：创建：hibernate.cfg.xml文件
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
		"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
		"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
    	<property name="connection.username">root</property>
    	<property name="connection.password">Mingliang520</property>
    	<property name="connection.driver_class">com.mysql.jdbc.Driver</property>
    	<property name="connection.autocommit">true</property>
    	<property name="connection.url">jdbc:mysql:///hibernate?useUnicode=true&amp;characterEncoding=UTF-8</property>
    	<!--  <property name="connection.url">jdbc:mysql:///hibernate?useUnicode=true&amp;characterEncoding=UTF-8</property>-->
    	
    	<!-- 方言 -->
    	<!-- <property name="dialect">org.hibernate.dialect.MySQLDialect</property>  -->
    	<!--  Mysql数据库版本是5.5的，设置事务性方言时要修改，就是加一个5-->
    	<property name="dialect">org.hibernate.dialect.MySQL5InnoDBDialect</property> 
    	<property name="show_sql">true</property>
    	<property name="format_sql">true</property>
    	<property name="hbm2ddl.auto">update</property>
    	<mapping resource="hbm/Students.hbm.xml"/>
    </session-factory>
</hibernate-configuration>
```
步骤2：持久化类：比如Students
```
package com.lv.entity;

import java.util.Date;

/**
 * 学生类
 * @author lvmin
 * 
 * java bean 满足：
 * 1：公有的类
 * 2.提供有不带参数的默认构造防范
 * 3：属性私有
 * 4：熟悉set,get/封装
 *
 */
public class Students {
	private int sid;//学号
	private String sname;//姓名
	private String gender;//性别
	private Date birthday;//出生日期
	private String address;//地址
	
	public Students() {
	}
	
	
	public Students(int sid, String sname, String gender, Date birthday, String address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
}

```

步骤三：创建对象-关系映射文件
```
<?xml version="1.0"?>
<!DOCTYPE hibernate-mapping PUBLIC "-//Hibernate/Hibernate Mapping DTD 3.0//EN"
"http://hibernate.sourceforge.net/hibernate-mapping-3.0.dtd">
<!-- Generated 2018-1-13 15:03:48 by Hibernate Tools 3.5.0.Final -->
<hibernate-mapping>
    <class name="com.lv.entity.Students" table="STUDENTS">
        <id name="sid" type="int">
            <column name="SID" />
            <generator class="assigned" />
        </id>
        <property name="sname" type="java.lang.String">
            <column name="SNAME" />
        </property>
        <property name="gender" type="java.lang.String">
            <column name="GENDER" />
        </property>
        <property name="birthday" type="java.util.Date">
            <column name="BIRTHDAY" />
        </property>
        <property name="address" type="java.lang.String">
            <column name="ADDRESS" />
        </property>
    </class>
</hibernate-mapping>
```
步骤四：4：通过Hibernate API编写 访问数据库的代码
```
package hibernate;


import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lv.entity.Students;

/**
 * 
 * @author lvmin
 *
 */

public class StudentsTest {
	
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		/**
//		 * Hibernate5.x 以下
//		创建配置对象
		Configuration config = new Configuration().configure();
		//创建服务注册对象
		ServiceRegistry  serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(config.getProperties()).build();
//		创建会话工厂对象
		sessionFactory = config.buildSessionFactory(serviceRegistry);
//		会话对象
		session = sessionFactory.openSession();
//		开启事物
		transaction = session.beginTransaction();
		*/
//		Hibernate5.x 以上
        //创建服务注册对象
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        //创建会话工厂对象
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事物
        transaction = session.beginTransaction();
	}
	
	/**
	 * 
	 */
	@After 
	public void destory() {
//		释放资源
		transaction.commit();//提交事务
//		关闭会话
		session.close();
//		关闭会话工厂
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents() {


		
		
//		创建学生对象
		Students s = new Students(2,"三丰","男",new Date(),"武当");
		
//		保存对象
		session.save(s);
		
		  
		
	}
}

```

