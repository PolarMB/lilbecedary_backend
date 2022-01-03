package io.lilbecedary.lilbecedary_backend.dto;

import java.util.List;

public class FeaturedArtistDTO {

	private String artistPid;
	private String alias;
	private String birthday;
	private BaseCityDTO city;
	private String imageUrl;
	private List<BaseGenreDTO> genreList;
	
	public String getArtistPid() {
		return artistPid;
	}
	public void setArtistPid(String artistPid) {
		this.artistPid = artistPid;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public BaseCityDTO getCity() {
		return city;
	}
	public void setCity(BaseCityDTO city) {
		this.city = city;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<BaseGenreDTO> getGenreList() {
		return genreList;
	}
	public void setGenreList(List<BaseGenreDTO> genreList) {
		this.genreList = genreList;
	}
	
}
