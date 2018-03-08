package dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.log4j.Logger;

public class BaseDAO<T> implements Serializable {
	private static final long serialVersionUID = 3822281476313085422L;

	static EntityManagerFactory emf;
	
	static ThreadLocal<EntityManager> managerThreadLocal;
	
	static ThreadLocal<EntityTransaction> transactionThreadLocal;
	
	private static final Logger logger = Logger.getLogger(BaseDAO.class);
	
	private static final String DB_NAME = "ipe";
	
	public BaseDAO(){
		if (emf == null)
			emf = getEntityManagerFactory();
		
		if (managerThreadLocal == null)
			managerThreadLocal = new ThreadLocal<EntityManager>();
	
		if (transactionThreadLocal == null)
			transactionThreadLocal = new ThreadLocal<EntityTransaction>();
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		if (emf != null)
			return emf;
		else {
			emf = Persistence.createEntityManagerFactory(DB_NAME);
			return emf;
		}
	}
	
	public EntityManager getEntityManager(){
		if (managerThreadLocal.get() == null){
			EntityManager em = emf.createEntityManager();
			managerThreadLocal.set(em);
		}
		return managerThreadLocal.get();
	}

	public EntityTransaction getEntityTransaction(){
		if (transactionThreadLocal.get() == null){
			EntityTransaction transaction = getEntityManager().getTransaction();
			transactionThreadLocal.set(transaction);
		}
		return transactionThreadLocal.get();
	}
	
	public void startOperation(){
		if (!getEntityTransaction().isActive()){
			try{
				getEntityTransaction().begin();
				getEntityManager().clear();
			} catch (PersistenceException p) {
			    logger.info("[INFO] CAI NO CATCH DO METODO STARTOPERATION");
				p.printStackTrace();
				
				emf = getEntityManagerFactory();
				EntityManager em = emf.createEntityManager();
				managerThreadLocal.set(em);
				
				EntityTransaction et = managerThreadLocal.get().getTransaction();
				transactionThreadLocal.set(et);
				
				getEntityTransaction().begin();
				getEntityManager().clear();	
			}
		}
	}
	
	public void stopOperation(boolean commitChanges){
		if(getEntityTransaction().isActive()){
			if (commitChanges){
				getEntityManager().flush();
				getEntityTransaction().commit();
			} else
				getEntityTransaction().rollback();
	
			getEntityManager().close();
			transactionThreadLocal.remove();
			managerThreadLocal.remove();
		} else {
			logger.info("CAI NA CONDICAO ELSE DO METODO STOPOPERATION");
			startOperation();
			if (commitChanges){
				getEntityManager().flush();
				getEntityTransaction().commit();
			} else 
				getEntityTransaction().rollback();
		
			getEntityManager().close();
			transactionThreadLocal.remove();
			managerThreadLocal.remove();
		}
	}
		
	public T save(T object){
		try{
			getEntityManager().persist(object);
			return object;
		} catch (Exception e) {
			return null;
		}
	}

	public T merge(T object){
		object = getEntityManager().merge(object);
		return object;
	}
	
	public void remove(T object){
		getEntityManager().remove(getEntityManager().merge(object));
	}

	public T findById(Class<T> classType, int id){
		return getEntityManager().find(classType, id);
	}
	
	public List<T> findAll(Class<T> classType){
		Query query = getEntityManager().createQuery("SELECT object(o) FROM " + classType.getName() + " AS o");
		return query.getResultList(); 
	}
}