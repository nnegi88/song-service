package com.cvt.songservice.dal;

import com.cvt.songservice.model.PlaylistNotFoundException;
import com.cvt.songservice.model.Song;
import com.cvt.songservice.model.SongNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongDalImpl implements SongDal {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    public SongDalImpl(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Song> getAllSongs() {
        return mongoTemplate.findAll(Song.class);
    }

    @Override
    public List<Song> getAllSongsOfPlaylist(String playlistId) throws PlaylistNotFoundException {
        Query query = new Query();
        query.addCriteria(Criteria.where("playlistId").is(playlistId));
        List<Song> songs = mongoTemplate.find(query, Song.class);
        if (songs==null) throw new PlaylistNotFoundException(playlistId);
        return songs;
    }

    @Override
    public Song getSongById(String songId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(songId));
        Song song = mongoTemplate.findOne(query, Song.class);
        if (song==null) throw new SongNotFoundException(songId);
        return song;
    }

    @Override
    public void saveSong(Song song) {
        mongoTemplate.save(song);
    }

    @Override
    public void updateSongById(String songId, Song song) {
        Song updatedSong = getSongById(songId);
        updatedSong = song;
        mongoTemplate.save(updatedSong);
    }

    @Override
    public void deleteSong(String songId) {
        mongoTemplate.remove(getSongById(songId));
    }
}
