package com.cvt.songservice.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Song not found")
public class SongNotFoundException extends RuntimeException{
    public SongNotFoundException(String songId){
        super("Song with songId "+songId+" is not found");
    }
}
