package com.cvt.songservice.service;

import com.cvt.songservice.model.Song;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    List<Song> getAllSongsOfPlaylist(String playlistId);
    Song getSongById(String songId);
    void saveSong(Song song);
    void updateSongById(String songId, Song song);
    void deleteSong(String songId);
}