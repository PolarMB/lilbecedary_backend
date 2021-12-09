package io.lilbecedary.lilbecedary_backend.util;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import io.lilbecedary.lilbecedary_backend.dto.ArtistDTO;
import io.lilbecedary.lilbecedary_backend.dto.FullAlbumDTO;
import io.lilbecedary.lilbecedary_backend.dto.FullSongDTO;
import io.lilbecedary.lilbecedary_backend.entity.Album;
import io.lilbecedary.lilbecedary_backend.entity.Artist;
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
			ModelMapper modelMapper = new ModelMapper();
			modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			return modelMapper.map(album, FullAlbumDTO.class);
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
	
	
	// Artist list to ArtistDTO list
	public static List<ArtistDTO> artistListToDto(List<Artist> artistList) {
		return artistList.stream()
				.map(artist -> artistToDto(artist)).collect(Collectors.toList());
	}
	
	public static List<FullAlbumDTO> albumListToDto(List<Album> albumList) {
		return albumList.stream()
				.map(album -> albumToDto(album)).collect(Collectors.toList());
	}
	
	PropertyMap<Album, FullAlbumDTO> clientPropertyMap = new PropertyMap<Album, FullAlbumDTO>() {
	    @Override
	    protected void configure() {
	    	if (source.getDescription().equals(null)) {
	    		skip(destination.getDescription());
	    	}
	    	if (source.getTrackCount().equals(null)) {
	    		skip(destination.getTrackCount());
	    	}
	    }
	};
	
}
