package io.lilbecedary.lilbecedary_backend.entity;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="genres", schema="lilbecedary_db")
public class Genre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5716235951568412932L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="genre_id")
	private int genreId;
	
	@NaturalId
	@Column(name="genre_pid")
	private String genrePid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="artist_count")
	private int artistCount;
	
	@Column(name="album_count")
	private int albumCount;
	
	@Column(name="song_count")
	private int song_count;
	
	@Column(name="description")
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	@JoinTable(
			name="artist_genres",
			schema="lilbecedary_db",
			joinColumns=@JoinColumn(name="genre_id"),
			inverseJoinColumns=@JoinColumn(name="artist_id")
			)
	private List<Artist> artistList;

	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	@JoinTable(
			name="album_genres",
			schema="lilbecedary_db",
			joinColumns=@JoinColumn(name="genre_id"),
			inverseJoinColumns=@JoinColumn(name="album_id")
			)
	private List<Album> albumList;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	@JoinTable(
			name="album_genres",
			schema="lilbecedary_db",
			joinColumns=@JoinColumn(name="genre_id"),
			inverseJoinColumns=@JoinColumn(name="song_id")
			)
	private List<Song> songList;
	
	public Genre() {}

	public Genre(int genreId, String genrePid, String name, int artistCount, int albumCount, int song_count,
			String description) {
		super();
		this.genreId = genreId;
		this.genrePid = genrePid;
		this.name = name;
		this.artistCount = artistCount;
		this.albumCount = albumCount;
		this.song_count = song_count;
		this.description = description;
	}

	public int getGenreId() {
		return genreId;
	}

	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}

	public String getGenrePid() {
		return genrePid;
	}

	public void setGenrePid(String genrePid) {
		this.genrePid = genrePid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArtistCount() {
		return artistCount;
	}

	public void setArtistCount(int artistCount) {
		this.artistCount = artistCount;
	}

	public int getAlbumCount() {
		return albumCount;
	}

	public void setAlbumCount(int albumCount) {
		this.albumCount = albumCount;
	}

	public int getSong_count() {
		return song_count;
	}

	public void setSong_count(int song_count) {
		this.song_count = song_count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Artist> getArtistList() {
		return artistList;
	}

	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
	
	

	public List<Song> getSongList() {
		return songList;
	}

	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}

	@Override
	public String toString() {
		return "Genre [genrePid=" + genrePid + ", name=" + name + "]";
	}
	
}
