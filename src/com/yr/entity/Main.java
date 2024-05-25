//package com.yr.entity;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class Main {
//	public static void main(String[] args) throws InterruptedException {
//
//		
//		//对象工厂
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-1");	
//		
//		
//		
//		
//		
//		//操作数据的对象
//		EntityManager entityManager =  entityManagerFactory.createEntityManager();
//		
//		
//		//得到事务
//		EntityTransaction et =  entityManager.getTransaction();
//
//		et.begin();
//		
//		//操作数据库的代码
//		
//		
//		//数据库里面查询出来
//		
//		//新建、瞬时，临时
//		//游离   脱管
//		//持久化  托管-- 上下文，数据库。
//		//删除  
////		User user  = new User();
////		user.setName("aaa");
////		
////		entityManager.persist(user);
//		
//		//User u = entityManager.find(User.class, 10);
//		
//		//User u1 = entityManager.find(User.class, 1);
//		
//		//find get 区别  
//		//find找不到返回null,get直接返回异常
//		//find立即查询,get懒加载(你需要使用的时候才会进行加载)
//		//User u = entityManager.find(User.class, 10);
//		//System.out.println("-----------------------");
//		//System.out.println(u);
//		
//		
//		
//		//jpa只能保存临时对象
//		/*User user  = new User();
//		user.setName("aaa");
//		entityManager.persist(user);*/
//		
//		//User u = entityManager.find(User.class, 11);
//		//只能删除持久化对象
//		//entityManager.remove(u);
//		
//		
//		/*entityManager.find(User.class, 19);
//		
//		User u1 = new User();
//		u1.setName("aa22");
//		u1.setAddr("bb22");
//		u1.setId(19);*/
//		//临时对象
//		
//		
//		//默认就是自动
//		//entityManager.setFlushMode(FlushModeType.COMMIT);
//		
//		
//		
//		/*
//		 * u2  (name,addr)
//		 */
//		//User u2 = entityManager.merge(u1);
//		//User u = entityManager.find(User.class, 19);
//	//	u.setName("333333");
//		//entityManager.flush();
//		//System.out.println("------------------");
//		
//		
//		
//		//
//		//flush
//		//select * from  
//		/*flush会发送SQL
//		特殊insert也会发送
//		commit也会发送
//		jpql查询也会发送  */
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		//事务的隔离级别，读已提交(在同一个事务当中 ，多次查询，会一直得到是同一个数据)
//		
//		et.commit();// flush文件，会把SQL发送到数据库,执行SQL
//		
//		entityManager.close();
//		
//		entityManagerFactory.close();
//		
//	
//	
//		
//		
//		
//	}
//}
