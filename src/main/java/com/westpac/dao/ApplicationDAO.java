package com.westpac.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.westpac.entity.Applicant;
import com.westpac.entity.Application;
@Repository 
public class ApplicationDAO implements IApplicationDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Application getApplicationById(int applicationId) {
		return entityManager.find(Application.class, applicationId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Application> getAllApplications() {
		return entityManager.createQuery("FROM Application").getResultList();
	}	
	@Override
	public void addApplication(Application application) {
		entityManager.persist(application);
	}
	@Override
	public void updateApplication(Application application) {
		Application app = getApplicationById(application.getApplicationId());
		app.setTitle(application.getTitle());
		app.setCategory(application.getCategory());
		entityManager.flush();
	}
	@Override
	public void deleteApplication(int applicationId) {
		entityManager.remove(getApplicationById(applicationId));
	}
	@Override
	public boolean applicationExists(String title, String category) {
		String hql = "FROM Application as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
	
}
