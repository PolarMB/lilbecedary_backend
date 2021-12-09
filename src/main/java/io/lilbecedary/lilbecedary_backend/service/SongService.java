package io.lilbecedary.lilbecedary_backend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lilbecedary.lilbecedary_backend.dao.SongDAO;
import io.lilbecedary.lilbecedary_backend.dto.FullSongDTO;
import io.lilbecedary.lilbecedary_backend.util.Converter;

@Service
@Transactional
public class SongService {

	@Autowired
	SongDAO songDao;
	
	public FullSongDTO getSong(String songPid) {
		return Converter.songToDto(songDao.getSong(songPid));
	}
	
}
