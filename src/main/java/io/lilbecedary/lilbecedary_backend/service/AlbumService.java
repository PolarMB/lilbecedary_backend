package io.lilbecedary.lilbecedary_backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lilbecedary.lilbecedary_backend.dao.AlbumDAO;
import io.lilbecedary.lilbecedary_backend.dto.FullAlbumDTO;
import io.lilbecedary.lilbecedary_backend.util.Converter;

@Service
@Transactional
public class AlbumService {

	private final AlbumDAO albumDao;
	
	@Autowired
	public AlbumService(AlbumDAO albumDao) {
		this.albumDao = albumDao;
	}
	
	public FullAlbumDTO getAlbum(String albumPid){
		return Converter.albumToDto(albumDao.getAlbum(albumPid));
	}
	
	public List<FullAlbumDTO> getAlbumsByArtist(int artistId){
		return Converter.albumListToDto(albumDao.getAlbumsByArtist(artistId));
	}
}
