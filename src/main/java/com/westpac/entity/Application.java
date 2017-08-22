package com.westpac.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Application")
public class Application implements Serializable { 
	private static final long serialVersionUID = 1L;
	//private List<Applicant> applicants = new ArrayList<Applicant>(0);
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="application_id")
    private int applicationId;  
	@Column(name="title")
    private String title;
	@Column(name="category")	
	private String category;
	
	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Application_Applicant", joinColumns = { @JoinColumn(name = "APPLICATION_ID") }, inverseJoinColumns = { @JoinColumn(name = "APPLICANT_ID") })
	public List<Applicant> getAppplicants() {
		return this.applicants;
	}

	public void setApplicants(List<Applicant> applicants) {
		this.applicants = applicants;
	}*/
	
	
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
} 