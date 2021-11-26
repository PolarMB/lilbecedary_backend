package io.lilbecedary.lilbecedary_backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cities", schema="lilbecedary_db")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="city_id")
	private int id;
	
	@Column(name="city_pid")
	private String cityPid;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="population")
	private double population;
	
	@Column(name="latitude")
	private double latitude;

	@Column(name="longitude")
	private double longitude;
	
	//cascade=CascadeType.ALL
	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			}, fetch=FetchType.LAZY)
	@JoinColumn(name="region_id")
	private Region region;
	
	public City() {}

	public City(int id, String cityPid, String cityName, double population, double latitude, double longitude) {
		this.id = id;
		this.cityPid = cityPid;
		this.cityName = cityName;
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityPid() {
		return cityPid;
	}

	public void setCityPid(String cityPid) {
		this.cityPid = cityPid;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
