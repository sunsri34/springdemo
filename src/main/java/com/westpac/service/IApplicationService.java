package com.westpac.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.westpac.entity.Applicant;
import com.westpac.entity.Application;

public interface IApplicationService {
	@Transactional
     List<Application> getAllApplications();
     Application getApplicationById(int applicationId);
     @Transactional
     boolean addApplication(Application application);
     void updateApplication(Application application);
     void deleteApplication(int applicationId);
    // List<Applicant> getApplicantsPERApplication(int applicationId);
     
}
