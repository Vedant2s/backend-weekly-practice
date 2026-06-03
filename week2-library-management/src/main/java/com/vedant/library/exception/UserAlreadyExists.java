package com.vedant.library.exception;
public class UserAlreadyExists extends Exception {
    public UserAlreadyExists(String msg) {
        super(msg);
    }
}