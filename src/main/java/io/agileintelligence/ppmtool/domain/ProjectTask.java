package io.agileintelligence.ppmtool.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

@Entity
public class ProjectTask {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
     private Long id;
	@Column(updatable=false)
	private String projectSequence;
	
	//ManyToOne with Backlog
	@Column(updatable=false)
	private String projectIdentifier;
	
	@NotBlank(message="Please include a project summary")
	private String summary;
	private String acceptanceCriteria;
	private String status;
	private Integer priority;
	private Date dueDate;
	private Date createdAt;
	private Date updatedAt;

public ProjectTask() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
	this.updatedAt= new Date();	
		
	}
	public String getProjectSequence() {
		return projectSequence;
	}
	public void setProjectSequence(String projectSequence) {
		this.projectSequence = projectSequence;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getAcceptanceCriteria() {
		return acceptanceCriteria;
	}
	public void setAcceptanceCriteria(String acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getProjectIdentifier() {
		return projectIdentifier;
	}
	public void setProjectIdentifier(String projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}

	
	
	


	@Override
	public String toString() {
		return "ProjectTask [id=" + id + ", projectSequence=" + projectSequence + ", summary=" + summary
				+ ", acceptanceCriteria=" + acceptanceCriteria + ", status=" + status + ", priority=" + priority
				+ ", dueDate=" + dueDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", projectIdentifier=" + projectIdentifier + "]";
	}
}