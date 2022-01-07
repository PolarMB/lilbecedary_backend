package io.lilbecedary.lilbecedary_backend.util;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import io.lilbecedary.lilbecedary_backend.dto.ArtistDTO;
import io.lilbecedary.lilbecedary_backend.dto.FullAlbumDTO;
import io.lilbecedary.lilbecedary_backend.dto.FullCityDTO;
import io.lilbecedary.lilbecedary_backend.dto.FullSongDTO;
import io.lilbecedary.lilbecedary_backend.entity.Album;
import io.lilbecedary.lilbecedary_backend.entity.Artist;
import io.lilbecedary.lilbecedary_backend.entity.City;
import io.lilbecedary.lilbecedary_backend.entity.Song;


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
	
	public static FullAlbumDTO albumToDto(Album album) {
		if (album != null) {
			return new ModelMapper().addMappings(fullAlbumDtoSkipFields).map(album);
		} else {
			return null;
		}
	}
	
	public static FullSongDTO songToDto(Song song) {
		if (song != null) {
			return new ModelMapper().map(song, FullSongDTO.class);
		} else {
			return null;
		}
	}
	
	public static FullCityDTO cityToDto(City city) {
		if (city != null) {
			return new ModelMapper().map(city, FullCityDTO.class);
		} else {
			return null;
		}
	}
	
	
	// Artist list to ArtistDTO list
	public static List<ArtistDTO> artistListToDto(List<Artist> artistList) {
		return artistList.stream()
				.map(artist -> artistToDto(artist)).collect(Collectors.toList());
	}
	
	public static List<FullAlbumDTO> albumListToDto(List<Album> albumList) {
		return albumList.stream()
				.map(album -> albumToDto(album)).collect(Collectors.toList());
	}
	
	public static List<FullCityDTO> cityListToDto(List<City> cityList) {
		return cityList.stream()
				.map(city -> cityToDto(city)).collect(Collectors.toList());
	}
	
	static PropertyMap<Album, FullAlbumDTO> fullAlbumDtoSkipFields = new PropertyMap<Album, FullAlbumDTO>() {
	    @Override
	    protected void configure() {
	    	if (source.getDescription() == null) {
	    		skip(destination.getDescription());
	    	}
	    	if (source.getTrackCount() == null) {
	    		skip(destination.getTrackCount());
	    	}
	    }
	};
	
}
