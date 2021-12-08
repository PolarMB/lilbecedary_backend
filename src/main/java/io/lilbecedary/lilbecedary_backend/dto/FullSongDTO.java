package io.lilbecedary.lilbecedary_backend.dto;

import java.util.Date;

import io.lilbecedary.lilbecedary_backend.util.DateFormatter;

public class FullSongDTO extends BaseSongDTO {

	private BaseAlbumDTO album;
	private String releaseDate;
	private String description;
	private String songUrl;
	
	public FullSongDTO() {
		super();
	}

	public BaseAlbumDTO getAlbum() {
		return album;
	}

	public void setAlbum(BaseAlbumDTO album) {
		this.album = album;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = DateFormatter.formatDate(releaseDate);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}
	
}
