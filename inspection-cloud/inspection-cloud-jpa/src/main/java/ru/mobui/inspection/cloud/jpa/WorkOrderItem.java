package ru.mobui.inspection.cloud.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSP_WORK_ORDER_ITEM")
public class WorkOrderItem {
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String id;
	
	@Column(name = "WO_ID")
	private String orderId;
	
	@Column(name = "WO_ITEM_NUMBER")
	private String itemNumber;
	
	@Column(name = "TECH_OBJECT_ID")
	private String technicalObjectId;
	
	@Column(name = "NOTIFICATION_ID")
	private String notificationId;
	
	@Column(name = "COMMENT")
	private String comment;
}
