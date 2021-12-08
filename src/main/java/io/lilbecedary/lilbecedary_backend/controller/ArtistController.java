package io.lilbecedary.lilbecedary_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.lilbecedary.lilbecedary_backend.dto.ArtistDTO;
import io.lilbecedary.lilbecedary_backend.service.ArtistService;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

	private final ArtistService artistService;
	
	@Autowired
	public ArtistController(ArtistService artistService) {
		this.artistService = artistService;
	}
	
	@GetMapping
	public ResponseEntity<List<ArtistDTO>> getArtists(){
		return ResponseEntity.ok(artistService.getArtists());
	}
	
	@GetMapping(value="/{public_id}")
	public ResponseEntity<ArtistDTO> getArtistById(@PathVariable("public_id") String id) {
		return ResponseEntity.ok(artistService.getArtistById(id));
	}
	
	
}
