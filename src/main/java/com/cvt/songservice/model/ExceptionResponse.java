package com.cvt.songservice.model;

public class ExceptionResponse {
    private int code;
    private String description;

    public ExceptionResponse(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
