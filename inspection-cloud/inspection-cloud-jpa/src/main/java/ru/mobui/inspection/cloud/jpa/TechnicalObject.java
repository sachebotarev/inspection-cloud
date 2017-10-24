package ru.mobui.inspection.cloud.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INSP_TECH_OBJECT")
public class TechnicalObject {
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String id;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "EXT_NUMBER")
	private String extNumber;
	
	@Embedded
	private GeoLocation geoLocation;
}
