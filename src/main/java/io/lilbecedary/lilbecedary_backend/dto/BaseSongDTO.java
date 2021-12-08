package io.lilbecedary.lilbecedary_backend.dto;

import java.util.Date;

import io.lilbecedary.lilbecedary_backend.util.DateFormatter;

public class BaseSongDTO {
	
	private String songPid;
	private String songTitle;
	private String duration;
	
	public String getSongPid() {
		return songPid;
	}

	public void setSongPid(String songPid) {
		this.songPid = songPid;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = DateFormatter.formatTime(duration);
	}

}
