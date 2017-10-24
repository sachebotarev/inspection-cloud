package ru.mobui.inspection.cloud.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Defect
 *
 */
@Entity
@Table(name = "INSP_DEFECT")
public class Defect implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "GROUD_ID")
	private String groudId;


	public Defect() {
		super();
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getGroudId() {
		return this.groudId;
	}

	public void setGroudId(String groudId) {
		this.groudId = groudId;
	}
   
}
