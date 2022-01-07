package io.lilbecedary.lilbecedary_backend.dto;

public class RegionDTO {

	private String regionPid;
	private String regionName;
	private CountryDTO country;

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
	
	public CountryDTO getCountry() {
		return country;
	}
	public void setCountry(CountryDTO country) {
		this.country = country;
	}
	
}
