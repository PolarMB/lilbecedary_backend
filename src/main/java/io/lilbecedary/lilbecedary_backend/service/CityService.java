package io.lilbecedary.lilbecedary_backend.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lilbecedary.lilbecedary_backend.dao.CityDAO;
import io.lilbecedary.lilbecedary_backend.dto.FullCityDTO;
import io.lilbecedary.lilbecedary_backend.util.Converter;

@Service
@Transactional
public class CityService {
	
	@Autowired
	private CityDAO cityDao;
	
	public List<FullCityDTO> getCities() {
		return Converter.cityListToDto(cityDao.getCities());
	}
	
	public List<FullCityDTO> getCitiesByName(String cityName) {
		return Converter.cityListToDto(cityDao.getCitiesByName(cityName));
	}

}
