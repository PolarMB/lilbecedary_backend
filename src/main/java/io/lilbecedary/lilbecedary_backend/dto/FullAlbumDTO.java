package io.lilbecedary.lilbecedary_backend.dto;

import java.util.Date;
import java.util.List;

import io.lilbecedary.lilbecedary_backend.util.DateFormatter;

public class FullAlbumDTO extends BaseAlbumDTO {

	private String releaseDate;
	private Integer trackCount;
	private String description;
	private List<BaseSongDTO> songs;
	
	public FullAlbumDTO() {
		super();
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = DateFormatter.formatDate(releaseDate);
	}

	public Integer getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BaseSongDTO> getSongs() {
		return songs;
	}

	public void setSongs(List<BaseSongDTO> songs) {
		this.songs = songs;
	}
	
}
