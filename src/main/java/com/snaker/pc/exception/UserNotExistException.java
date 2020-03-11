package com.snaker.pc.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super(" user not exost");
        
    }
    public UserNotExistException(String str){
        super(str);
    }
}
