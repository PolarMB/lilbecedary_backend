package io.lilbecedary.lilbecedary_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.lilbecedary.lilbecedary_backend.dto.FullSongDTO;
import io.lilbecedary.lilbecedary_backend.service.SongService;

@RestController
@RequestMapping("/api/song")
public class SongController {
	
	private final SongService songService;
	
	@Autowired
	public SongController(SongService songService) {
		this.songService = songService;
	}

	@GetMapping
	public ResponseEntity<FullSongDTO> getSong(@RequestParam String songPid){
		return ResponseEntity.ok(songService.getSong(songPid));
	}
	
}
