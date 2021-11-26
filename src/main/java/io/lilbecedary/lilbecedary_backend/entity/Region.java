package io.lilbecedary.lilbecedary_backend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="regions", schema="lilbecedary_db")
public class Region {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="region_id")
	private int id;
	
	@Column(name="region_pid")
	private String regionPid;
	
	@Column(name="region_name")
	private String regionName;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="country_id")
	private Country country;
	
	@OneToMany(mappedBy="region", cascade= {
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	private List<City> cityList;
	
	public Region() {}

	public Region(int id, String regionPid, String regionName) {
		this.id = id;
		this.regionPid = regionPid;
		this.regionName = regionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegionPid() {
		return regionPid;
	}

	public void setRegionPid(String regionPid) {
		this.regionPid = regionPid;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

}
