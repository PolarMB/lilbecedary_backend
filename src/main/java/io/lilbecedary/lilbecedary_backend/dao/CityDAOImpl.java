package io.lilbecedary.lilbecedary_backend.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.lilbecedary.lilbecedary_backend.entity.City;

@Repository
public class CityDAOImpl implements CityDAO {
	
	@Autowired
	private EntityManager factory;

	@Override
	public List<City> getCities() {
		
		Session session = factory.unwrap(Session.class);
		
		Query<City> citiesQuery = session.createQuery("FROM City", City.class);
		
		return citiesQuery.getResultList();
	}

	@Override
	public List<City> getCitiesByName(String cityName) {

		Session session = factory.unwrap(Session.class);
		Query<City> citiesQuery = session.createQuery("FROM City WHERE city_name LIKE :cityName", City.class);
		
		citiesQuery.setParameter("cityName", cityName+"%");
		
		return citiesQuery.getResultList();
	}

}
