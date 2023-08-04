package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@AllArgsConstructor(staticName = "of")
@Data
public class RestResponse<E> {

    @JsonIgnore
    private HttpStatus httpStatus;
    private E response;
    private Map<String, String> errors;

}