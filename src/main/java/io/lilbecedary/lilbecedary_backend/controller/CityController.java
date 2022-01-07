package io.lilbecedary.lilbecedary_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.lilbecedary.lilbecedary_backend.dto.FullCityDTO;
import io.lilbecedary.lilbecedary_backend.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	@Autowired
	private CityService cityService;
	
	@GetMapping
	public List<FullCityDTO> getCities(
			@RequestParam(required=false) String name){
		
		if (name != null) {
			return cityService.getCitiesByName(name);
		}
		
		return cityService.getCities();
	}
	
}
