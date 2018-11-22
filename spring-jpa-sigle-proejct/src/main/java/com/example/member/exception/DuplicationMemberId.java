package com.example.member.exception;

public class DuplicationMemberId extends RuntimeException {
    public DuplicationMemberId(final String message) {
        super(message);
    }
}
