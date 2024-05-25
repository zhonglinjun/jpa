//package com.yr.dan.one2one;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//@Table(name="JPA_DEPARTMENTS")
//@Entity
//public class Department {
//
//	private Integer id;
//	private String deptName;
//	
//	private Manager mgr;
//
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Id
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	@Column(name="DEPT_NAME")
//	public String getDeptName() {
//		return deptName;
//	}
//
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
//
//	
//	@JoinColumn(name="MGR_ID", unique=true)
//	@OneToOne(fetch = FetchType.EAGER)
//	public Manager getMgr() {
//		return mgr;
//	}
//
//	public void setMgr(Manager mgr) {
//		this.mgr = mgr;
//	}
//}
