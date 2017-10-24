package ru.mobui.inspection.cloud.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GeoLocation {
	@Column(name = "LONGITUDE")
	private BigDecimal longitude;
	
	@Column(name = "LATITUDE")
	private BigDecimal latitude;
}
