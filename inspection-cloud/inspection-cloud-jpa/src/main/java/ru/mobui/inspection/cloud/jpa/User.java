package ru.mobui.inspection.cloud.jpa;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "INSP_USER")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;   
	@Id
	@GeneratedValue(generator="INSP_ID_GEN")
	private String Id;
	private String FullName;
	private String sapId;
	private String adId;

	public User() {
		super();
	}   
	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}   
	public String getFullName() {
		return this.FullName;
	}

	public void setFullName(String FullName) {
		this.FullName = FullName;
	}   
	public String getSapId() {
		return this.sapId;
	}

	public void setSapId(String sapId) {
		this.sapId = sapId;
	}   
	public String getAdId() {
		return this.adId;
	}

	public void setAdId(String adId) {
		this.adId = adId;
	}
   
}
