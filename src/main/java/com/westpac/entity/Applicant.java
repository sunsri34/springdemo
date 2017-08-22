package com.westpac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Applicant")
public class Applicant {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="applicant_id")
	private int applicant_id;  
	@Column(name="channel")
	private String channel;
	
	public int getApplicant_id() {
		return applicant_id;
	}
	public void setApplicant_id(int applicant_id) {
		this.applicant_id = applicant_id;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
} 
