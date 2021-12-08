package io.lilbecedary.lilbecedary_backend.dao;

import java.util.List;

import io.lilbecedary.lilbecedary_backend.entity.Album;

public interface AlbumDAO {

	public Album getAlbum(String albumPid);
	public List<Album> getAlbumsByArtist(int artistId);
}
