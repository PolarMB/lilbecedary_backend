package io.lilbecedary.lilbecedary_backend.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ArtistDTO {
	
	private final String PATTERN = "yyyy-MM-dd";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.PATTERN);
	
	private String artistPid;
	private String alias;
	private String firstname;
	private String lastname;
	private String birthday;
	private char gender;
	private BaseCityDTO city;
	private String description;
	private String imageUrl;
	private List<AlbumDTO> albumList;

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = this.simpleDateFormat.format(birthday);
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public BaseCityDTO getCity() {
		return city;
	}

	public void setCity(BaseCityDTO city) {
		this.city = city;
	}

	public List<AlbumDTO> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<AlbumDTO> albumList) {
		this.albumList = albumList;
	}
	
}