package com.api.postgress.main.files;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Transactional
@Repository("userDetailDAO")
public class UserDetailDAO {

private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailDAO.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public void saveUserLoginDetail(UserLoginDO userLogin) {
		LOGGER.info("...saveUserLoginDetail..");
		sessionFactory.getCurrentSession().saveOrUpdate(userLogin);
	}
//	CriteriaBuilder cb = this.em.getCriteriaBuilder();
//	// create update
//	CriteriaUpdate<Order> update = cb.createCriteriaUpdate(Order.class);
//	// set the root class
//	Root e = update.from(UserLoginDO.class);
//	// set update and where clause
//	update.set("user_id", user_id);
//	update.where(cb.greaterThanOrEqualTo(e.get("amount"), oldAmount));
//	// perform update
//	this.em.createQuery(update).executeUpdate();
	
	public boolean isEmailIdExist(String emailId) {
		LOGGER.info("...isEmailIdExist..");
		Criteria ct = sessionFactory.getCurrentSession().createCriteria(UserLoginDO.class);
		ct.add(Restrictions.eq("emailId", emailId));
		ct.addOrder(Order.desc("id"));
		ct.setMaxResults(1);
		UserLoginDO agentdetail = (UserLoginDO) ct.uniqueResult();
		if(agentdetail!=null) {
			return true;
		}
		return false;
	}
	
	public List<UserLoginDO> getUserLoginDetailByUserNamePassword(String userName,String password) {
		LOGGER.info("...getUserLoginDetailByEmailPassword.."+userName+"...."+password);
		Criteria ct = sessionFactory.getCurrentSession().createCriteria(UserLoginDO.class);
		ct.add(Restrictions.eq("userName", userName));
    	ct.add(Restrictions.eq("password", password));
		ct.addOrder(Order.desc("id"));
		ct.setMaxResults(1);
		@SuppressWarnings("unchecked")
		List<UserLoginDO> agentdetail =  ct.list();
		LOGGER.info("Data= "+ agentdetail);
		if(agentdetail!=null && !agentdetail.isEmpty()) {
			return agentdetail;
		}
		return null;

	

	}

	public UserLoginDO getUserLoginDetailByEmail(String emailId) {
		LOGGER.info("...getUserLoginDetailByEmailPassword..");
		Criteria ct = sessionFactory.getCurrentSession().createCriteria(UserLoginDO.class);
		ct.add(Restrictions.eq("emailId", emailId));
		ct.addOrder(Order.desc("id"));
		ct.setMaxResults(1);
		UserLoginDO agentdetail = (UserLoginDO) ct.uniqueResult();
		if(agentdetail!=null) {
			return agentdetail;
		}
		return null;
	}

	public UserLoginDO getUserLoginDetailByUserId(String userId) {
		LOGGER.info("...getUserLoginDetailByEmailPassword..");
		Criteria ct = sessionFactory.getCurrentSession().createCriteria(UserLoginDO.class);
		ct.add(Restrictions.eq("userId", userId));
		ct.addOrder(Order.desc("id"));
		ct.setMaxResults(1);
		UserLoginDO agentdetail = (UserLoginDO) ct.uniqueResult();
		if(agentdetail!=null) {
			return agentdetail;
		}
		return null;
	}

	public  void userDelete(String userId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<UserLoginDO> delete = cb.createCriteriaDelete(UserLoginDO.class);
		Root<UserLoginDO> root = delete.from(UserLoginDO.class);
		delete.where(cb.equal(root.get("userId"), userId));
		 entityManager.createQuery(delete).executeUpdate();

         
	}

	public void update(String userId,String newUserName) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<UserLoginDO> criteria = builder.createCriteriaUpdate(UserLoginDO.class);
		Root<UserLoginDO> root = criteria.from(UserLoginDO.class);
		criteria.set(root.get("userName"), newUserName);
		criteria.where(builder.equal(root.get("userId"), userId));
		entityManager.createQuery(criteria).executeUpdate();
	}
	
	






}	








	

	




