//package com.yr.entity;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.TableGenerator;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
////orm -- 操作类就相当于操作表
//@Entity
//@Table(name = "testUser")
//public class User {
//	
//	
////	@TableGenerator(name="aaaa",
////			table="jpa_id",
////			pkColumnName="PK_NAME",
////			valueColumnName="PK_VALUE",
////			pkColumnValue="uid",
////			allocationSize = 1)
//		
//	
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)//用数据库底层的生成器
//	private int id;
//	private String name;
//	private String addr;
//	private int age;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date birth;
//	
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getAddr() {
//		return addr;
//	}
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	public Date getBirth() {
//		return birth;
//	}
//	public void setBirth(Date birth) {
//		this.birth = birth;
//	}
//	
//
//	@Override
//	public String toString() {
//		return "User [id=" + id + ", name=" + name + ", addr=" + addr + ", age=" + age + ", birth=" + birth + "]";
//	}
//	
//	
//}
