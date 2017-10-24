package ru.mobui.inspection.cloud.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSP_MEAS_POINT")

public class MeasurementPoint {
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String id;
	
	@Column( name = "TECHNICAL_OBJECT_ID")
	private String technicalObjectId;
	
	@Column( name = "NAME")
	private String NAME;
	
	@Column( name = "UNIT_ID")
	private String unitId;
	
	@Column(name = "COMMENT")
	private String comment;
	
}
