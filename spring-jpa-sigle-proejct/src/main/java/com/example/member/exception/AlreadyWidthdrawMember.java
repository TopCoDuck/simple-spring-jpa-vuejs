package com.example.member.exception;

public class AlreadyWidthdrawMember extends RuntimeException {
    public AlreadyWidthdrawMember(final String message) {
        super(message);
    }
}
