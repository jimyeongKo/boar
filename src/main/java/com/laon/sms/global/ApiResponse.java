package com.laon.sms.global;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor

public class ApiResponse<T> {


    private HttpStatus status;
    private T data;

    public ApiResponse(HttpStatus status, T data){

        this.status = status;
        this.data = data;

    }
}
