package io.lilbecedary.lilbecedary_backend.dto;

public class FullCityDTO extends BaseCityDTO {
	

	private double population;
	private double latitude;
	private double longitude;
	private RegionDTO region;
	
	public FullCityDTO() {
		super();
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

	public RegionDTO getRegion() {
		return region;
	}

	public void setRegion(RegionDTO region) {
		this.region = region;
	}

}
