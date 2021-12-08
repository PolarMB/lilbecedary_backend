package io.lilbecedary.lilbecedary_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.lilbecedary.lilbecedary_backend.dto.FullAlbumDTO;
import io.lilbecedary.lilbecedary_backend.service.AlbumService;

@RestController
@RequestMapping("/api/album")
public class AlbumController {
	
	private final AlbumService albumService;
	
	@Autowired
	public AlbumController(AlbumService albumService) {
		this.albumService = albumService;
	}
	
	@GetMapping
	public ResponseEntity<FullAlbumDTO> getAlbumById(
			@RequestParam String albumPid) {
		return ResponseEntity.ok(albumService.getAlbum(albumPid));
	}
	
	@GetMapping("/artist")
	public ResponseEntity<List<FullAlbumDTO>> getAlbumsByArtist(
			@RequestParam int artistId){
		return ResponseEntity.ok(albumService.getAlbumsByArtist(artistId));
	}

}
