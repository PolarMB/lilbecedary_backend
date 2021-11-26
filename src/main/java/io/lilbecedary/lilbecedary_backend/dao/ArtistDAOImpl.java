package io.lilbecedary.lilbecedary_backend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.lilbecedary.lilbecedary_backend.entity.Artist;

@Repository
public class ArtistDAOImpl implements ArtistDAO {

	@Autowired
	private EntityManager factory;
	
	@Override
	public List<Artist> getArtists() {
		
		Session session = factory.unwrap(Session.class);
		Query<Artist> artistQuery = session.createQuery("FROM Artist", Artist.class);
		
		return artistQuery.getResultList();
	}

	@Override
	public Artist getArtistById(String id) {

		Session session = factory.unwrap(Session.class);
		
		return session.byNaturalId(Artist.class).using("artistPid", id).load();
	}

}
