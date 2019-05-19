package com.tgt.sksoft.exception;

//@ResponseStatus
public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String exception) {
        super(exception);
    }
}
