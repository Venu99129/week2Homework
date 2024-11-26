package com.week2.Week2HomeWork.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdAt;

    private T data;

    private ApiError error;

    public ApiResponse(){
        this.createdAt = LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error){
        this();
        this.error = error;
    }
}
