package com.westpac.dao;
import java.util.List;

import com.westpac.entity.Applicant;
import com.westpac.entity.Application;
public interface IApplicationDAO {
    List<Application> getAllApplications();
    Application getApplicationById(int applicationId);
    void addApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(int applicationId);
    boolean applicationExists(String title,String category);
   }
 