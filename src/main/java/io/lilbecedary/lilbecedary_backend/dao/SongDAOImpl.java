package io.lilbecedary.lilbecedary_backend.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.lilbecedary.lilbecedary_backend.entity.Song;

@Repository
public class SongDAOImpl implements SongDAO {
	
	@Autowired
	EntityManager factory;

	@Override
	public Song getSong(String songPid) {
		Session session = factory.unwrap(Session.class);
		
		return session.byNaturalId(Song.class).using("songPid", songPid).load();
	}

}
