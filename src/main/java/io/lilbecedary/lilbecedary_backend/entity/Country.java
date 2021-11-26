package io.lilbecedary.lilbecedary_backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="countries", schema="lilbecedary_db")
public class Country {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="country_id")
	private int id;
	
	@Column(name="country_pid")
	private String countryPid;
	
	@Column(name="country_name")
	private String countryName;

	public Country() {}

	public Country(int id, String countryPid, String countryName) {
		this.id = id;
		this.countryPid = countryPid;
		this.countryName = countryName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryPid() {
		return countryPid;
	}

	public void setCountryPid(String countryPid) {
		this.countryPid = countryPid;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
