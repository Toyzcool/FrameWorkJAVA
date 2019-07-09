package com.Exception;

import lombok.Data;

@Data
public class SysException extends Exception{
    private String message;

    public SysException(String message) {
        this.message = message;
    }
}
