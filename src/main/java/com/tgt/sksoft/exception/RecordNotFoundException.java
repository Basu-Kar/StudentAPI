package com.tgt.sksoft.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String exception) {
        super(exception);
    }
}
