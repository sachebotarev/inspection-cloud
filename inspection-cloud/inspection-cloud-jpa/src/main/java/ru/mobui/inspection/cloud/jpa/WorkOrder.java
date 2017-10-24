package ru.mobui.inspection.cloud.jpa;

import java.util.Date;

import javax.persistence.*;

import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Table(name = "INSP_WORK_ORDER")
@UuidGenerator(name="INSP_ID_GEN")
@NamedQueries({
	@NamedQuery(name = "WorkOrder.getByWONumber", query = "SELECT woh FROM WorkOrder woh WHERE woh.workOrderNumber = :workOrderNumber"),
	@NamedQuery(name = "WorkOrder.getByPerformBy", query = "SELECT woh FROM WorkOrder woh WHERE woh.performBy = :performBy"),
	@NamedQuery(name = "WorkOrder.getByDescription", query = "SELECT woh FROM WorkOrder woh WHERE woh.description like :description"),
	@NamedQuery(name = "WorkOrder.getByStatus", query = "SELECT woh FROM WorkOrder woh WHERE woh.status = :status")
})
public class WorkOrder {
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	@Column(name = "ID", length = 36)
	private String id;
	
	@Column(name = "WO_NUMBER", unique = true)
	private String workOrderNumber;
	
	@Column(name = "DESCRIPTON", length = 1024)
	private String description;
	
	@Column(name = "MAIN_TECH_OBJECT", length = 36)
	private String mainTechObject;
	
	@Column(name = "ISSUE_BY", length = 36)
	private String issueBy;
	
	@Column(name = "ISSUE_AT", nullable = true)
	private Date issueAt;
	
	@Column(name = "PERFORM_BY", length = 36)
	private String performBy;
	
	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name = "START_ACT_AT",nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startActualAt;
	
	@Column(name = "FINISH_ACT_AT", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishActualAt;
	
	@Column(name = "START_SCH_AT", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startScheduledAt;
	
	@Column(name = "FINISH_SCH_AT", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishScheduledAt;
	
	@Column(name = "CREATED_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "CREATED_BY", length = 36, nullable = false)
	private String createdBy;
	
	@Column(name = "CHANGED_AT", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date changedAt;
	
	@Column(name = "CHANGED_BY", length = 36)
	private String changedBy;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWorkOrderNumber() {
		return workOrderNumber;
	}

	public void setWorkOrderNumber(String workOrderNumber) {
		this.workOrderNumber = workOrderNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainTechObject() {
		return mainTechObject;
	}

	public void setMainTechObject(String mainTechObject) {
		this.mainTechObject = mainTechObject;
	}

	public String getIssueBy() {
		return issueBy;
	}

	public void setIssueBy(String issueBy) {
		this.issueBy = issueBy;
	}

	public Date getIssueAt() {
		return issueAt;
	}

	public void setIssueAt(Date issueAt) {
		this.issueAt = issueAt;
	}

	public String getPerformBy() {
		return performBy;
	}

	public void setPerformBy(String performBy) {
		this.performBy = performBy;
	}

	public Date getStartActualAt() {
		return startActualAt;
	}

	public void setStartActualAt(Date startActualAt) {
		this.startActualAt = startActualAt;
	}

	public Date getFinishActualAt() {
		return finishActualAt;
	}

	public void setFinishActualAt(Date finishActualAt) {
		this.finishActualAt = finishActualAt;
	}

	public Date getStartScheduledAt() {
		return startScheduledAt;
	}

	public void setStartScheduledAt(Date startScheduledAt) {
		this.startScheduledAt = startScheduledAt;
	}

	public Date getFinishScheduledAt() {
		return finishScheduledAt;
	}

	public void setFinishScheduledAt(Date finishScheduledAt) {
		this.finishScheduledAt = finishScheduledAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getChangedAt() {
		return changedAt;
	}

	public void setChangedAt(Date changedAt) {
		this.changedAt = changedAt;
	}

	public String getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
