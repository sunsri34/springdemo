package com.westpac.service;

import java.util.List;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.westpac.dao.IApplicationDAO;
import com.westpac.entity.Applicant;
import com.westpac.entity.Application;
@Service
public class ApplicationService implements IApplicationService {
	@Autowired
	private IApplicationDAO applicationDAO;
	@Override
	@Transactional
	public Application getApplicationById(int applicationId) {
		Application obj = applicationDAO.getApplicationById(applicationId);
		return obj;
	}	
	@Override
	@Transactional
	public List<Application> getAllApplications(){
		return applicationDAO.getAllApplications();
	}
	@Override
	@Transactional
	public synchronized boolean addApplication(Application application){
       if (applicationDAO.applicationExists(application.getTitle(), application.getCategory())) {
    	   return false;
       } else {
    	   applicationDAO.addApplication(application);
    	   return true;
       }
	}
	@Override
	@Transactional
	public void updateApplication(Application application) {
		applicationDAO.updateApplication(application);
	}
	@Override
	@Transactional
	public void deleteApplication(int applicationId) {
		applicationDAO.deleteApplication(applicationId);
	}
	/*@Override
	public List<Applicant>  getApplicantsPERApplication(int applicationId){
		Application app = applicationDAO.getApplicationById(applicationId);
		return applicationDAO.getApplicantsPERApplication(app);
	}*/
}
