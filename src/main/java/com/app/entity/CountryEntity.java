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




@Table(name="country_master")
@Data

@Entity
public class CountryEntity {
	@Id
	@GeneratedValue

	@Column(name="country_id")
	private Integer countryId;

	@Column(name="country_code")
	private String countryCode;

	@Column(name="country_name")
	private String countryName;
    @OneToMany
    @JoinColumn(name = "country_idfk")
	private Set<StateEntity> state;
}
