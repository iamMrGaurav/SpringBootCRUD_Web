package com.teispace.simpleblog.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;


@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {

    private final String message;
    private final HttpStatus status;
    private final ZonedDateTime timeStamp;

}
