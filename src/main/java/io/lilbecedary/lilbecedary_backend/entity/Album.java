package io.lilbecedary.lilbecedary_backend.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="albums", schema="lilbecedary_db")
public class Album implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7968018739467319224L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="album_id")
	private int albumId;
	
	@NaturalId
	@Column(name="album_pid")
	private String albumPid;
	
	@Column(name="album_title")
	private String albumTitle;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="track_count")
	private Integer trackCount;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			}, fetch=FetchType.LAZY)
	@JoinColumn(name="artist_id")
	private Artist artist;
	
	@OneToMany(mappedBy="album", 
			cascade= { CascadeType.ALL }, 
			fetch=FetchType.LAZY)
	private List<Song> songs; 
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	@JoinTable(
			name="album_genres",
			schema="lilbecedary_db",
			joinColumns=@JoinColumn(name="album_id"),
			inverseJoinColumns=@JoinColumn(name="genre_id")
			)
	private List<Genre> genres;
	
	public Album() {}

	public Album(int albumId, String albumPid, String albumTitle, Date releaseDate, int trackCount,
			String description) {
		this.albumId = albumId;
		this.albumPid = albumPid;
		this.albumTitle = albumTitle;
		this.releaseDate = releaseDate;
		this.trackCount = trackCount;
		this.description = description;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumPid() {
		return albumPid;
	}

	public void setAlbumPid(String albumPid) {
		this.albumPid = albumPid;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getTrackCount() {
		return trackCount;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public void setTrackCount(Integer trackCount) {
		this.trackCount = trackCount;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumPid=" + albumPid + ", albumTitle=" + albumTitle + ", releaseDate="
				+ releaseDate + ", trackCount=" + trackCount + ", description=" + description + ", artist=" + artist
				+ "]";
	}


}
