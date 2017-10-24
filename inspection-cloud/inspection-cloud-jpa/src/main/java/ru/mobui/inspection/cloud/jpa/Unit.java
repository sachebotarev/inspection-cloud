package ru.mobui.inspection.cloud.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="INSP_UNIT")
public class Unit {
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String id;
	
	@Column(name = "NAME_ISO", length = 6)
	private String nameISO;
	
	@Column(name = "NAME_TECH", length = 3)
	private String nameTech;
	
	@Column(name = "NAME_COMMERCE", length = 6)
	private String nameCommerce;
	
	@Column(name = "NAME_DESCRIPTION")
	private String description;
	
	@Column(name = "IS_CI")
	private Boolean isCI;
	
	@Column(name = "CI_INIT_ID")
	private String siUnitId;
	
	@Column(name = "CI_RECALULATE")
	private BigDecimal siRecalulate;
}
