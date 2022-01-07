package io.lilbecedary.lilbecedary_backend.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lilbecedary.lilbecedary_backend.dao.ArtistDAO;
import io.lilbecedary.lilbecedary_backend.dto.ArtistDTO;
import io.lilbecedary.lilbecedary_backend.entity.Artist;
import io.lilbecedary.lilbecedary_backend.util.Converter;

@Service
@Transactional
public class ArtistService {
	
	private final ArtistDAO artistDAO; 

	@Autowired
	public ArtistService(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}
	
	public List<ArtistDTO> getArtists(){
		return Converter.artistListToDto(artistDAO.getArtists());
	}
	
	public ArtistDTO getArtistById(String id) {
		return Converter.artistToDto(artistDAO.getArtistById(id));
	}
	
	public List<ArtistDTO> getArtistByAlias(String alias) {
		return Converter.artistListToDto(artistDAO.getArtistByAlias(alias));
	}
	
	public List<ArtistDTO> getArtistsByStatus(String status){
		return Converter.artistListToDto(artistDAO.getArtistsByStatus(status));
	}
	
	public List<ArtistDTO> getArtistFilteredByAge(
			Integer age, Integer minAge, Integer maxAge){
		
		List<Artist> tmpArtists = artistDAO.getArtists();
		
		if (age != null) {
			return Converter.artistListToDto(filterByCurrentAge(tmpArtists, age));
		}
		
		if (minAge != null && maxAge == null) {
			return Converter.artistListToDto(filterByMinAge(tmpArtists, minAge));
		} else if (maxAge != null && minAge == null) {
			return Converter.artistListToDto(filterByMaxAge(tmpArtists, maxAge));
		} else if (minAge != null && maxAge != null) {
			return Converter.artistListToDto(filterByAgeRange(tmpArtists, minAge, maxAge));
		} else {
			throw new RuntimeException("No artist found with set parameters");
		}
	}
	
	private List<Artist> filterByCurrentAge(List<Artist> artistList, Integer age){
		List<Artist> filteredArtists = new ArrayList<Artist>();
		
		for (Artist artist : artistList) {
			
			LocalDate artistBirthday = artist.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if (Period.between(artistBirthday, LocalDate.now()).getYears() == age &&
					artist.getStatus().equals("A")) {
				filteredArtists.add(artist);
			}
		}
		
		return filteredArtists;
	}
	
	private List<Artist> filterByMinAge(List<Artist> artistList, Integer minAge){
		List<Artist> filteredArtists = new ArrayList<Artist>();
		
		for (Artist artist : artistList) {
			
			LocalDate artistBirthday = artist.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if (Period.between(artistBirthday, LocalDate.now()).getYears() >= minAge &&
					artist.getStatus().equals("A")) {
				filteredArtists.add(artist);
			}
		}
		
		return filteredArtists;
	}
	
	private List<Artist> filterByMaxAge(List<Artist> artistList, Integer maxAge){
		List<Artist> filteredArtists = new ArrayList<Artist>();
		
		for (Artist artist : artistList) {
			
			LocalDate artistBirthday = artist.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if (Period.between(artistBirthday, LocalDate.now()).getYears() <= maxAge &&
					artist.getStatus().equals("A")) {
				filteredArtists.add(artist);
			}
		}
		
		return filteredArtists;
	}
	
	private List<Artist> filterByAgeRange(List<Artist> artistList, Integer minAge, Integer maxAge){
		List<Artist> filteredArtists = new ArrayList<Artist>();
		
		for (Artist artist : artistList) {
			
			LocalDate artistBirthday = artist.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			if (Period.between(artistBirthday, LocalDate.now()).getYears() >= minAge &&
				Period.between(artistBirthday, LocalDate.now()).getYears() <= maxAge &&
				artist.getStatus().equals("A")) {
				filteredArtists.add(artist);
			}
		}
		
		return filteredArtists;
	}
	
}
