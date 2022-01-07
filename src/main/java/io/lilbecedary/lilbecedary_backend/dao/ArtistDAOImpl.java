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
	
	public List<Artist> getArtistByAlias(String alias) {
		
		Session session = factory.unwrap(Session.class);
		Query<Artist> artistQuery = session.createQuery("FROM Artist WHERE alias=:alias", Artist.class);
		artistQuery.setParameter("alias", alias);
		
		
		return artistQuery.getResultList();
		
	}
	
	public List<Artist> getArtistsByStatus(String status) {
		
		Session session = factory.unwrap(Session.class);
		Query<Artist> artistQuery = session.createQuery("FROM Artist WHERE status=:status", Artist.class);
		artistQuery.setParameter("status", status);
		
		return artistQuery.getResultList();
	}

}
