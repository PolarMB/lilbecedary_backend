package io.lilbecedary.lilbecedary_backend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.lilbecedary.lilbecedary_backend.entity.Album;

@Repository
public class AlbumDAOImpl implements AlbumDAO {
	
	@Autowired
	private EntityManager factory;
	
	@Override
	public Album getAlbum(String albumPid) {
		
		Session session = factory.unwrap(Session.class);
		
		return session.byNaturalId(Album.class).using("albumPid", albumPid).load();
	}

	@Override
	public List<Album> getAlbumsByArtist(int artistId) {

		Session session = factory.unwrap(Session.class);
		Query<Album> albumQuery = session.createQuery("FROM Album WHERE artist_id=:artistId", Album.class);
		albumQuery.setParameter("artistId", artistId);
		
		return albumQuery.getResultList();
	}
	
	

}
