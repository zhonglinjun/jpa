package com.yr.shuang;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 



@Table(name="JPA_CUTOMERS")
@Entity
public class Customer {

	private Integer id;
	private String lastName;

	private String email;
	private int age;
	
	private Set<Order1> orders = new HashSet<Order1>();
	
	
	
	public Customer(int id ,String lastName) {
		this.id = id;
		this.lastName = lastName;
	}
	
	
	public Customer() {
	}
	
	public Customer(String lastName, int age) {
		super();
		this.lastName = lastName;
		this.age = age;
	}
	
	public Customer(int id,String lastName,String email)
	{
		this.id = id;
		this.lastName = lastName;
		this.email = email;
	}



	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

	//1-n   n-1
	//(mappedBy = "customer")
	//@JoinColumn(name = "cust_id")
	@OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
	public Set<Order1> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order1> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + "]";
	}

	/**@Override
	public String toString() {
		return "Customer [id=" + id + ", lastName=" + lastName + ", email=" + email + ", age=" + age + ", orders="
				+ orders + "]";
	}*/
	
	

	

}
