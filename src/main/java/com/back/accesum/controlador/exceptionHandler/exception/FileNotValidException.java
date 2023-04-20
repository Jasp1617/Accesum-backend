package com.back.accesum.controlador.exceptionHandler.exception;

import java.io.IOException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class FileNotValidException extends IOException  {
    
    private String message;

    public FileNotValidException(String message){
        super(message);
        this.message = message;
    }

}
