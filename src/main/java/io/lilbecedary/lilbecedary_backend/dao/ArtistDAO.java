package io.lilbecedary.lilbecedary_backend.dao;

import java.util.List;
import io.lilbecedary.lilbecedary_backend.entity.Artist;

public interface ArtistDAO {

	public List<Artist> getArtists();
	public Artist getArtistById(String id);
	public List<Artist> getArtistByAlias(String alias);
	public List<Artist> getArtistsByStatus(String status);
}
