package ru.mobui.inspection.cloud.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSP_MEAS_DOCUMENT")
public class MeasurementDocument {
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String id;
	
	@Column(name = "MEAS_POINT_ID")
	private String measurementPointId;
	
	@Column(name = "VALUE")
	private BigDecimal value;
	
	@Column(name = "UNIT_ID")
	private String unitId;
	
	@Column(name = "IS_DAMAGE")
	private Boolean isDamage;
	
	@Column(name = "COMMENT")
	private String comment;
}
