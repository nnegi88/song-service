package com.cvt.songservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Playlist not found")
public class PlaylistNotFoundException extends RuntimeException{
    public PlaylistNotFoundException(String playlistId){
        super("Playlist with playlistId "+playlistId+" is not found");
    }
}
