package io.lilbecedary.lilbecedary_backend.dao;

import java.util.List;

import io.lilbecedary.lilbecedary_backend.entity.City;

public interface CityDAO {
	
	public List<City> getCities();
	public List<City> getCitiesByName(String cityName);

}
