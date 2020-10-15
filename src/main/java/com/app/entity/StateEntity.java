package com.app.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="state_master")
public class StateEntity {
	@Id
	@GeneratedValue
	@Column(name="state_id")
	private Integer stateId;
	@Column(name="country_id")
	private String countryId;
	@Column(name="state_name")
	private String stateName;
//    @OneToMany
//    @JoinColumn(name="state_idfk")
//	private Set<CityEntity> city;
	
}
