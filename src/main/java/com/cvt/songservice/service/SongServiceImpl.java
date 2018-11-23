package com.cvt.songservice.service;

import com.cvt.songservice.dal.SongDal;
import com.cvt.songservice.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    private SongDal songDal;

    @Override
    public List<Song> getAllSongs(){
        return songDal.getAllSongs();
    }

    @Override
    public List<Song> getAllSongsOfPlaylist(String playlistId){
        return songDal.getAllSongsOfPlaylist(playlistId);
    }

    @Override
    public Song getSongById(String songId){
        return songDal.getSongById(songId);
    }

    @Override
    public void saveSong(Song song){
        songDal.saveSong(song);
    }

    @Override
    public void updateSongById(String songId, Song song) {
        songDal.updateSongById(songId, song);
    }

    @Override
    public void deleteSong(String songId){
        songDal.deleteSong(songId);
    }
}
