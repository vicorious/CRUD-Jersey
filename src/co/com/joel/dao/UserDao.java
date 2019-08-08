package co.com.joel.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.com.joel.entity.Customer;

public class UserDao 
{
	/* Create EntityManagerFactory */
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("userDao");
	/* Create EntityManager */
	private EntityManager em = emf.createEntityManager();
			
	public UserDao() {super();}

	/**
	 * 
	 * @param _identification
	 * @return
	 */
	public Customer getCustomer(String _identification)
	{
		Query query = this.em.createQuery("SELECT a FROM CUSTOMER a WHERE a.identification =:identification");
		query.setParameter("identification", _identification);
		Customer customer = (Customer) query.getSingleResult();
		
		return customer;
	}
	
	/**
	 * 
	 * @param _customer
	 * @return
	 */
	public Customer insertCustomer(Customer _customer)
	{
		this.em.getTransaction().begin();
		this.em.persist(_customer);
		this.em.getTransaction().commit();
		
		return _customer;
	}
	
	/**
	 * 
	 * @param _customer
	 * @return
	 */
	public Customer updateCustomer(Customer _customer)
	{
		this.em.getTransaction().begin();
		this.em.merge(_customer);
		this.em.getTransaction().commit();
		
		return _customer;
	}
	
	public EntityManager getEm() {return em;}			

}
