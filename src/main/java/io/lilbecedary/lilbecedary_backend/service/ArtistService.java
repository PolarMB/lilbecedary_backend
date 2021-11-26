package io.lilbecedary.lilbecedary_backend.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.lilbecedary.lilbecedary_backend.dao.ArtistDAO;
import io.lilbecedary.lilbecedary_backend.dto.ArtistDTO;
import io.lilbecedary.lilbecedary_backend.util.Converter;

@Service
@Transactional
public class ArtistService {
	
	private ArtistDAO artistDAO; 

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
	
}
