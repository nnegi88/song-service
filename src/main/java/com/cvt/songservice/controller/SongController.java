package com.cvt.songservice.controller;

import com.cvt.songservice.model.Song;
import com.cvt.songservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/playlists/{playlistId}")
    public List<Song> getAllSongsOfPlaylist(@PathVariable String playlistId){
        return songService.getAllSongsOfPlaylist(playlistId);
    }

    @GetMapping("{songId}")
    public Song getSongById(@PathVariable String songId){
        return songService.getSongById(songId);
    }

    @PostMapping
    public ResponseEntity<Object> saveSong(@Valid @RequestBody Song song){
        songService.saveSong(song);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(song.getSongId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{songId}")
    public void updateSong(@PathVariable String songId, @Valid @RequestBody Song song){
        songService.updateSongById(songId, song);
    }

    @DeleteMapping("{songId}")
    public void deleteSong(@PathVariable String songId){
        songService.deleteSong(songId);
    }
}
