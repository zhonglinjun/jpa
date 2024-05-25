package com.yr.shuang;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.QueryHint;

import org.hibernate.jpa.QueryHints;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JPATest {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;
	
	@Before
	public void init(){
		entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
	}
	
	@After
	public void destroy(){
		System.out.println(1111);
		System.out.println(2222);
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	
	@Test
	public void a1a()
	{
		Order1 order1 = entityManager.find(Order1.class, 7);
		entityManager.remove(order1);
		
	}
	
	
	@Test
	public void update()
	{
		//String jpql = "update Customer set lastName = ? where id = ? ";
		String jpql = "delete from Customer where id = ?";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 8);
		
		query.executeUpdate();
		
	}
	
	//一级缓存是同一个entityManager,不可卸载,默认使用(内置)
	//二级缓存同同一个entityManagerFactory,默认不使用,需要手动配置(外置)
	@Test
	public void find()
	{
	
		//一级缓存   entityManager 同一个entityManager缓存
		//二级缓存  entityManagerFactory  同一个entityManagerFactory对象的缓存
		
//		entityManager.find(Order1.class, 1);
//		transaction.commit();
//		entityManager.close();
		
		
		//select * from order1
		
//		String sql = "select o.id,o.orderName from Order1 o where  id > ?";
//
//		List<Object[]> list = entityManager.createQuery(sql).setParameter(1, 3).getResultList();
//		
//		
//		for (Object[] objects : list) {
//			System.out.println(objects[0] + "    " + objects[1]);
//		}
		
		
//		String sql = "select new Customer(c.id,c.lastName) from Customer c where c.id > ?";
//		List<Customer> list = entityManager.createQuery(sql).setParameter(1, 1).getResultList();
//		for (Customer customer : list) {
//			System.out.println(customer.toString());
//		}
		
		
//		List<Order1> list = entityManager.createNamedQuery("bb").setParameter(1, 3).getResultList();
//		for (Order1 order1 : list) {
//			System.out.println(order1.toString());
//		}
		
		
		//jpql查询时,本身不会去缓存当中找数据,直接查数据库.但是会把查询结果放在缓存当中 
//		String sql = "select o.orderName,count(*)  from Order1 o group by o.orderName having count(*) >= 2";
//		List<Object[]> list = entityManager.createQuery(sql).getResultList();//查询了所有的订单
//		for (Object[] objects : list) {
//			System.out.println(objects[0] + "  " + objects[1]);
//		}
		
		//String sql = "select * from Customer c inner join Order1 o on c.id = o.cust_id";
//		String sql = "select distinct c from Customer c left join fetch c.orders ";//用到订单的时候还会再去查询
//		
//		List<Customer> list = entityManager.createQuery(sql).getResultList();
//		for (Customer customer : list) {
//			System.out.println(customer.toString());
//			
//			System.out.println(customer.getOrders());
//			System.out.println("----------------------------------");
//		}
		
		
		
		
//		String sql = "select o from Order1 o where o.id = :acb";
//		Order1 order1 = (Order1) entityManager.createQuery(sql).setParameter("abc",2).getSingleResult();
//		System.out.println(order1);
		
		
		String sql = "delete from jpa_orders where id = ?";
		entityManager.createNativeQuery(sql).setParameter(1, 5).executeUpdate();
		
		
//		
//		String sql1 = "select o from Order1 o where o.id > ?";
//		entityManager.createQuery(sql1).setParameter(1, 1).setHint(QueryHints.HINT_CACHEABLE, true).getResultList();//查询了所有的订单
			
			
		
			
			
		
		
		/*String jpql = "select concat(lastName,'abc') FROM Customer c where id = ? ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, 1);
		Object result = query.getSingleResult();
		System.out.println(result);*/
		
//		String jpql = "SELECT o FROM Order o "
//				+ "WHERE o.customer = (SELECT c FROM Customer c WHERE c.lastName = ?)";
//		
//		Query query = entityManager.createQuery(jpql).setParameter(1, "MM1");
//		List<Order> orders = query.getResultList();
//		System.out.println(orders.size());
		
		
		
		//为什么不需要通过字段关联.因为jap实体类本身就有关联n
		//fetch 抓取,
//		String jpql = "FROM Customer c LEFT OUTER JOIN fetch c.orders  WHERE c.id = ?";
//		
//		Customer customer = 
//				(Customer) entityManager.createQuery(jpql).setParameter(1, 3).getSingleResult();
//		System.out.println(customer.getLastName());
//		System.out.println(customer.getOrders());
		
		
//		String jpql = "select min(age) FROM Customer c ";
//		Query query = entityManager.createQuery(jpql);
//		Object result = query.getSingleResult();
//		System.out.println(result);
		
//		String jpql = "SELECT o.customer FROM Order o "
//				+ "GROUP BY o.customer "
//				+ "HAVING count(o.id) >= 2";
//		List<Customer> customers = entityManager.createQuery(jpql).getResultList();
		
		
//		String jpql = "select c FROM Customer c order by c.lastName asc";
//		Query query = entityManager.createQuery(jpql);
//		List<Customer> list = query.getResultList();
//		for (Customer customer : list) {
//			System.out.println(customer.getLastName());
//		}
//	
		
		
		
		//本地 原生SQL
//		String sql = "select *from jpa_cutomers";
//		Query query  = entityManager.createNativeQuery(sql);
//		List<Object[]> list = query.getResultList();
//		
//		for (Object[] objects : list) {
//			System.out.println(objects[0] + "   " + objects[1] + "   " +objects[2]);
//		}
		
		
		
		/*
		 * Query query = entityManager.createNamedQuery("abc"); query.setParameter(1,
		 * 1); Customer customer = (Customer) query.getSingleResult();
		 * System.out.println(customer);
		 */
		/*List<Customer> list = query.getResultList();
		for (Customer customer : list) {
			System.out.println(customer.getLastName());
		}*/
		
//		String jpql = "select new Customer(c.id,c.lastName,c.email) FROM Customer c where id > ?";
//		Query query = entityManager.createQuery(jpql);
//		query.setParameter(1, 5);
//		
//		
//		List<Customer> list = query.getResultList();
//		for (Customer customer : list) {
//			System.out.println(customer.toString());
//		}
		
//		List<Object[]> list = query.getResultList();
//		
//		for (Object[] objects : list) {
//			System.out.println(objects[0] + "   " + objects[1] + "   " +objects[2]);
//		}
		// list[0]  object[c.id,c.lastName,c.email]
		
		//list[1]  object[c.id,c.lastName,c.email]
		//list[2]  object[c.id,c.lastName,c.email]
		//list[3]  objectc.id,c.lastName,c.email[]
		/*List<Customer> list = query.getResultList();
		for (Customer customer : list) {
			System.out.println(customer.getLastName());
		}*/
		
	}

	
	//若是双向 1-n 的关联关系, 执行保存时
	//若先保存 n 的一端, 再保存 1 的一端, 默认情况下, 会多出 n 条 UPDATE 语句.
	//若先保存 1 的一端, 则会多出 n 条 UPDATE 语句
	//在进行双向 1-n 关联关系时, 建议使用 n 的一方来维护关联关系, 而 1 的一方不维护关联系, 这样会有效的减少 SQL 语句. 
	//注意: 若在 1 的一端的 @OneToMany 中使用 mappedBy 属性, 则 @OneToMany 端就不能再使用 @JoinColumn 属性了. 
	
	
	
	//单向 1-n 关联关系执行保存时, 一定会多出 UPDATE 语句.
	//因为 n 的一端在插入时不会同时插入外键列. 
	@Test
	public void insert()
	{
		
		Customer customer = new Customer();
		customer.setAge(18);
		customer.setEmail("mm@163.com");
		customer.setLastName("MM");
		
		
		Order1 order1 = new Order1();
		order1.setOrderName("O-MM-1");
		
		
		
		Order1 order2 = new Order1();
		order2.setOrderName("O-MM-2");
		
		//建立关联关系
		customer.getOrders().add(order1);
		customer.getOrders().add(order2);
		
		
		order1.setCustomer(customer);
		order2.setCustomer(customer);
//		
//		//执行保存操作
//		//谁维护,谁管理关联字段
//		//客户维护一次,
//		//订单维护一次
//		
//		
//		
	
		
		entityManager.persist(customer);//插入客户,维护关联
		
		
		entityManager.persist(order1);//等着维护
		entityManager.persist(order2);
		
		
		
		
		
		//先插入客户,

		
		
		//Customer customer = entityManager.find(Customer.class, 1);
		/*System.out.println(customer);
		System.out.println("-----------------------");
		System.out.println(customer.getOrders());
		Order order = entityManager.find(Order.class, 1);*/
		//entityManager.remove(customer);
		
//		Customer customer= entityManager.find(Customer.class, 1);
//		System.out.println(customer.toString());
//		transaction.commit();
//		entityManager.close();
//		
//		
//		
//		entityManager = entityManagerFactory.createEntityManager();
//		transaction = entityManager.getTransaction();
//		transaction.begin();
//		Customer customer1= entityManager.find(Customer.class, 1);
//		System.out.println(customer1.toString());
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		
		
		
		String sql = "update Order1 set orderName = :name where id = :id1";
		Query query = entityManager.createQuery(sql);
		query.setParameter("name", "333333333333333");
		query.setParameter("id1", 2);
		query.executeUpdate();
		
		
		//FROM Customer c LEFT OUTER JOIN FETCH c.orders WHERE c.id = ?
		//            from jpa_orders o inner join jpa_cutomers c on o.cust_id = c.id
		/*String sql = "select o FROM Order1 o inner join o.customer";
		Query query = entityManager.createQuery(sql);
		List<Order1> list = query.getResultList();
		for (Order1 order : list) {
			System.out.println(order.toString());
		}*/
		
//		String sql = "select c.id,length(c.lastName) from Customer c";
//		Query query = entityManager.createQuery(sql);
//		List<Object[]> list = query.getResultList();
//		for (Object[] objects : list) {
//			System.out.println(objects[0] + "   " + objects[1]);
//		}
		
		/*List<Customer> list = query.getResultList();
		for (Customer customer : list) {
			System.out.println(customer.toString());
		}*/
		
		/* sql ="select o.orderName,count(*) from Order1 o group by orderName having count(*) > 1";
		Query query = entityManager.createQuery(sql);
		List<Object[]> list = query.getResultList();
		for (Object[] objects : list) {
			System.out.println(objects[0] + "   " + objects[1]);
		}*/
		
			
		
//		String sql = "from Order1 where customer = ?";
//		
//		Customer customer = new Customer();
//		customer.setId(1);
//		
//		
//		
//		Query query = entityManager.createQuery(sql);
//		query.setParameter(1, customer);
//		List<Order1> list = query.getResultList();
//		for (Order1 order : list) {
//			System.out.println(order.toString());
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		transaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	@Test
	public void aa()
	{
		String sql = "from Order1 order by id asc";
//		String sql ="select new Order(o.id,o.orderName) from Ordera o where o.id > ?";
		Query query = entityManager.createQuery(sql);
//		query.setParameter(1, 1);
		/*<Object[]> list = query.getResultList();
		for (Object[] objects : list) {
			System.out.println(objects[0]);
		}*/
		List<Order1> list = query.getResultList();
		for (Order1 order : list) {
			System.out.println(order.toString());
		}
	}

}
