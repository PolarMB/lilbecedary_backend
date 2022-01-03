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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name="artists", schema="lilbecedary_db")
public class Artist implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6791713044653425296L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="artist_id")
	private int artistId;
	
	@NaturalId
	@Column(name="artist_pid")
	private String artistPid;
	
	@Column(name="alias")
	private String alias;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="birthday")
	private Date birthday;
	
	@Column(name="gender")
	private char gender;
	
	
	// Must change relation type to ManyToOne and add OneToMany to City Entity Object.
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@OneToMany(mappedBy="artist",cascade= {
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	private List<Album> albumList;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	@JoinTable(
			name="artist_genres",
			schema="lilbecedary_db",
			joinColumns=@JoinColumn(name="artist_id"),
			inverseJoinColumns=@JoinColumn(name="genre_id")
			)
	private List<Genre> genreList;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade={
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH
			})
	@JoinTable(
			name="additional_artists",
			schema="lilbecedary_db",
			joinColumns=@JoinColumn(name="artist_id"),
			inverseJoinColumns=@JoinColumn(name="song_id")
			)
	private List<Song> featuredSongs;
	
	public Artist() {}

	public Artist(int artistId, String artistPid, String alias, String firstname, String lastname, Date birthday,
			char gender, String description, String imageUrl) {
		this.artistId = artistId;
		this.artistPid = artistPid;
		this.alias = alias;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthday = birthday;
		this.gender = gender;
		this.description = description;
		this.imageUrl = imageUrl;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public List<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

	public List<Genre> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<Genre> genreList) {
		this.genreList = genreList;
	}

	public List<Song> getFeaturedSongs() {
		return featuredSongs;
	}

	public void setFeaturedSongs(List<Song> featuredSongs) {
		this.featuredSongs = featuredSongs;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistPid=" + artistPid + ", alias=" + alias + ", firstname="
				+ firstname + ", lastname=" + lastname + ", birthday=" + birthday + ", gender=" + gender + ", city="
				+ city + ", description=" + description + ", imageUrl=" + imageUrl + ", albumList=" + albumList
				+ ", genreList=" + genreList + "]";
	}
	
}
