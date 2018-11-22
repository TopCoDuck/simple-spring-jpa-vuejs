package com.example.member.exception;

public class AlreadyBanMember extends RuntimeException {
    public AlreadyBanMember(final String message) {
        super(message);
    }
}
