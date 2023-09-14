package com.huike.exception;

/**
 * @author jy
 * @version 1.0
 * @date 2022/2/10 21:38
 */
public class LoginException extends RuntimeException{
    public LoginException(String ex){
        super(ex);
    }
}
