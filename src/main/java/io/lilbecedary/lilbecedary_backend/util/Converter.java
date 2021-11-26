package io.lilbecedary.lilbecedary_backend.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import io.lilbecedary.lilbecedary_backend.dto.ArtistDTO;
import io.lilbecedary.lilbecedary_backend.entity.Artist;


public class Converter {
	
	// City to BaseCityDTO
//	public static BaseCityDTO cityToBaseCityDTO(City city) {
//		if (city != null) {
//			return new ModelMapper().map(city, BaseCityDTO.class);
//		} else {
//			return null;
//		}
//	}

	// Artist to ArtistDTO
	public static ArtistDTO artistToDto(Artist artist) {
		if (artist != null) {
			return new ModelMapper().map(artist, ArtistDTO.class);
		} else {
			return null;
		}
	}
	
	// Artist list to ArtistDTO list
	public static List<ArtistDTO> artistListToDto(List<Artist> artistList) {
		return artistList.stream()
				.map(artist -> artistToDto(artist)).collect(Collectors.toList());
	}
	
}
