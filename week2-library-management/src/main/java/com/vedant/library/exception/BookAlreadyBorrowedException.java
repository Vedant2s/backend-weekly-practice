package com.vedant.library.exception;
public class BookAlreadyBorrowedException extends Exception {
    public BookAlreadyBorrowedException(String msg) {
        super(msg);
    }
}