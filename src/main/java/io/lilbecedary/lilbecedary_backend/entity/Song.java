package io.lilbecedary.lilbecedary_backend.entity;

import java.io.Serializable;
import java.util.Date;

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

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="songs", schema="lilbecedary_db")
public class Song implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6075756567024720833L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="song_id")
	private int songId;
	
	@NaturalId
	@Column(name="song_pid")
	private String songPid;
	
	@Column(name="song_title")
	private String songTitle;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="duration")
	private Date duration;
	
	@Column(name="description")
	private String description;
	
	@Column(name="song_url")
	private String songUrl;
	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			}, fetch=FetchType.LAZY)
	@JoinColumn(name="album")
	private Album album;
	
	public Song() {}

	public Song(int songId, String songPid, String songTitle, Date releaseDate, Date duration, String description,
			String songUrl) {
		super();
		this.songId = songId;
		this.songPid = songPid;
		this.songTitle = songTitle;
		this.releaseDate = releaseDate;
		this.duration = duration;
		this.description = description;
		this.songUrl = songUrl;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
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

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
